/**
 */
package ch.fhnw.mdt.uForth.impl;

import ch.fhnw.mdt.uForth.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UForthFactoryImpl extends EFactoryImpl implements UForthFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UForthFactory init()
  {
    try
    {
      UForthFactory theUForthFactory = (UForthFactory)EPackage.Registry.INSTANCE.getEFactory(UForthPackage.eNS_URI);
      if (theUForthFactory != null)
      {
        return theUForthFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new UForthFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UForthFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case UForthPackage.FORTH: return createForth();
      case UForthPackage.GLOBAL_INSTRUCTION: return createGlobalInstruction();
      case UForthPackage.FUNCTION: return createFunction();
      case UForthPackage.CREATE: return createCreate();
      case UForthPackage.INTRINSIC_STACK_WORDS: return createIntrinsicStackWords();
      case UForthPackage.INTRINSIC_MEMORY_WORDS: return createIntrinsicMemoryWords();
      case UForthPackage.INTRINSIC_ARITHMETIC_WORDS: return createIntrinsicArithmeticWords();
      case UForthPackage.WORD: return createWord();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Forth createForth()
  {
    ForthImpl forth = new ForthImpl();
    return forth;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GlobalInstruction createGlobalInstruction()
  {
    GlobalInstructionImpl globalInstruction = new GlobalInstructionImpl();
    return globalInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function createFunction()
  {
    FunctionImpl function = new FunctionImpl();
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Create createCreate()
  {
    CreateImpl create = new CreateImpl();
    return create;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntrinsicStackWords createIntrinsicStackWords()
  {
    IntrinsicStackWordsImpl intrinsicStackWords = new IntrinsicStackWordsImpl();
    return intrinsicStackWords;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntrinsicMemoryWords createIntrinsicMemoryWords()
  {
    IntrinsicMemoryWordsImpl intrinsicMemoryWords = new IntrinsicMemoryWordsImpl();
    return intrinsicMemoryWords;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntrinsicArithmeticWords createIntrinsicArithmeticWords()
  {
    IntrinsicArithmeticWordsImpl intrinsicArithmeticWords = new IntrinsicArithmeticWordsImpl();
    return intrinsicArithmeticWords;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Word createWord()
  {
    WordImpl word = new WordImpl();
    return word;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UForthPackage getUForthPackage()
  {
    return (UForthPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static UForthPackage getPackage()
  {
    return UForthPackage.eINSTANCE;
  }

} //UForthFactoryImpl
