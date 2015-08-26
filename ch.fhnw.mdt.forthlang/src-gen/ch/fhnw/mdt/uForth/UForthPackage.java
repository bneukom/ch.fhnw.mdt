/**
 */
package ch.fhnw.mdt.uForth;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ch.fhnw.mdt.uForth.UForthFactory
 * @model kind="package"
 * @generated
 */
public interface UForthPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "uForth";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.fhnw.ch/mdt/UForth";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "uForth";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UForthPackage eINSTANCE = ch.fhnw.mdt.uForth.impl.UForthPackageImpl.init();

  /**
   * The meta object id for the '{@link ch.fhnw.mdt.uForth.impl.ForthImpl <em>Forth</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ch.fhnw.mdt.uForth.impl.ForthImpl
   * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getForth()
   * @generated
   */
  int FORTH = 0;

  /**
   * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORTH__INSTRUCTIONS = 0;

  /**
   * The number of structural features of the '<em>Forth</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORTH_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link ch.fhnw.mdt.uForth.impl.InstructionImpl <em>Instruction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ch.fhnw.mdt.uForth.impl.InstructionImpl
   * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getInstruction()
   * @generated
   */
  int INSTRUCTION = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTRUCTION__NAME = 0;

  /**
   * The number of structural features of the '<em>Instruction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTRUCTION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link ch.fhnw.mdt.uForth.impl.FunctionImpl <em>Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ch.fhnw.mdt.uForth.impl.FunctionImpl
   * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getFunction()
   * @generated
   */
  int FUNCTION = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__NAME = INSTRUCTION__NAME;

  /**
   * The feature id for the '<em><b>Words</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__WORDS = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link ch.fhnw.mdt.uForth.impl.CreateImpl <em>Create</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ch.fhnw.mdt.uForth.impl.CreateImpl
   * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getCreate()
   * @generated
   */
  int CREATE = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CREATE__NAME = INSTRUCTION__NAME;

  /**
   * The feature id for the '<em><b>Lit</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CREATE__LIT = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Create</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CREATE_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link ch.fhnw.mdt.uForth.impl.WordImpl <em>Word</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ch.fhnw.mdt.uForth.impl.WordImpl
   * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getWord()
   * @generated
   */
  int WORD = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORD__NAME = INSTRUCTION__NAME;

  /**
   * The number of structural features of the '<em>Word</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORD_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link ch.fhnw.mdt.uForth.impl.IntrinsicStackWordsImpl <em>Intrinsic Stack Words</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ch.fhnw.mdt.uForth.impl.IntrinsicStackWordsImpl
   * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getIntrinsicStackWords()
   * @generated
   */
  int INTRINSIC_STACK_WORDS = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTRINSIC_STACK_WORDS__NAME = WORD__NAME;

  /**
   * The number of structural features of the '<em>Intrinsic Stack Words</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTRINSIC_STACK_WORDS_FEATURE_COUNT = WORD_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link ch.fhnw.mdt.uForth.impl.IntrinsicMemoryWordsImpl <em>Intrinsic Memory Words</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ch.fhnw.mdt.uForth.impl.IntrinsicMemoryWordsImpl
   * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getIntrinsicMemoryWords()
   * @generated
   */
  int INTRINSIC_MEMORY_WORDS = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTRINSIC_MEMORY_WORDS__NAME = WORD__NAME;

  /**
   * The number of structural features of the '<em>Intrinsic Memory Words</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTRINSIC_MEMORY_WORDS_FEATURE_COUNT = WORD_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link ch.fhnw.mdt.uForth.impl.IntrinsicArithmeticWordsImpl <em>Intrinsic Arithmetic Words</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ch.fhnw.mdt.uForth.impl.IntrinsicArithmeticWordsImpl
   * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getIntrinsicArithmeticWords()
   * @generated
   */
  int INTRINSIC_ARITHMETIC_WORDS = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTRINSIC_ARITHMETIC_WORDS__NAME = WORD__NAME;

  /**
   * The number of structural features of the '<em>Intrinsic Arithmetic Words</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTRINSIC_ARITHMETIC_WORDS_FEATURE_COUNT = WORD_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link ch.fhnw.mdt.uForth.Forth <em>Forth</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Forth</em>'.
   * @see ch.fhnw.mdt.uForth.Forth
   * @generated
   */
  EClass getForth();

  /**
   * Returns the meta object for the containment reference list '{@link ch.fhnw.mdt.uForth.Forth#getInstructions <em>Instructions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Instructions</em>'.
   * @see ch.fhnw.mdt.uForth.Forth#getInstructions()
   * @see #getForth()
   * @generated
   */
  EReference getForth_Instructions();

  /**
   * Returns the meta object for class '{@link ch.fhnw.mdt.uForth.Instruction <em>Instruction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instruction</em>'.
   * @see ch.fhnw.mdt.uForth.Instruction
   * @generated
   */
  EClass getInstruction();

  /**
   * Returns the meta object for the attribute '{@link ch.fhnw.mdt.uForth.Instruction#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ch.fhnw.mdt.uForth.Instruction#getName()
   * @see #getInstruction()
   * @generated
   */
  EAttribute getInstruction_Name();

  /**
   * Returns the meta object for class '{@link ch.fhnw.mdt.uForth.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function</em>'.
   * @see ch.fhnw.mdt.uForth.Function
   * @generated
   */
  EClass getFunction();

  /**
   * Returns the meta object for the containment reference list '{@link ch.fhnw.mdt.uForth.Function#getWords <em>Words</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Words</em>'.
   * @see ch.fhnw.mdt.uForth.Function#getWords()
   * @see #getFunction()
   * @generated
   */
  EReference getFunction_Words();

  /**
   * Returns the meta object for class '{@link ch.fhnw.mdt.uForth.Create <em>Create</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Create</em>'.
   * @see ch.fhnw.mdt.uForth.Create
   * @generated
   */
  EClass getCreate();

  /**
   * Returns the meta object for the attribute list '{@link ch.fhnw.mdt.uForth.Create#getLit <em>Lit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Lit</em>'.
   * @see ch.fhnw.mdt.uForth.Create#getLit()
   * @see #getCreate()
   * @generated
   */
  EAttribute getCreate_Lit();

  /**
   * Returns the meta object for class '{@link ch.fhnw.mdt.uForth.IntrinsicStackWords <em>Intrinsic Stack Words</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Intrinsic Stack Words</em>'.
   * @see ch.fhnw.mdt.uForth.IntrinsicStackWords
   * @generated
   */
  EClass getIntrinsicStackWords();

  /**
   * Returns the meta object for class '{@link ch.fhnw.mdt.uForth.IntrinsicMemoryWords <em>Intrinsic Memory Words</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Intrinsic Memory Words</em>'.
   * @see ch.fhnw.mdt.uForth.IntrinsicMemoryWords
   * @generated
   */
  EClass getIntrinsicMemoryWords();

  /**
   * Returns the meta object for class '{@link ch.fhnw.mdt.uForth.IntrinsicArithmeticWords <em>Intrinsic Arithmetic Words</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Intrinsic Arithmetic Words</em>'.
   * @see ch.fhnw.mdt.uForth.IntrinsicArithmeticWords
   * @generated
   */
  EClass getIntrinsicArithmeticWords();

  /**
   * Returns the meta object for class '{@link ch.fhnw.mdt.uForth.Word <em>Word</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Word</em>'.
   * @see ch.fhnw.mdt.uForth.Word
   * @generated
   */
  EClass getWord();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  UForthFactory getUForthFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link ch.fhnw.mdt.uForth.impl.ForthImpl <em>Forth</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ch.fhnw.mdt.uForth.impl.ForthImpl
     * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getForth()
     * @generated
     */
    EClass FORTH = eINSTANCE.getForth();

    /**
     * The meta object literal for the '<em><b>Instructions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FORTH__INSTRUCTIONS = eINSTANCE.getForth_Instructions();

    /**
     * The meta object literal for the '{@link ch.fhnw.mdt.uForth.impl.InstructionImpl <em>Instruction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ch.fhnw.mdt.uForth.impl.InstructionImpl
     * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getInstruction()
     * @generated
     */
    EClass INSTRUCTION = eINSTANCE.getInstruction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INSTRUCTION__NAME = eINSTANCE.getInstruction_Name();

    /**
     * The meta object literal for the '{@link ch.fhnw.mdt.uForth.impl.FunctionImpl <em>Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ch.fhnw.mdt.uForth.impl.FunctionImpl
     * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getFunction()
     * @generated
     */
    EClass FUNCTION = eINSTANCE.getFunction();

    /**
     * The meta object literal for the '<em><b>Words</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION__WORDS = eINSTANCE.getFunction_Words();

    /**
     * The meta object literal for the '{@link ch.fhnw.mdt.uForth.impl.CreateImpl <em>Create</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ch.fhnw.mdt.uForth.impl.CreateImpl
     * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getCreate()
     * @generated
     */
    EClass CREATE = eINSTANCE.getCreate();

    /**
     * The meta object literal for the '<em><b>Lit</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CREATE__LIT = eINSTANCE.getCreate_Lit();

    /**
     * The meta object literal for the '{@link ch.fhnw.mdt.uForth.impl.IntrinsicStackWordsImpl <em>Intrinsic Stack Words</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ch.fhnw.mdt.uForth.impl.IntrinsicStackWordsImpl
     * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getIntrinsicStackWords()
     * @generated
     */
    EClass INTRINSIC_STACK_WORDS = eINSTANCE.getIntrinsicStackWords();

    /**
     * The meta object literal for the '{@link ch.fhnw.mdt.uForth.impl.IntrinsicMemoryWordsImpl <em>Intrinsic Memory Words</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ch.fhnw.mdt.uForth.impl.IntrinsicMemoryWordsImpl
     * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getIntrinsicMemoryWords()
     * @generated
     */
    EClass INTRINSIC_MEMORY_WORDS = eINSTANCE.getIntrinsicMemoryWords();

    /**
     * The meta object literal for the '{@link ch.fhnw.mdt.uForth.impl.IntrinsicArithmeticWordsImpl <em>Intrinsic Arithmetic Words</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ch.fhnw.mdt.uForth.impl.IntrinsicArithmeticWordsImpl
     * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getIntrinsicArithmeticWords()
     * @generated
     */
    EClass INTRINSIC_ARITHMETIC_WORDS = eINSTANCE.getIntrinsicArithmeticWords();

    /**
     * The meta object literal for the '{@link ch.fhnw.mdt.uForth.impl.WordImpl <em>Word</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ch.fhnw.mdt.uForth.impl.WordImpl
     * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getWord()
     * @generated
     */
    EClass WORD = eINSTANCE.getWord();

  }

} //UForthPackage
