package ch.fhnw.mdt.forthdebugger.util;

import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDefinition;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

public class ASTUtil {

	/**
	 * Returns the {@link IASTFunctionDefinition} at the given line number or <code>null</code>
	 * if no function definition exists at the given line number.
	 * 
	 * @param ast
	 *            the AST to get the function definition from
	 * @param lineNumber
	 *            the line number of the function to check
	 * @return
	 */
	public static IASTFunctionDefinition getFunctionDefinition(IASTTranslationUnit ast, int lineNumber) {
		final IASTDeclaration[] declarations = ast.getDeclarations();
		for (final IASTDeclaration astDeclaration : declarations) {
			if (astDeclaration instanceof IASTFunctionDefinition) {
				final IASTFunctionDefinition function = (IASTFunctionDefinition) astDeclaration;
				final IASTFileLocation fileLocation = astDeclaration.getFileLocation();
				final int startingLineNumber = fileLocation.getStartingLineNumber();

				// we are on a valid function declaration
				if (startingLineNumber == lineNumber) {
					return function;

				}
			}
		}

		return null;
	}

}
