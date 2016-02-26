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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.thingml.thingmltools;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import org.sintef.thingml.Port;
import org.sintef.thingml.Thing;
import org.sintef.thingml.ThingMLModel;

/**
 *
 * @author sintef
 */
public class TestConfigurationGenerator extends ThingMLTool{
    

    public TestConfigurationGenerator(File outdir) {
        super(outdir);
    }
    
    @Override
    public void generateThingMLFrom(ThingMLModel model) {
        System.out.println("Generate ThingML from model");
        for (Thing t : model.allThings()) {
            for(String an : t.annotation("test")) {
                String[] testAn = an.split("#");
                String testInputs, testOutputs;
                if(testAn.length == 2) {
                    testInputs = testAn[0];
                    testOutputs = testAn[1];
                    System.out.println("in: " + testInputs + ", out: " + testOutputs);
                }
            }
        }
    }
    
    public void generateTester(StringBuilder builder, Thing t, String in, String out) {
        builder.append("thing Tester includes TestHarness, TimerClient {\n");
        
        builder.append("statechart TestChart init\n");
        builder.append("}\n");
        
        builder.append("}\n");
    }
    
    public void generateCfg(Thing t, String in, String out) {
        StringBuilder builder = new StringBuilder();
        
        builder.append("import \"../../../src/main/resources/tests/thingml.thingml\"\n\n");
    }
    
}
