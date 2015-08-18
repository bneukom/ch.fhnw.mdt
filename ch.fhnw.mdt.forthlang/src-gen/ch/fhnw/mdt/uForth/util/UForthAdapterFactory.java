/**
 */
package ch.fhnw.mdt.uForth.util;

import ch.fhnw.mdt.uForth.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see ch.fhnw.mdt.uForth.UForthPackage
 * @generated
 */
public class UForthAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static UForthPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UForthAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = UForthPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UForthSwitch<Adapter> modelSwitch =
    new UForthSwitch<Adapter>()
    {
      @Override
      public Adapter caseForth(Forth object)
      {
        return createForthAdapter();
      }
      @Override
      public Adapter caseGlobalInstruction(GlobalInstruction object)
      {
        return createGlobalInstructionAdapter();
      }
      @Override
      public Adapter caseFunction(Function object)
      {
        return createFunctionAdapter();
      }
      @Override
      public Adapter caseCreate(Create object)
      {
        return createCreateAdapter();
      }
      @Override
      public Adapter caseIntrinsicStackWords(IntrinsicStackWords object)
      {
        return createIntrinsicStackWordsAdapter();
      }
      @Override
      public Adapter caseIntrinsicMemoryWords(IntrinsicMemoryWords object)
      {
        return createIntrinsicMemoryWordsAdapter();
      }
      @Override
      public Adapter caseIntrinsicArithmeticWords(IntrinsicArithmeticWords object)
      {
        return createIntrinsicArithmeticWordsAdapter();
      }
      @Override
      public Adapter caseWord(Word object)
      {
        return createWordAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link ch.fhnw.mdt.uForth.Forth <em>Forth</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ch.fhnw.mdt.uForth.Forth
   * @generated
   */
  public Adapter createForthAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ch.fhnw.mdt.uForth.GlobalInstruction <em>Global Instruction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ch.fhnw.mdt.uForth.GlobalInstruction
   * @generated
   */
  public Adapter createGlobalInstructionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ch.fhnw.mdt.uForth.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ch.fhnw.mdt.uForth.Function
   * @generated
   */
  public Adapter createFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ch.fhnw.mdt.uForth.Create <em>Create</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ch.fhnw.mdt.uForth.Create
   * @generated
   */
  public Adapter createCreateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ch.fhnw.mdt.uForth.IntrinsicStackWords <em>Intrinsic Stack Words</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ch.fhnw.mdt.uForth.IntrinsicStackWords
   * @generated
   */
  public Adapter createIntrinsicStackWordsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ch.fhnw.mdt.uForth.IntrinsicMemoryWords <em>Intrinsic Memory Words</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ch.fhnw.mdt.uForth.IntrinsicMemoryWords
   * @generated
   */
  public Adapter createIntrinsicMemoryWordsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ch.fhnw.mdt.uForth.IntrinsicArithmeticWords <em>Intrinsic Arithmetic Words</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ch.fhnw.mdt.uForth.IntrinsicArithmeticWords
   * @generated
   */
  public Adapter createIntrinsicArithmeticWordsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link ch.fhnw.mdt.uForth.Word <em>Word</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see ch.fhnw.mdt.uForth.Word
   * @generated
   */
  public Adapter createWordAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //UForthAdapterFactory
