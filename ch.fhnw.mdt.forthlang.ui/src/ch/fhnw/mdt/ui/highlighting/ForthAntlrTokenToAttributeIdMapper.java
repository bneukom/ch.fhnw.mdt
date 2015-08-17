package ch.fhnw.mdt.ui.highlighting;

import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;

public class ForthAntlrTokenToAttributeIdMapper extends AbstractAntlrTokenToAttributeIdMapper {
	// private static final Pattern QUOTED = Pattern.compile("(?:^'(\\w[^']*)'$)|(?:^\"(\\w[^\"]*)\")$", Pattern.MULTILINE);

	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if (tokenName.equals("RULE_SL_COMMENT")) {
			return ForthHighlightingConfiguration.COMMENT_ID;
		} else if (tokenName.equals("RULE_INT") || tokenName.equals("RULE_DOUBLE")) {
			return ForthHighlightingConfiguration.NUMBER_ID;
		}
		return ForthHighlightingConfiguration.DEFAULT_ID;
	}
}