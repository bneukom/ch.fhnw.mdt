package ch.fhnw.mdt.ui.fortheditor;

import org.eclipse.ui.editors.text.TextEditor;

public class ForthEditor extends TextEditor {

	private ColorManager colorManager;

	public ForthEditor() {
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new ForthConfiguration(colorManager));
		setDocumentProvider(new ForthDocumentProvider());
	}

	@Override
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
