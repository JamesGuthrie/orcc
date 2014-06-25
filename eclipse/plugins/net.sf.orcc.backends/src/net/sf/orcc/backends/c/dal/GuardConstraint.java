package net.sf.orcc.backends.c.dal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import net.sf.orcc.OrccRuntimeException;
import net.sf.orcc.df.Action;
import net.sf.orcc.df.Tag;
import net.sf.orcc.ir.Block;
import net.sf.orcc.ir.BlockBasic;
import net.sf.orcc.ir.ExprBinary;
import net.sf.orcc.ir.ExprUnary;
import net.sf.orcc.ir.ExprVar;
import net.sf.orcc.ir.Expression;
import net.sf.orcc.ir.InstAssign;
import net.sf.orcc.ir.InstCall;
import net.sf.orcc.ir.InstLoad;
import net.sf.orcc.ir.InstReturn;
import net.sf.orcc.ir.Instruction;
import net.sf.orcc.ir.IrFactory;
import net.sf.orcc.ir.OpBinary;
import net.sf.orcc.ir.OpUnary;
import net.sf.orcc.ir.Procedure;
import net.sf.orcc.ir.Var;
import net.sf.orcc.ir.impl.IrFactoryImpl;
import net.sf.orcc.ir.util.AbstractIrVisitor;
import net.sf.orcc.ir.util.IrUtil;

/**
 * Helper class to encapsulate an actor's guard constraints.
 *
 * @author James Guthrie
 *
 */
public class GuardConstraint {
	protected List<Instruction> instructions;

