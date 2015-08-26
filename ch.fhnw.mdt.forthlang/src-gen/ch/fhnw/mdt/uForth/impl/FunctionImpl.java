/**
 */
package ch.fhnw.mdt.uForth.impl;

import ch.fhnw.mdt.uForth.Function;
import ch.fhnw.mdt.uForth.UForthPackage;
import ch.fhnw.mdt.uForth.Word;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ch.fhnw.mdt.uForth.impl.FunctionImpl#getName <em>Name</em>}</li>
 *   <li>{@link ch.fhnw.mdt.uForth.impl.FunctionImpl#getWords <em>Words</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionImpl extends InstructionImpl implements Function
{
  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected Word name;

  /**
   * The cached value of the '{@link #getWords() <em>Words</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWords()
   * @generated
   * @ordered
   */
  protected EList<Word> words;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FunctionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return UForthPackage.Literals.FUNCTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Word getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName(Word newName, NotificationChain msgs)
  {
    Word oldName = name;
    name = newName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UForthPackage.FUNCTION__NAME, oldName, newName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(Word newName)
  {
    if (newName != name)
    {
      NotificationChain msgs = null;
      if (name != null)
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UForthPackage.FUNCTION__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UForthPackage.FUNCTION__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UForthPackage.FUNCTION__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Word> getWords()
  {
    if (words == null)
    {
      words = new EObjectContainmentEList<Word>(Word.class, this, UForthPackage.FUNCTION__WORDS);
    }
    return words;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case UForthPackage.FUNCTION__NAME:
        return basicSetName(null, msgs);
      case UForthPackage.FUNCTION__WORDS:
        return ((InternalEList<?>)getWords()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case UForthPackage.FUNCTION__NAME:
        return getName();
      case UForthPackage.FUNCTION__WORDS:
        return getWords();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UForthPackage.FUNCTION__NAME:
        setName((Word)newValue);
        return;
      case UForthPackage.FUNCTION__WORDS:
        getWords().clear();
        getWords().addAll((Collection<? extends Word>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case UForthPackage.FUNCTION__NAME:
        setName((Word)null);
        return;
      case UForthPackage.FUNCTION__WORDS:
        getWords().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case UForthPackage.FUNCTION__NAME:
        return name != null;
      case UForthPackage.FUNCTION__WORDS:
        return words != null && !words.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FunctionImpl
