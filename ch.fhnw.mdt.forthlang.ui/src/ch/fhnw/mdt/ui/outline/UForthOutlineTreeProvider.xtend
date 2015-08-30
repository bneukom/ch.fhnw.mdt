/*
 * generated by Xtext
 */
package ch.fhnw.mdt.ui.outline

import ch.fhnw.mdt.uForth.Forth
import ch.fhnw.mdt.uForth.Function
import ch.fhnw.mdt.uForth.Word
import javax.inject.Inject
import org.eclipse.xtext.ui.IImageHelper
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import ch.fhnw.mdt.uForth.impl.WordImpl
import ch.fhnw.mdt.uForth.impl.FunctionImpl

/**
 * Customization of the default outline structure.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#outline
 */
class UForthOutlineTreeProvider extends DefaultOutlineTreeProvider {

	@Inject
	private IImageHelper imageHelper;

	override protected _image(Object modelElement) {
		if (modelElement instanceof Forth) {
			return imageHelper.getImage("forth.png")
		} else if (modelElement instanceof Word) {
			if (modelElement.words.size > 0) {
				return imageHelper.getImage("function.png")
			} else {
				return imageHelper.getImage("word.png")
			}
		}
		super._image(modelElement)
	}
}
