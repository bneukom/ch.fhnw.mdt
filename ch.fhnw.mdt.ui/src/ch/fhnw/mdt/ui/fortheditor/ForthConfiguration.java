package ch.fhnw.mdt.ui.fortheditor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

import ch.fhnw.mdt.ui.fortheditor.scanners.ForthScanner;

public class ForthConfiguration extends SourceViewerConfiguration {
	private ForthScanner scanner;
	private ColorManager colorManager;

	public ForthConfiguration(ColorManager colorManager) {
		this.colorManager = colorManager;

		this.scanner = new ForthScanner(colorManager);
		this.scanner.setDefaultReturnToken(new Token(new TextAttribute(colorManager.getColor(IForthColorConstants.DEFAULT))));

	}
	
	@Override
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return new String[] { IDocument.DEFAULT_CONTENT_TYPE, ForthPartitionScanner.FORTH_COMMENT, ForthPartitionScanner.FORTH_NUMBER };
	}

	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		NonRuleBasedDamagerRepairer numberDamagerRepairer = new NonRuleBasedDamagerRepairer(new TextAttribute(colorManager.getColor(IForthColorConstants.NUMBER)));
		reconciler.setDamager(numberDamagerRepairer, ForthPartitionScanner.FORTH_NUMBER);
		reconciler.setRepairer(numberDamagerRepairer, ForthPartitionScanner.FORTH_NUMBER);

		NonRuleBasedDamagerRepairer ndr = new NonRuleBasedDamagerRepairer(new TextAttribute(colorManager.getColor(IForthColorConstants.COMMENT)));
		reconciler.setDamager(ndr, ForthPartitionScanner.FORTH_COMMENT);
		reconciler.setRepairer(ndr, ForthPartitionScanner.FORTH_COMMENT);

		return reconciler;
	}

}