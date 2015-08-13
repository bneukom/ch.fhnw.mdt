/**
 */
package ch.fhnw.mdt.uForth;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instruction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ch.fhnw.mdt.uForth.Instruction#getLit <em>Lit</em>}</li>
 * </ul>
 *
 * @see ch.fhnw.mdt.uForth.UForthPackage#getInstruction()
 * @model
 * @generated
 */
public interface Instruction extends GlobalInstruction
{
  /**
   * Returns the value of the '<em><b>Lit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lit</em>' attribute.
   * @see #setLit(String)
   * @see ch.fhnw.mdt.uForth.UForthPackage#getInstruction_Lit()
   * @model
   * @generated
   */
  String getLit();

  /**
   * Sets the value of the '{@link ch.fhnw.mdt.uForth.Instruction#getLit <em>Lit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lit</em>' attribute.
   * @see #getLit()
   * @generated
   */
  void setLit(String value);

} // Instruction
