/**
 */
package ch.fhnw.mdt.uForth;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ch.fhnw.mdt.uForth.Function#getWords <em>Words</em>}</li>
 * </ul>
 *
 * @see ch.fhnw.mdt.uForth.UForthPackage#getFunction()
 * @model
 * @generated
 */
public interface Function extends GlobalInstruction
{
  /**
   * Returns the value of the '<em><b>Words</b></em>' containment reference list.
   * The list contents are of type {@link ch.fhnw.mdt.uForth.Instruction}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Words</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Words</em>' containment reference list.
   * @see ch.fhnw.mdt.uForth.UForthPackage#getFunction_Words()
   * @model containment="true"
   * @generated
   */
  EList<Instruction> getWords();

} // Function
