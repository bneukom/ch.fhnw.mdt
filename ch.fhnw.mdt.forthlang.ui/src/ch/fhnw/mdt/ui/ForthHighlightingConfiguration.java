package ch.fhnw.mdt.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class ForthHighlightingConfiguration implements IHighlightingConfiguration {
	public static final String DEFAULT_ID = "default";
	public static final String KEYWORD_ID = "keyword";
	public static final String METHOD_ID = "method";
	public static final String NUMBER_ID = "number";
	public static final String COMMENT_ID = "comment";

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(DEFAULT_ID, "Default", defaultTextStyle());
		acceptor.acceptDefaultHighlighting(KEYWORD_ID, "Keyword", keywordTextStyle());
		acceptor.acceptDefaultHighlighting(METHOD_ID, "Method", methodTextStyle());
		acceptor.acceptDefaultHighlighting(COMMENT_ID, "Comment", commentTextStyle());
		acceptor.acceptDefaultHighlighting(NUMBER_ID, "Number", numberTextStyle());
	}

	protected TextStyle commentTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(63, 127, 95));
		return textStyle;
	}

	protected TextStyle defaultTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(0, 0, 0));
		return textStyle;
	}

	protected TextStyle keywordTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 0, 85));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	protected TextStyle methodTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(85, 0, 127));
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}

	protected TextStyle numberTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 127, 127));
		return textStyle;
	}
}