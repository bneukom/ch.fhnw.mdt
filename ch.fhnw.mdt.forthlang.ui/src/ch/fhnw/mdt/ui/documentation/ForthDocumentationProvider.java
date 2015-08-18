package ch.fhnw.mdt.ui.documentation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;

import ch.fhnw.mdt.uForth.Word;
import ch.fhnw.mdt.ui.UForthUiModule;

public class ForthDocumentationProvider implements IEObjectDocumentationProvider {

	@Override
	public String getDocumentation(EObject o) {
		if (o instanceof Word) {
			final Word word = (Word) o;
			return UForthUiModule.getDocumentation(word.getName()).map(d -> d.documentation).orElse("");
		}
		return "";
	}

}
