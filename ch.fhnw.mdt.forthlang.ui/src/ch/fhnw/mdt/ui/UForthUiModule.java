/*
 * generated by Xtext
 */
package ch.fhnw.mdt.ui;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.osgi.framework.Bundle;

import ch.fhnw.mdt.ui.documentation.ForthDocumentationProvider;
import ch.fhnw.mdt.ui.documentation.ForthHoverProvider;
import ch.fhnw.mdt.ui.highlighting.ForthAntlrTokenToAttributeIdMapper;
import ch.fhnw.mdt.ui.highlighting.ForthHighlightingConfiguration;
import ch.fhnw.mdt.ui.highlighting.ForthSemanticHighlightingCalculator;

/**
 * Use this class to register components to be used within the IDE.
 */
public class UForthUiModule extends ch.fhnw.mdt.ui.AbstractUForthUiModule {

	private static final int HEADER = 0;
	private static final int DOCUMENTATION = 1;
	private static final Map<String, Documentation> DOCUMENTATIONS = new HashMap<>();

	public UForthUiModule(final AbstractUIPlugin plugin) {
		super(plugin);

		loadDocumentation();
	}

	public static Optional<Documentation> getDocumentation(String word) {
		return Optional.ofNullable(DOCUMENTATIONS.get(word.toUpperCase()));
	}

	private static void loadDocumentation() {
		final Bundle bundle = Platform.getBundle("ch.fhnw.mdt.forthlang.ui");
		final URL fileURL = bundle.getEntry("uForthDoc/doc");
		try {
			final List<String> docLines = Files.readAllLines(Paths.get(FileLocator.toFileURL(fileURL).toURI()));

			int readerState = HEADER;
			String documentation = "";
			String header = "";

			for (String line : docLines) {
				switch (readerState) {
				case HEADER:
					header = escape(line);
					readerState = DOCUMENTATION;
					break;
				case DOCUMENTATION:
					if (line.trim().isEmpty()) { // empty line
						final String word = header.split("\\s+")[0];
						DOCUMENTATIONS.put(word.toUpperCase(), new Documentation("<b>" + header + "</b>", documentation));

						readerState = HEADER;
						documentation = "";
					} else { // documentation line
						documentation += escape(line) + "<br/>";
					}
				default:
					break;
				}
			}

		} catch (final URISyntaxException e1) {
			e1.printStackTrace();
		} catch (final IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private static String escape(String input) {
		return input.replaceAll("<","&#60;").replaceAll(">", "&#62;");
	}

	@Override
	public Class<? extends IXtextEditorCallback> bindIXtextEditorCallback() {
		return null;
	}

	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return ForthHighlightingConfiguration.class;
	}

	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return ForthAntlrTokenToAttributeIdMapper.class;
	}

	public Class<? extends ISemanticHighlightingCalculator> bindSemanticHighlightingCalculator() {
		return ForthSemanticHighlightingCalculator.class;
	}

	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return ForthHoverProvider.class;
	}

	public Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProviderr() {
		return ForthDocumentationProvider.class;
	}

	public static final class Documentation {
		public final String header;
		public final String documentation;

		public Documentation(final String header, final String documentation) {
			this.header = header;
			this.documentation = documentation;
		}
	}

}
