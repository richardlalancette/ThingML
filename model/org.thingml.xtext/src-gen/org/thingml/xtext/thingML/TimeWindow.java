/**
 * Copyright (C) 2014 SINTEF <franck.fleurey@sintef.no>
 *
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * generated by Xtext 2.10.0
 */
package org.thingml.xtext.thingML;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Window</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.thingml.xtext.thingML.TimeWindow#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.thingml.xtext.thingML.TimeWindow#getStep <em>Step</em>}</li>
 * </ul>
 *
 * @see org.thingml.xtext.thingML.ThingMLPackage#getTimeWindow()
 * @model
 * @generated
 */
public interface TimeWindow extends ViewSource
{
  /**
   * Returns the value of the '<em><b>Duration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Duration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Duration</em>' containment reference.
   * @see #setDuration(Expression)
   * @see org.thingml.xtext.thingML.ThingMLPackage#getTimeWindow_Duration()
   * @model containment="true"
   * @generated
   */
  Expression getDuration();

  /**
   * Sets the value of the '{@link org.thingml.xtext.thingML.TimeWindow#getDuration <em>Duration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Duration</em>' containment reference.
   * @see #getDuration()
   * @generated
   */
  void setDuration(Expression value);

  /**
   * Returns the value of the '<em><b>Step</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Step</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Step</em>' containment reference.
   * @see #setStep(Expression)
   * @see org.thingml.xtext.thingML.ThingMLPackage#getTimeWindow_Step()
   * @model containment="true"
   * @generated
   */
  Expression getStep();

  /**
   * Sets the value of the '{@link org.thingml.xtext.thingML.TimeWindow#getStep <em>Step</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Step</em>' containment reference.
   * @see #getStep()
   * @generated
   */
  void setStep(Expression value);

} // TimeWindow
