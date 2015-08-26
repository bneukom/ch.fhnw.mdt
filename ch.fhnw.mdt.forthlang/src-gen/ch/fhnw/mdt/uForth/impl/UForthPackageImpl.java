/**
 */
package ch.fhnw.mdt.uForth.impl;

import ch.fhnw.mdt.uForth.Create;
import ch.fhnw.mdt.uForth.Forth;
import ch.fhnw.mdt.uForth.Function;
import ch.fhnw.mdt.uForth.Instruction;
import ch.fhnw.mdt.uForth.IntrinsicArithmeticWords;
import ch.fhnw.mdt.uForth.IntrinsicMemoryWords;
import ch.fhnw.mdt.uForth.IntrinsicStackWords;
import ch.fhnw.mdt.uForth.UForthFactory;
import ch.fhnw.mdt.uForth.UForthPackage;
import ch.fhnw.mdt.uForth.Word;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UForthPackageImpl extends EPackageImpl implements UForthPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass forthEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass instructionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass createEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass intrinsicStackWordsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass intrinsicMemoryWordsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass intrinsicArithmeticWordsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass wordEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see ch.fhnw.mdt.uForth.UForthPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private UForthPackageImpl()
  {
    super(eNS_URI, UForthFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link UForthPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static UForthPackage init()
  {
    if (isInited) return (UForthPackage)EPackage.Registry.INSTANCE.getEPackage(UForthPackage.eNS_URI);

    // Obtain or create and register package
    UForthPackageImpl theUForthPackage = (UForthPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UForthPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UForthPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theUForthPackage.createPackageContents();

    // Initialize created meta-data
    theUForthPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theUForthPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(UForthPackage.eNS_URI, theUForthPackage);
    return theUForthPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForth()
  {
    return forthEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForth_Instructions()
  {
    return (EReference)forthEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInstruction()
  {
    return instructionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunction()
  {
    return functionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunction_Name()
  {
    return (EReference)functionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunction_Words()
  {
    return (EReference)functionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCreate()
  {
    return createEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCreate_Name()
  {
    return (EAttribute)createEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCreate_Lit()
  {
    return (EAttribute)createEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntrinsicStackWords()
  {
    return intrinsicStackWordsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntrinsicMemoryWords()
  {
    return intrinsicMemoryWordsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntrinsicArithmeticWords()
  {
    return intrinsicArithmeticWordsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWord()
  {
    return wordEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWord_Name()
  {
    return (EAttribute)wordEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UForthFactory getUForthFactory()
  {
    return (UForthFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    forthEClass = createEClass(FORTH);
    createEReference(forthEClass, FORTH__INSTRUCTIONS);

    instructionEClass = createEClass(INSTRUCTION);

    functionEClass = createEClass(FUNCTION);
    createEReference(functionEClass, FUNCTION__NAME);
    createEReference(functionEClass, FUNCTION__WORDS);

    createEClass = createEClass(CREATE);
    createEAttribute(createEClass, CREATE__NAME);
    createEAttribute(createEClass, CREATE__LIT);

    intrinsicStackWordsEClass = createEClass(INTRINSIC_STACK_WORDS);

    intrinsicMemoryWordsEClass = createEClass(INTRINSIC_MEMORY_WORDS);

    intrinsicArithmeticWordsEClass = createEClass(INTRINSIC_ARITHMETIC_WORDS);

    wordEClass = createEClass(WORD);
    createEAttribute(wordEClass, WORD__NAME);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    functionEClass.getESuperTypes().add(this.getInstruction());
    createEClass.getESuperTypes().add(this.getInstruction());
    intrinsicStackWordsEClass.getESuperTypes().add(this.getWord());
    intrinsicMemoryWordsEClass.getESuperTypes().add(this.getWord());
    intrinsicArithmeticWordsEClass.getESuperTypes().add(this.getWord());
    wordEClass.getESuperTypes().add(this.getInstruction());

    // Initialize classes and features; add operations and parameters
    initEClass(forthEClass, Forth.class, "Forth", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getForth_Instructions(), this.getInstruction(), null, "instructions", null, 0, -1, Forth.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(instructionEClass, Instruction.class, "Instruction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunction_Name(), this.getWord(), null, "name", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunction_Words(), this.getWord(), null, "words", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(createEClass, Create.class, "Create", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCreate_Name(), ecorePackage.getEString(), "name", null, 0, 1, Create.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCreate_Lit(), ecorePackage.getEString(), "lit", null, 0, -1, Create.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(intrinsicStackWordsEClass, IntrinsicStackWords.class, "IntrinsicStackWords", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(intrinsicMemoryWordsEClass, IntrinsicMemoryWords.class, "IntrinsicMemoryWords", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(intrinsicArithmeticWordsEClass, IntrinsicArithmeticWords.class, "IntrinsicArithmeticWords", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(wordEClass, Word.class, "Word", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getWord_Name(), ecorePackage.getEString(), "name", null, 0, 1, Word.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //UForthPackageImpl
