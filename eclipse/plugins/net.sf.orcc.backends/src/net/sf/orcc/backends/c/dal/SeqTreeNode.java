package net.sf.orcc.backends.c.dal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import net.sf.orcc.df.Action;
import net.sf.orcc.ir.Instruction;

/**
 * A node in the peek sequence tree.
 *
 * @author James Guthrie
 *
 */
public class SeqTreeNode{

	private GuardConstraint constraints;
	private Set<Action> actions;
	private Set<Instruction> processed;
	private List<SeqTreeNode> children;

	SeqTreeNode(GuardConstraint constraints, Set<Action> actions, Set<Instruction> tokens){
		this.setConstraints(constraints);
		this.setProcessed(tokens);
		this.actions = new HashSet<Action>(actions);
		this.children = new ArrayList<SeqTreeNode>();
	}

	SeqTreeNode(Collection<Action> actions){
		this.constraints = null;
		this.processed = new HashSet<Instruction>();
		this.actions = new HashSet<Action>(actions);
		this.children = new ArrayList<SeqTreeNode>();
	}

	SeqTreeNode(GuardConstraint constraints, Action action, Set<Instruction> tokens){
		this.setConstraints(constraints);
		this.setProcessed(tokens);
		this.actions = new TreeSet<Action>();
		this.children = new ArrayList<SeqTreeNode>();
		actions.add(action);
	}

	public SeqTreeNode() {
	}

	public GuardConstraint getConstraints() {
		return constraints;
	}

	public void setConstraints(GuardConstraint constraints) {
		this.constraints = new GuardConstraint(constraints);
	}

	public Set<Instruction> getProcessed() {
		return this.processed;
	}

	public void setProcessed(Set<Instruction> processed) {
		this.processed = new HashSet<Instruction>(processed);
	}

	public Set<Action> getActions(){
		return actions;
	}

	public List<SeqTreeNode> getChildren() {
		return children;
	}

	public void addChild(SeqTreeNode child) {
		this.children.add(child);
	}

	public void removeChild(SeqTreeNode child) {
		this.children.remove(child);
	}

	public void addChild(GuardConstraint constraints, Set<Instruction> tokens, Set<Action> actions){
		SeqTreeNode child = new SeqTreeNode(constraints, actions, tokens);
		this.children.add(child);
	}

	public void addChild(GuardConstraint constraints, Set<Instruction> tokens, Action action){
		Set<Action> s = new TreeSet<Action>();
		s.add(action);
		addChild(constraints, tokens, s);
	}
}
