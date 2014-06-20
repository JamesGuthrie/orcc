package net.sf.orcc.backends.c.dal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import net.sf.orcc.df.Action;
import net.sf.orcc.ir.InstLoad;

/**
 * A node in the peek sequence tree.
 *
 * @author James Guthrie
 *
 */
public class SeqTreeNode{

	private GuardConstraint constraints;
	private Set<Action> actions;
	private Set<InstLoad> processed;
	private List<SeqTreeNode> children;

	SeqTreeNode(GuardConstraint constraints, Set<Action> actions, Set<InstLoad> tokens){
		this.setConstraints(constraints);
		this.setProcessed(tokens);
		this.actions = new HashSet<Action>(actions);
		this.children = new ArrayList<SeqTreeNode>();
	}

	SeqTreeNode(Collection<Action> actions){
		this.constraints = null;
		this.processed = new TreeSet<InstLoad>(new InstLoadComparator());
		this.actions = new HashSet<Action>(actions);
		this.children = new ArrayList<SeqTreeNode>();
	}

	SeqTreeNode(GuardConstraint constraints, Action action, Set<InstLoad> tokens){
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

	public Set<InstLoad> getProcessed() {
		return this.processed;
	}

	public void setProcessed(Set<InstLoad> processed) {
		Set<InstLoad> temp = new HashSet<InstLoad>(processed);
		this.processed = new TreeSet<InstLoad>(new InstLoadComparator());
		this.processed.addAll(temp);
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

	public void addChild(GuardConstraint constraints, Set<InstLoad> tokens, Set<Action> actions){
		SeqTreeNode child = new SeqTreeNode(constraints, actions, tokens);
		this.children.add(child);
	}

	public void addChild(GuardConstraint constraints, Set<InstLoad> tokens, Action action){
		Set<Action> s = new TreeSet<Action>();
		s.add(action);
		addChild(constraints, tokens, s);
	}
}
