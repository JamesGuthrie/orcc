/*
 * generated by Xtext
 */
package net.sf.orcc.outline;

import java.util.List;

import net.sf.orcc.cal.Action;
import net.sf.orcc.cal.Actor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.transformer.AbstractDeclarativeSemanticModelTransformer;

/**
 * customization of the default outline structure
 * 
 */
public class CalTransformer extends AbstractDeclarativeSemanticModelTransformer {

	public ContentOutlineNode createNode(Actor actor,
			ContentOutlineNode parentNode) {
		ContentOutlineNode node = super.newOutlineNode(actor, parentNode);

		createNode(node, "Parameters", actor.getParameters());
		createNode(node, "Input ports", actor.getInputs());
		createNode(node, "Output ports", actor.getOutputs());
		createNode(node, "State variables", actor.getStateVariables());
		createNode(node, "Actions", actor.getActions());

		return node;
	}

	private void createNode(ContentOutlineNode parent, String name,
			EList<?> objects) {
//		ContentOutlineNode node = super.newOutlineNode(parent, name, null,
//				new Region(0, 0));
//		for (Object obj : objects) {
//			createNode((EObject) obj, node);
//		}
//		
//		node.setSelectionOffset(parent.getSelectionOffset());
//		node.setSelectionLength(parent.getSelectionLength());
	}

	public List<EObject> getChildren(Action action) {
		return NO_CHILDREN;
	}

	public List<EObject> getChildren(Actor actor) {
		return NO_CHILDREN;
	}

}