	protected List<Token> stateTokens;
	protected Set<Token> inputTokens;
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
		setInstructions(this.instructions);
		this.name = g.name;
	}

	/**
	 * Given an Action a and set of tokens, return the constraints
	 * of a which are dependent on the given tokens
	 *
	 * @param a
	 * @param intersection
	 * @return
	 */
	public GuardConstraint(Action a, Set<Token> tokens) {
		List<Instruction> constInst = new ArrayList<Instruction>();
		Set<Var> vars = new HashSet<Var>();
		Collection<Block> blocks = IrUtil.copy(a.getScheduler().getBlocks());
		for (Block b : blocks) {
			if (b.isBlockBasic()) {
				for (Instruction i : ((BlockBasic) b).getInstructions()) {
					if (i instanceof InstLoad || i instanceof InstCall) {
						Token local_t;
						if (i instanceof InstLoad) {
							local_t = new LoadTokenImpl((InstLoad) i);
						} else {
							local_t = new CallTokenImpl((InstCall) i);
						}
						for (Token t : tokens) {
							if (local_t.compareTo(t) == 0) {
								vars.add(local_t.getTargetVar());
								constInst.add(i);
							}
						}
					}
				}
				for (Instruction i : ((BlockBasic) b).getInstructions()) {
					if (i instanceof InstAssign) {
						Expression removedVars = new VarRemover(vars).doSwitch(((InstAssign) i).getValue());
						((InstAssign) i).setValue(removedVars);
						constInst.add(i);
					} else if (i instanceof InstReturn) {
						constInst.add(i);
					}
				}
			}
		}
		this.instructions = constInst;
		setInstructions(this.instructions);
		this.name = a.getName();
	}

	/**
	 * Retains occurrences of Var in an Expression tree, returning
	 * the resulting expression.
	 *
	 * @author James Guthrie
	 *
	 */
	private class VarRemover extends AbstractIrVisitor<Expression> {

		private List<Var> vars;
		private Expression empty;
		private IrFactory irFactory;

		/**
		 * Creates an instance of the remover with the <code>Var</code> instances
		 * to keep stored in vars.
		 *
		 * @param vars The vars to retain in the expression tree
		 */
		VarRemover(Collection<? extends Var> vars) {
			super(true);
			this.vars = new ArrayList<Var>(vars);
			irFactory = new IrFactoryImpl();
			empty = irFactory.createExprBool(true);
		}

		@Override
		public Expression caseExpression(Expression expr) {
			return expr;
		}

		@Override
		public Expression caseExprVar(ExprVar exprVar) {
			if (vars.contains(exprVar.getUse().getVariable())){
				return exprVar;
			} else {
				return empty;
			}
		}

		@Override
		public Expression caseExprBinary(ExprBinary exprBinary) {
			Expression left = doSwitch(exprBinary.getE1());
			Expression right = doSwitch(exprBinary.getE2());
			Expression nonNull = null;
			if (left == empty) {
				if (right == empty) {
					return empty;
				}
				nonNull = right;
			} else if (right == empty) {
				nonNull = left;
			}
			if (nonNull == null) {
				return irFactory.createExprBinary(left, exprBinary.getOp(), right, exprBinary.getType());
			} else {
				switch (exprBinary.getOp()) {
				case LOGIC_AND:
				case LOGIC_OR:
					return nonNull;
				default:
					return empty;
				}
			}
		}

		@Override
		public Expression caseExprUnary(ExprUnary exprUnary) {
			Expression expr = doSwitch(exprUnary.getExpr());
			if (expr == empty) {
				return irFactory.createExprBool(true);
			} else {
				exprUnary.setExpr(expr);
				return exprUnary;
			}
		}
	}

	private void setInstructions(List<Instruction> instructions) {
		this.stateTokens = new ArrayList<Token>();
		this.inputTokens = new TreeSet<Token>();
		int count = 0;
		Token t;
		for (Instruction i : instructions) {
			if (i instanceof InstLoad || i instanceof InstCall) {
				if (i instanceof InstLoad) {
					t = new LoadTokenImpl((InstLoad) i);
				} else {
					t = new CallTokenImpl((InstCall) i);
				}
				if (t.isStateToken()) {
					this.stateTokens.add(t);
				} else {
					this.inputTokens.add(t);
				}
			} else if (i instanceof InstReturn) {
				this.store = (InstReturn) i;
			} else if (i instanceof InstAssign) {
				this.compute = IrUtil.copy((InstAssign) i);
				count++;
				if (count > 1) {
					throw new OrccRuntimeException("Cannot handle multiple compute instructions");
				}
			}
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
		List<Token> allTokens = new ArrayList<Token>();

		allTokens.addAll(this.stateTokens);
		allTokens.addAll(this.inputTokens);
		allTokens.addAll(other.stateTokens);
		allTokens.addAll(other.inputTokens);

		IrFactory irFactory = new IrFactoryImpl();
		Expression thisVal = IrUtil.copy(this.compute.getValue());
		Expression otherVal = IrUtil.copy(other.compute.getValue());

		ExprBinary newVal = irFactory.createExprBinary(thisVal, OpBinary.LOGIC_AND, otherVal, irFactory.createTypeBool());

		InstAssign newAssign = irFactory.createInstAssign(this.compute.getTarget().getVariable(), newVal);

		List<Instruction> instructions = new ArrayList<Instruction>();
		for (Token t : allTokens) {
			instructions.add(t.getInstruction());
		}
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
		List<Token> allTokens = new ArrayList<Token>();

		allTokens.addAll(this.stateTokens);
		allTokens.addAll(this.inputTokens);
		allTokens.addAll(other.stateTokens);
		allTokens.addAll(other.inputTokens);

		IrFactory irFactory = new IrFactoryImpl();
		Expression thisVal = IrUtil.copy(this.compute.getValue());
		Expression otherVal = IrUtil.copy(other.compute.getValue());
		otherVal = irFactory.createExprUnary(OpUnary.LOGIC_NOT, otherVal, irFactory.createTypeBool());
		ExprBinary newVal = irFactory.createExprBinary(thisVal, OpBinary.LOGIC_AND, otherVal, irFactory.createTypeBool());

		InstAssign newAssign = irFactory.createInstAssign(this.compute.getTarget().getVariable(), newVal);

		List<Instruction> instructions = new ArrayList<Instruction>();
		for (Token t : allTokens) {
			instructions.add(t.getInstruction());
		}
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
		// Throw in the necessary global tokens
		for (Token t : this.stateTokens) {
				instructions.add(t.getInstruction());
		}
		// Keep everything except for the new InstAssign
		for (Block b : action.getScheduler().getBlocks()) {
			if (b instanceof BlockBasic) {
				for (Instruction i : ((BlockBasic) b).getInstructions()) {
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
		Tag t = IrUtil.copy(action.getTag());
		t.add(this.name);
		action.setTag(t);
	}

	/**
	 * Whether the constraints in this are equivalent to those
	 * in action.
	 *
	 * @param action
	 * @return
	 */
	public boolean equivalent(Action action) {
		Set<Token> tokens = new TreeSet<Token>();
		for (Block b : action.getScheduler().getBlocks()) {
			if (b instanceof BlockBasic) {
				for (Instruction i : ((BlockBasic) b).getInstructions()) {
					if (i instanceof InstLoad || i instanceof InstCall) {
						Token t;
						if (i instanceof InstLoad) {
							t = new LoadTokenImpl((InstLoad) i);
						} else {
							t = new CallTokenImpl((InstCall) i);
						}
						tokens.add(t);
					}
				}
			}
		}
		tokens.removeAll(this.stateTokens);
		tokens.removeAll(this.inputTokens);
		if (tokens.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return instructions.toString();
	}
}
