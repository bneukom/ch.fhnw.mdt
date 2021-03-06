/**
 */
package ch.fhnw.mdt.uForth.util;

import ch.fhnw.mdt.uForth.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see ch.fhnw.mdt.uForth.UForthPackage
 * @generated
 */
public class UForthSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static UForthPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UForthSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = UForthPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case UForthPackage.FORTH:
      {
        Forth forth = (Forth)theEObject;
        T result = caseForth(forth);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UForthPackage.INSTRUCTION:
      {
        Instruction instruction = (Instruction)theEObject;
        T result = caseInstruction(instruction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UForthPackage.FUNCTION:
      {
        Function function = (Function)theEObject;
        T result = caseFunction(function);
        if (result == null) result = caseInstruction(function);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UForthPackage.CREATE:
      {
        Create create = (Create)theEObject;
        T result = caseCreate(create);
        if (result == null) result = caseInstruction(create);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UForthPackage.INTRINSIC_BRANCH_WORDS:
      {
        IntrinsicBranchWords intrinsicBranchWords = (IntrinsicBranchWords)theEObject;
        T result = caseIntrinsicBranchWords(intrinsicBranchWords);
        if (result == null) result = caseWord(intrinsicBranchWords);
        if (result == null) result = caseFunction(intrinsicBranchWords);
        if (result == null) result = caseInstruction(intrinsicBranchWords);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UForthPackage.INTRINSIC_STACK_WORDS:
      {
        IntrinsicStackWords intrinsicStackWords = (IntrinsicStackWords)theEObject;
        T result = caseIntrinsicStackWords(intrinsicStackWords);
        if (result == null) result = caseWord(intrinsicStackWords);
        if (result == null) result = caseFunction(intrinsicStackWords);
        if (result == null) result = caseInstruction(intrinsicStackWords);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UForthPackage.INTRINSIC_MEMORY_WORDS:
      {
        IntrinsicMemoryWords intrinsicMemoryWords = (IntrinsicMemoryWords)theEObject;
        T result = caseIntrinsicMemoryWords(intrinsicMemoryWords);
        if (result == null) result = caseWord(intrinsicMemoryWords);
        if (result == null) result = caseFunction(intrinsicMemoryWords);
        if (result == null) result = caseInstruction(intrinsicMemoryWords);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UForthPackage.INTRINSIC_ARITHMETIC_WORDS:
      {
        IntrinsicArithmeticWords intrinsicArithmeticWords = (IntrinsicArithmeticWords)theEObject;
        T result = caseIntrinsicArithmeticWords(intrinsicArithmeticWords);
        if (result == null) result = caseWord(intrinsicArithmeticWords);
        if (result == null) result = caseFunction(intrinsicArithmeticWords);
        if (result == null) result = caseInstruction(intrinsicArithmeticWords);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UForthPackage.WORD:
      {
        Word word = (Word)theEObject;
        T result = caseWord(word);
        if (result == null) result = caseFunction(word);
        if (result == null) result = caseInstruction(word);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Forth</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Forth</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseForth(Forth object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instruction</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instruction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstruction(Instruction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunction(Function object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Create</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Create</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCreate(Create object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Intrinsic Branch Words</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Intrinsic Branch Words</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntrinsicBranchWords(IntrinsicBranchWords object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Intrinsic Stack Words</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Intrinsic Stack Words</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntrinsicStackWords(IntrinsicStackWords object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Intrinsic Memory Words</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Intrinsic Memory Words</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntrinsicMemoryWords(IntrinsicMemoryWords object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Intrinsic Arithmetic Words</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Intrinsic Arithmetic Words</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntrinsicArithmeticWords(IntrinsicArithmeticWords object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Word</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Word</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWord(Word object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //UForthSwitch
