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
package org.thingml.compilers.actions;

import org.sintef.thingml.*;
import org.thingml.compilers.Context;

import org.sintef.thingml.resource.thingml.analysis.helper.CharacterEscaper;

/**
 * Created by bmori on 01.12.2014.
 */
public class GenericImperativeActionCompiler extends ActionCompiler {

    //ThingML actions that can be compiled the same way for any imperative language like (Java, JS, C)

    @Override
    public void generate(SendAction action, StringBuilder builder, Context ctx) {
        builder.append("//Platform-specific action (" + action.getClass().getName() + ") should be refined in a sub-compiler");
    }

    @Override
    public void generate(VariableAssignment action, StringBuilder builder, Context ctx) {
        if (action.getProperty().getCardinality() != null) {//this is an array
            for(Expression i : action.getIndex()) {
                builder.append(action.getProperty().qname("_") + "_var");
                StringBuilder tempBuilder = new StringBuilder();
                generate(i, tempBuilder, ctx);
                builder.append("[" + tempBuilder.toString() + "]");
                builder.append(" = ");
                generate(action.getExpression(), builder, ctx);
                builder.append(";\n");
            }
        }
        else {//simple variable
            builder.append(action.getProperty().qname("_") + "_var");
            builder.append(" = ");
            generate(action.getExpression(), builder, ctx);
            builder.append(";\n");
        }
    }

    @Override
    public void generate(ActionBlock action, StringBuilder builder, Context ctx) {
        for(Action a : action.getActions()) {
            generate(a, builder, ctx);
        }
    }

    @Override
    public void generate(ExternStatement action, StringBuilder builder, Context ctx) {
        builder.append(action.getStatement());
        for (Expression e : action.getSegments()) {
            generate(e, builder, ctx);
        }
        builder.append("\n");
    }

    @Override
    public void generate(ConditionalAction action, StringBuilder builder, Context ctx) {
        builder.append("if(");
        generate(action.getCondition(), builder, ctx);
        builder.append(") {\n");
        generate(action.getAction(), builder, ctx);
        builder.append("\n}\n");
    }

    @Override
    public void generate(LoopAction action, StringBuilder builder, Context ctx) {
        builder.append("while(");
        generate(action.getCondition(), builder, ctx);
        builder.append(") {\n");
        generate(action.getAction(), builder, ctx);
        builder.append("\n}\n");
    }

    @Override
    public void generate(PrintAction action, StringBuilder builder, Context ctx) {
        builder.append("//Platform-specific action (" + action.getClass() + ") should be refined in a sub-compiler");
    }

    @Override
    public void generate(ErrorAction action, StringBuilder builder, Context ctx) {
        builder.append("//Platform-specific action (" + action.getClass() + ") should be refined in a sub-compiler");
    }

    @Override
    public void generate(ReturnAction action, StringBuilder builder, Context ctx) {
        builder.append("return ");
        generate(action.getExp(), builder, ctx);
        builder.append(";\n");
    }

    @Override
    public void generate(LocalVariable action, StringBuilder builder, Context ctx) {
        builder.append("//Platform-specific action (" + action.getClass() + ") should be refined in a sub-compiler");
    }

    @Override
    public void generate(FunctionCallStatement action, StringBuilder builder, Context ctx) {
        builder.append("//Platform-specific action (" + action.getClass() + ") should be refined in a sub-compiler");
    }


    //ThingML expressions that can be compiled the same way for any imperative language like (Java, JS, C)

    @Override
    public void generate(ArrayIndex expression, StringBuilder builder, Context ctx) {
        generate(expression.getArray(), builder, ctx);
        builder.append("[");
        generate(expression.getIndex(), builder, ctx);
        builder.append("]\n");
    }

    @Override
    public void generate(OrExpression expression, StringBuilder builder, Context ctx) {
        generate(expression.getLhs(), builder, ctx);
        builder.append(" || ");
        generate(expression.getRhs(), builder, ctx);
    }

    @Override
    public void generate(AndExpression expression, StringBuilder builder, Context ctx) {
        generate(expression.getLhs(), builder, ctx);
        builder.append(" && ");
        generate(expression.getRhs(), builder, ctx);
    }

