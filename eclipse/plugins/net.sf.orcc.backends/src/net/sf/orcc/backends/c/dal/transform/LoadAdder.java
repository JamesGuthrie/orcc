package net.sf.orcc.backends.c.dal.transform;

import org.eclipse.emf.common.util.EMap;

import net.sf.orcc.df.Action;
import net.sf.orcc.df.Actor;
import net.sf.orcc.df.Network;
import net.sf.orcc.df.Pattern;
import net.sf.orcc.df.Port;
import net.sf.orcc.df.util.DfVisitor;
import net.sf.orcc.ir.Block;
import net.sf.orcc.ir.BlockBasic;
import net.sf.orcc.ir.InstLoad;
import net.sf.orcc.ir.IrFactory;
import net.sf.orcc.ir.Var;
import net.sf.orcc.ir.impl.IrFactoryImpl;

/**
 * Adds load instructions to schedulers of all actions
 *
 * @author James Guthrie
 *
 */
public class LoadAdder extends DfVisitor<Void> {

	@Override
	public Void caseAction(Action action) {
		// Produce a load token for each input variable of this action
		// solves the problem of the intersection of input tokens not
		// containing a token if it is not evaluated by the action.
		Pattern pattern = action.getInputPattern();
		EMap <Port, Var> m = pattern.getPortToVarMap();
		IrFactory irFactory = new IrFactoryImpl();
		for (Block b : action.getScheduler().getBlocks()) {
			if (b.isBlockBasic()) {
				for (Port port : m.keySet()) {
					Var v = m.get(port);
					for (int i = 0; i < pattern.getNumTokens(port); i++) {
						Var target = irFactory.createVar(port.getType(), "placeholder_name" , false, i);
						InstLoad load = irFactory.createInstLoad(target, v, i);
						((BlockBasic) b).add(0, load);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Void caseNetwork(Network network) {
		for (Actor actor : network.getAllActors()) {
			for (Action action : actor.getActions()) {
				doSwitch(action);
			}
		}
		return null;
	}
}
