/*
 * generated by Xtext
 */
package ch.fhnw.mdt.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;

/**
 * Use this class to register components to be used within the IDE.
 */
public class UForthUiModule extends ch.fhnw.mdt.ui.AbstractUForthUiModule {
	public UForthUiModule(AbstractUIPlugin plugin) {
		super(plugin);
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

}
