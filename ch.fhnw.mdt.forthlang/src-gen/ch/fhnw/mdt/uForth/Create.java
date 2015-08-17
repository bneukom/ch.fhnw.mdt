/**
 */
package ch.fhnw.mdt.uForth;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ch.fhnw.mdt.uForth.Create#getLit <em>Lit</em>}</li>
 * </ul>
 *
 * @see ch.fhnw.mdt.uForth.UForthPackage#getCreate()
 * @model
 * @generated
 */
public interface Create extends GlobalInstruction
{
  /**
   * Returns the value of the '<em><b>Lit</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lit</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lit</em>' attribute list.
   * @see ch.fhnw.mdt.uForth.UForthPackage#getCreate_Lit()
   * @model unique="false"
   * @generated
   */
  EList<String> getLit();

} // Create
