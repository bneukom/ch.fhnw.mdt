/**
 */
package ch.fhnw.mdt.uForth;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Word</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ch.fhnw.mdt.uForth.Word#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see ch.fhnw.mdt.uForth.UForthPackage#getWord()
 * @model
 * @generated
 */
public interface Word extends Instruction
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see ch.fhnw.mdt.uForth.UForthPackage#getWord_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ch.fhnw.mdt.uForth.Word#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // Word
