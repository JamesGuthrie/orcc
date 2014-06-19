package net.sf.orcc.backends.c.dal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import net.sf.orcc.df.Action;
import net.sf.orcc.ir.Block;
import net.sf.orcc.ir.BlockBasic;
import net.sf.orcc.ir.ExprBinary;
import net.sf.orcc.ir.ExprVar;
import net.sf.orcc.ir.Expression;
import net.sf.orcc.ir.InstAssign;
import net.sf.orcc.ir.InstLoad;
import net.sf.orcc.ir.InstReturn;
import net.sf.orcc.ir.Instruction;
import net.sf.orcc.ir.IrFactory;
import net.sf.orcc.ir.OpBinary;
import net.sf.orcc.ir.OpUnary;
import net.sf.orcc.ir.Procedure;
import net.sf.orcc.ir.Var;
import net.sf.orcc.ir.impl.IrFactoryImpl;
import net.sf.orcc.ir.util.IrUtil;

/**
 * Helper class to encapsulate an actor's guard constraints.
 *
 * @author James Guthrie
 *
 */
public class GuardConstraint {
	protected List<Instruction> instructions;

	protected Set<InstLoad> loads;
	protected InstAssign compute;
	protected InstReturn store;
	protected String name;

	public GuardConstraint(List<Instruction> instructions, String name) {
		this.instructions = new ArrayList<Instruction>(IrUtil.copy(instructions));
		setInstructions(this.instructions);
		this.name = name;
	}

	public GuardConstraint(GuardConstraint g) {
		this.instructions = new ArrayList<Instruction>(IrUtil.copy(g.instructions));
		this.name = g.name;
		setInstructions(this.instructions);
	}

	/**
	 * Given an Action a and set of InstLoad tokens, return the constraints
	 * of a which are dependent on the InstLoads in tokens
	 *
	 * @param a
	 * @param intersection
	 * @return
	 */
	public GuardConstraint(Action a, Set<InstLoad> tokens) {
		List<Instruction> constInst = new ArrayList<Instruction>();
		Set<Var> vars = new HashSet<Var>();
		List<Block> blocks = (List<Block>) IrUtil.copy(a.getScheduler().getBlocks());
		for (Block b : blocks) {
			if (b.isBlockBasic()) {
				for (Instruction i : ((BlockBasic) b).getInstructions()) {
					if (i instanceof InstLoad) {
						for (InstLoad t : tokens) {
							InstLoadComparator comparator = new InstLoadComparator();
							if (comparator.compare((InstLoad) i, t) == 0) {
								vars.add(((InstLoad) i).getTarget().getVariable());
								constInst.add(i);
							}
						}
					}
				}
				for (Instruction i : ((BlockBasic) b).getInstructions()) {
					if (i instanceof InstAssign && ((InstAssign)i).getValue() instanceof ExprBinary) {
						ExprBinary constExpr = keepConstraints(((ExprBinary)((InstAssign)i).getValue()), vars);
						if (constExpr != null) {
							((InstAssign) i).setValue(constExpr);
							constInst.add(i);
						}
					} else if (i instanceof InstReturn) {
						constInst.add(i);
					}
				}
			}
		}
		this.instructions = constInst;
		this.name = a.getName();
	}

	private void setInstructions(List<Instruction> instructions) {
		this.loads = new TreeSet<InstLoad>(new InstLoadComparator());
		int count = 0;
		for (Instruction i : instructions) {
			if (i instanceof InstLoad) {
				loads.add((InstLoad) i);
			} else if (i instanceof InstReturn) {
				this.store = (InstReturn) i;
			} else if (i instanceof InstAssign) {
				this.compute = IrUtil.copy((InstAssign) i);
				count++;
				if (count > 1) {
					System.out.println("cannot handle multiple compute instructions yet");
				}
			}
		}
	}

