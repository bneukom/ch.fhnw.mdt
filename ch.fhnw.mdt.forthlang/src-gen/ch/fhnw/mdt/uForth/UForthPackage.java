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
   * The meta object id for the '{@link ch.fhnw.mdt.uForth.impl.GlobalInstructionImpl <em>Global Instruction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ch.fhnw.mdt.uForth.impl.GlobalInstructionImpl
   * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getGlobalInstruction()
   * @generated
   */
  int GLOBAL_INSTRUCTION = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_INSTRUCTION__NAME = 0;

  /**
   * The number of structural features of the '<em>Global Instruction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_INSTRUCTION_FEATURE_COUNT = 1;

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
  int FUNCTION__NAME = GLOBAL_INSTRUCTION__NAME;

  /**
   * The feature id for the '<em><b>Words</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__WORDS = GLOBAL_INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_FEATURE_COUNT = GLOBAL_INSTRUCTION_FEATURE_COUNT + 1;

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
  int CREATE__NAME = GLOBAL_INSTRUCTION__NAME;

  /**
   * The feature id for the '<em><b>Lit</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CREATE__LIT = GLOBAL_INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Create</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CREATE_FEATURE_COUNT = GLOBAL_INSTRUCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link ch.fhnw.mdt.uForth.impl.InstructionImpl <em>Instruction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ch.fhnw.mdt.uForth.impl.InstructionImpl
   * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getInstruction()
   * @generated
   */
  int INSTRUCTION = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTRUCTION__NAME = GLOBAL_INSTRUCTION__NAME;

  /**
   * The number of structural features of the '<em>Instruction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTRUCTION_FEATURE_COUNT = GLOBAL_INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link ch.fhnw.mdt.uForth.impl.KeywordsImpl <em>Keywords</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ch.fhnw.mdt.uForth.impl.KeywordsImpl
   * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getKeywords()
   * @generated
   */
  int KEYWORDS = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORDS__NAME = INSTRUCTION__NAME;

  /**
   * The number of structural features of the '<em>Keywords</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORDS_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link ch.fhnw.mdt.uForth.impl.WordImpl <em>Word</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see ch.fhnw.mdt.uForth.impl.WordImpl
   * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getWord()
   * @generated
   */
  int WORD = 6;

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
   * Returns the meta object for class '{@link ch.fhnw.mdt.uForth.GlobalInstruction <em>Global Instruction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Global Instruction</em>'.
   * @see ch.fhnw.mdt.uForth.GlobalInstruction
   * @generated
   */
  EClass getGlobalInstruction();

  /**
   * Returns the meta object for the attribute '{@link ch.fhnw.mdt.uForth.GlobalInstruction#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see ch.fhnw.mdt.uForth.GlobalInstruction#getName()
   * @see #getGlobalInstruction()
   * @generated
   */
  EAttribute getGlobalInstruction_Name();

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
   * Returns the meta object for class '{@link ch.fhnw.mdt.uForth.Keywords <em>Keywords</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Keywords</em>'.
   * @see ch.fhnw.mdt.uForth.Keywords
   * @generated
   */
  EClass getKeywords();

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
     * The meta object literal for the '{@link ch.fhnw.mdt.uForth.impl.GlobalInstructionImpl <em>Global Instruction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ch.fhnw.mdt.uForth.impl.GlobalInstructionImpl
     * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getGlobalInstruction()
     * @generated
     */
    EClass GLOBAL_INSTRUCTION = eINSTANCE.getGlobalInstruction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GLOBAL_INSTRUCTION__NAME = eINSTANCE.getGlobalInstruction_Name();

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
     * The meta object literal for the '{@link ch.fhnw.mdt.uForth.impl.KeywordsImpl <em>Keywords</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see ch.fhnw.mdt.uForth.impl.KeywordsImpl
     * @see ch.fhnw.mdt.uForth.impl.UForthPackageImpl#getKeywords()
     * @generated
     */
    EClass KEYWORDS = eINSTANCE.getKeywords();

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
