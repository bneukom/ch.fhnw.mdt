package ch.fhnw.mdt.ui.documentation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

import ch.fhnw.mdt.uForth.Word;
import ch.fhnw.mdt.ui.UForthUiModule;

public class ForthHoverProvider extends DefaultEObjectHoverProvider {
	@Override
	protected String getFirstLine(EObject o) {
		if (o instanceof Word) {
			final Word word = (Word) o;
			return UForthUiModule.getDocumentation(word.getName()).map(d -> d.header).orElse(word.getName());
		}
		return "";
	}
}
