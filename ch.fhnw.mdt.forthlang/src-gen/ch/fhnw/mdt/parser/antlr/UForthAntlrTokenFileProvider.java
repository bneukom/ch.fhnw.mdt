/*
 * generated by Xtext
 */
package ch.fhnw.mdt.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class UForthAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("ch/fhnw/mdt/parser/antlr/internal/InternalUForthParser.tokens");
	}
}
