/**
 */
package ch.fhnw.mdt.uForth;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ch.fhnw.mdt.uForth.UForthPackage
 * @generated
 */
public interface UForthFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UForthFactory eINSTANCE = ch.fhnw.mdt.uForth.impl.UForthFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Forth</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Forth</em>'.
   * @generated
   */
  Forth createForth();

  /**
   * Returns a new object of class '<em>Global Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Global Instruction</em>'.
   * @generated
   */
  GlobalInstruction createGlobalInstruction();

  /**
   * Returns a new object of class '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function</em>'.
   * @generated
   */
  Function createFunction();

  /**
   * Returns a new object of class '<em>Create</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Create</em>'.
   * @generated
   */
  Create createCreate();

  /**
   * Returns a new object of class '<em>Intrinsic Stack Words</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Intrinsic Stack Words</em>'.
   * @generated
   */
  IntrinsicStackWords createIntrinsicStackWords();

  /**
   * Returns a new object of class '<em>Intrinsic Memory Words</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Intrinsic Memory Words</em>'.
   * @generated
   */
  IntrinsicMemoryWords createIntrinsicMemoryWords();

  /**
   * Returns a new object of class '<em>Intrinsic Arithmetic Words</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Intrinsic Arithmetic Words</em>'.
   * @generated
   */
  IntrinsicArithmeticWords createIntrinsicArithmeticWords();

  /**
   * Returns a new object of class '<em>Word</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Word</em>'.
   * @generated
   */
  Word createWord();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  UForthPackage getUForthPackage();

} //UForthFactory