    @Override
    public void generate(LowerExpression expression, StringBuilder builder, Context ctx) {
        generate(expression.getLhs(), builder, ctx);
        builder.append(" < ");
        generate(expression.getRhs(), builder, ctx);    }

    @Override
    public void generate(GreaterExpression expression, StringBuilder builder, Context ctx) {
        generate(expression.getLhs(), builder, ctx);
        builder.append(" > ");
        generate(expression.getRhs(), builder, ctx);
    }

    @Override
    public void generate(EqualsExpression expression, StringBuilder builder, Context ctx) {
        generate(expression.getLhs(), builder, ctx);
        builder.append(" == ");
        generate(expression.getRhs(), builder, ctx);    }

    @Override
    public void generate(PlusExpression expression, StringBuilder builder, Context ctx) {
        generate(expression.getLhs(), builder, ctx);
        builder.append(" + ");
        generate(expression.getRhs(), builder, ctx);
    }

    @Override
    public void generate(MinusExpression expression, StringBuilder builder, Context ctx) {
        generate(expression.getLhs(), builder, ctx);
        builder.append(" - ");
        generate(expression.getRhs(), builder, ctx);
    }

    @Override
    public void generate(TimesExpression expression, StringBuilder builder, Context ctx) {
        generate(expression.getLhs(), builder, ctx);
        builder.append(" * ");
        generate(expression.getRhs(), builder, ctx);
    }

    @Override
    public void generate(DivExpression expression, StringBuilder builder, Context ctx) {
        generate(expression.getLhs(), builder, ctx);
        builder.append(" / ");
        generate(expression.getRhs(), builder, ctx);
    }

    @Override
    public void generate(ModExpression expression, StringBuilder builder, Context ctx) {
        generate(expression.getLhs(), builder, ctx);
        builder.append(" % ");
        generate(expression.getRhs(), builder, ctx);
    }

    @Override
    public void generate(UnaryMinus expression, StringBuilder builder, Context ctx) {
        builder.append(" -");
        generate(expression.getTerm(), builder, ctx);
    }

    @Override
    public void generate(NotExpression expression, StringBuilder builder, Context ctx) {
        builder.append(" !(");
        generate(expression.getTerm(), builder, ctx);
        builder.append(")");
    }

    @Override
    public void generate(EventReference expression, StringBuilder builder, Context ctx) {
        builder.append("//Platform-specific expression (" + expression.getClass() + ") should be refined in a sub-compiler");
    }

    @Override
    public void generate(ExpressionGroup expression, StringBuilder builder, Context ctx) {
        generate(expression.getExp(), builder, ctx);
    }

    @Override
    public void generate(PropertyReference expression, StringBuilder builder, Context ctx) {
        builder.append("//Platform-specific expression (" + expression.getClass() + ") should be refined in a sub-compiler");
    }

    @Override
    public void generate(IntegerLiteral expression, StringBuilder builder, Context ctx) {
        builder.append(expression.getIntValue());
    }

    @Override
    public void generate(DoubleLiteral expression, StringBuilder builder, Context ctx) {
        builder.append(expression.getDoubleValue());
    }

    @Override
    public void generate(StringLiteral expression, StringBuilder builder, Context ctx) {
        builder.append("\"" + CharacterEscaper.escapeEscapedCharacters(expression.getStringValue()) + "\"");
    }

    @Override
    public void generate(BooleanLiteral expression, StringBuilder builder, Context ctx) {
       if (expression.isBoolValue())
           builder.append("true");
       else
           builder.append("false");
    }

    @Override
    public void generate(EnumLiteralRef expression, StringBuilder builder, Context ctx) {
        builder.append("//Platform-specific expression (" + expression.getClass() + ") should be refined in a sub-compiler");
    }

    @Override
    public void generate(ExternExpression expression, StringBuilder builder, Context ctx) {
        builder.append(expression.getExpression());
        for(Expression e : expression.getSegments()) {
            generate(e, builder, ctx);
        }
    }

    @Override
    public void generate(FunctionCallExpression expression, StringBuilder builder, Context ctx) {
        builder.append("//Platform-specific expression (" + expression.getClass() + ") should be refined in a sub-compiler");
    }
}
