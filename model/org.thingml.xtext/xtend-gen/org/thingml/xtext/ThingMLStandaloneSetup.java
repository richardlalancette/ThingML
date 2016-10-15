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
package org.thingml.xtext;

import org.thingml.xtext.ThingMLStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class ThingMLStandaloneSetup extends ThingMLStandaloneSetupGenerated {
  public static void doSetup() {
    ThingMLStandaloneSetup _thingMLStandaloneSetup = new ThingMLStandaloneSetup();
    _thingMLStandaloneSetup.createInjectorAndDoEMFRegistration();
  }
}
