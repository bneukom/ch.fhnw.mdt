/*
 * generated by Xtext
 */
package ch.fhnw.mdt.serializer;

import ch.fhnw.mdt.services.UForthGrammarAccess;
import ch.fhnw.mdt.uForth.Create;
import ch.fhnw.mdt.uForth.Forth;
import ch.fhnw.mdt.uForth.Function;
import ch.fhnw.mdt.uForth.IntrinsicArithmeticWords;
import ch.fhnw.mdt.uForth.IntrinsicMemoryWords;
import ch.fhnw.mdt.uForth.IntrinsicStackWords;
import ch.fhnw.mdt.uForth.UForthPackage;
import ch.fhnw.mdt.uForth.Word;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public class UForthSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private UForthGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == UForthPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case UForthPackage.CREATE:
				sequence_Create(context, (Create) semanticObject); 
				return; 
			case UForthPackage.FORTH:
				sequence_Forth(context, (Forth) semanticObject); 
				return; 
			case UForthPackage.FUNCTION:
				sequence_Function(context, (Function) semanticObject); 
				return; 
			case UForthPackage.INTRINSIC_ARITHMETIC_WORDS:
				sequence_IntrinsicArithmeticWords(context, (IntrinsicArithmeticWords) semanticObject); 
				return; 
			case UForthPackage.INTRINSIC_MEMORY_WORDS:
				sequence_IntrinsicMemoryWords(context, (IntrinsicMemoryWords) semanticObject); 
				return; 
			case UForthPackage.INTRINSIC_STACK_WORDS:
				sequence_IntrinsicStackWords(context, (IntrinsicStackWords) semanticObject); 
				return; 
			case UForthPackage.WORD:
				sequence_Word(context, (Word) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID lit+=LITERAL*)
	 */
	protected void sequence_Create(EObject context, Create semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     instructions+=GlobalInstruction*
	 */
	protected void sequence_Forth(EObject context, Forth semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID words+=Word*)
	 */
	protected void sequence_Function(EObject context, Function semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name='+' | 
	 *         name='-' | 
	 *         name='*' | 
	 *         name='/' | 
	 *         name='2*' | 
	 *         name='2/' | 
	 *         name='u2/' | 
	 *         name='ROR' | 
	 *         name='DROR' | 
	 *         name='ROL' | 
	 *         name='DROL' | 
	 *         name='PACK' | 
	 *         name='UNPACK' | 
	 *         name='SHIFT' | 
	 *         name='ASHIFT' | 
	 *         name='2**' | 
	 *         name='0=' | 
	 *         name='0<>' | 
	 *         name='0<' | 
	 *         name='d0=' | 
	 *         name='NEGATE' | 
	 *         name='DNEGATE' | 
	 *         name='1+' | 
	 *         name='1-' | 
	 *         name='TRUE' | 
	 *         name='FALSE' | 
	 *         name='CELL+' | 
	 *         name='CELL-' | 
	 *         name='CARRY_RESET' | 
	 *         name='CARRY-SET' | 
	 *         name='ABS' | 
	 *         name='DABS' | 
	 *         name='EXTEND'
	 *     )
	 */
	protected void sequence_IntrinsicArithmeticWords(EObject context, IntrinsicArithmeticWords semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name='LD' | 
	 *         name='@' | 
	 *         name='ST' | 
	 *         name='!' | 
	 *         name='2@' | 
	 *         name='2!' | 
	 *         name='LLD' | 
	 *         name='L@' | 
	 *         name='LST' | 
	 *         name='L!' | 
	 *         name='TLD' | 
	 *         name='T@' | 
	 *         name='TST' | 
	 *         name='T!' | 
	 *         name='+ST' | 
	 *         name='+!' | 
	 *         name='INC' | 
	 *         name='DEC' | 
	 *         name='ON' | 
	 *         name='OFF' | 
	 *         name='ERASE' | 
	 *         name='FILL' | 
	 *         name='COUNT' | 
	 *         name='MOVE' | 
	 *         name='PLACE'
	 *     )
	 */
	protected void sequence_IntrinsicMemoryWords(EObject context, IntrinsicMemoryWords semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name='CLEAR' | 
	 *         name='DROP' | 
	 *         name='DUP' | 
	 *         name='?DUP' | 
	 *         name='SWAP' | 
	 *         name='NIP' | 
	 *         name='OVER' | 
	 *         name='ROT' | 
	 *         name='-ROT' | 
	 *         name='TUCK' | 
	 *         name='UNDER' | 
	 *         name='2DROP' | 
	 *         name='2DUP' | 
	 *         name='2SWAP' | 
	 *         name='2OVER' | 
	 *         name='RCLEAR' | 
	 *         name='R@' | 
	 *         name='r>' | 
	 *         name='>r' | 
	 *         name='RDROP'
	 *     )
	 */
	protected void sequence_IntrinsicStackWords(EObject context, IntrinsicStackWords semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=LITERAL | name=ID)
	 */
	protected void sequence_Word(EObject context, Word semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