	/**
	 * Given a binary expression tree, remove all expressions which
	 * operate on variables which are not defined in vars
	 */
	private ExprBinary keepConstraints(ExprBinary constraints, Set<Var> vars) {
		Expression e1 = constraints.getE1();
		Expression e2 = constraints.getE2();
		ExprBinary eb1, eb2;
		if (e1 instanceof ExprBinary && e2 instanceof ExprBinary && constraints.getOp().compareTo(OpBinary.LOGIC_AND) == 0) {
			eb1 = keepConstraints((ExprBinary) e1, vars);
			eb2 = keepConstraints((ExprBinary) e2, vars);
			if (eb1 == null) {
				if (eb2 == null) {
					return null;
				} else {
					return eb2;
				}
			} else {
				if (eb2 == null){
					return eb1;
				} else {
					return constraints;
				}
			}
		} else {
			if (e1 instanceof ExprVar) {
				for (Var v : vars) {
					if (((ExprVar) e1).getUse().getVariable().getName().equals(v.getName())){
						return constraints;
					}
				}
				return null;
			}
			if (e2 instanceof ExprVar) {
				for (Var v : vars) {
					if (((ExprVar) e2).getUse().getVariable().getName().equals(v.getName())){
						return constraints;
					}
				}
				return null;
			}
			System.out.println("Unable to handle operator: " + constraints.getOp().toString());
			return null;
		}
	}

	/**
	 * Given a GuardConstraint intersect the constraints return a constraint
	 * representing the common constraints.
	 *
	 * @param other
	 * @return
	 */
	public GuardConstraint intersect(GuardConstraint other) {
		Set<InstLoad> allLoads = new TreeSet<InstLoad>(new InstLoadComparator());

		allLoads.addAll(this.loads);
		allLoads.addAll(other.loads);
		IrFactory irFactory = new IrFactoryImpl();
		Expression thisVal = IrUtil.copy(this.compute.getValue());
		Expression otherVal = IrUtil.copy(other.compute.getValue());

		/*for (InstLoad l : this.loads) {
			Var v = l.getSource().getVariable();
			for (InstLoad o : other.loads) {
				new VisitReplaceVar(v).doSwitch(o);
			}
		}*/

		ExprBinary newVal = irFactory.createExprBinary(thisVal, OpBinary.LOGIC_AND, otherVal, irFactory.createTypeBool());

		InstAssign newAssign = irFactory.createInstAssign(this.compute.getTarget().getVariable(), newVal);

		List<Instruction> instructions = new ArrayList<Instruction>(allLoads);
		instructions.add(newAssign);
		instructions.add(IrUtil.copy(this.store));
		return new GuardConstraint(instructions, this.name + "_with_" + other.name);
	}

	/**
	 * Given a GuardConstraint return the difference of this constraint with other:
	 * this \other.
	 *
	 * @param other
	 * @return
	 */
	public GuardConstraint difference(GuardConstraint other) {
		Set<InstLoad> allLoads = new TreeSet<InstLoad>(new InstLoadComparator());

		allLoads.addAll(this.loads);
		allLoads.addAll(other.loads);

		IrFactory irFactory = new IrFactoryImpl();
		Expression thisVal = IrUtil.copy(this.compute.getValue());
		Expression otherVal = IrUtil.copy(other.compute.getValue());
		otherVal = irFactory.createExprUnary(OpUnary.LOGIC_NOT, otherVal, irFactory.createTypeBool());
		ExprBinary newVal = irFactory.createExprBinary(thisVal, OpBinary.LOGIC_AND, otherVal, irFactory.createTypeBool());

		InstAssign newAssign = irFactory.createInstAssign(this.compute.getTarget().getVariable(), newVal);

		List<Instruction> instructions = new ArrayList<Instruction>(allLoads);
		instructions.add(newAssign);
		instructions.add(IrUtil.copy(this.store));
		return new GuardConstraint(instructions, this.name + "_without_" + other.name);
	}

	/**
	 * The instructions required to execute this constraint
	 * @return
	 */
	public Collection<Instruction> toInstruction() {
		return new ArrayList<Instruction>(instructions);
	}

	/**
	 * Set the modify the instructions of action to reflect the
	 * constraints in this object
	 * @param action
	 */
	public void setConstraint(Action action) {
		List<Instruction> instructions = new ArrayList<Instruction>();
		// Keep everything except for the new InstAssign
		for (Block b : action.getScheduler().getBlocks()) {
			if (b instanceof BlockBasic) {
				for (Instruction i : ((BlockBasic)b).getInstructions()) {
					if (i instanceof InstAssign) {
						instructions.add(compute);
					} else {
						instructions.add(i);
					}
				}
			}
		}
		IrFactory irFactory = new IrFactoryImpl();
		Procedure sched = irFactory.createProcedure("isSchedulable_" + this.name, 0, irFactory.createTypeBool());
		BlockBasic lbb = irFactory.createBlockBasic();
		lbb.getInstructions().addAll(instructions);
		sched.getBlocks().add(lbb);
		action.setScheduler(sched);
	}
}
