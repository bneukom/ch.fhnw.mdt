package ch.fhnw.mdt.ui.highlighting;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

import ch.fhnw.mdt.uForth.IntrinsicArithmeticWords;
import ch.fhnw.mdt.uForth.IntrinsicMemoryWords;
import ch.fhnw.mdt.uForth.IntrinsicStackWords;

public class ForthSemanticHighlightingCalculator implements ISemanticHighlightingCalculator {

	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		if (resource == null)
			return;

		Iterator<EObject> iter = EcoreUtil.getAllContents(resource, true);
		while (iter.hasNext()) {
			EObject current = iter.next();
			ICompositeNode node = NodeModelUtils.getNode(current);

			if (current instanceof IntrinsicMemoryWords) {
				acceptor.addPosition(node.getOffset(), node.getLength(), ForthHighlightingConfiguration.KEYWORD_MEMORY_ID);
			} else if (current instanceof IntrinsicArithmeticWords) {
				acceptor.addPosition(node.getOffset(), node.getLength(), ForthHighlightingConfiguration.KEYWORD_ARITHMETIC_ID);
			} else if (current instanceof IntrinsicStackWords) {
				acceptor.addPosition(node.getOffset(), node.getLength(), ForthHighlightingConfiguration.KEYWORD_STACK_ID);
			}
		}
	}
}