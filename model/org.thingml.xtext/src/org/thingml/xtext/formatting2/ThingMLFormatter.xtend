/*
 * generated by Xtext 2.10.0
 */
package org.thingml.xtext.formatting2

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.thingml.xtext.services.ThingMLGrammarAccess
import org.thingml.xtext.thingML.Configuration
import org.thingml.xtext.thingML.Import
import org.thingml.xtext.thingML.PlatformAnnotation
import org.thingml.xtext.thingML.PrimitiveType
import org.thingml.xtext.thingML.Protocol
import org.thingml.xtext.thingML.ThingMLModel
import org.thingml.xtext.thingML.Type

class ThingMLFormatter extends AbstractFormatter2 {
	
	@Inject extension ThingMLGrammarAccess

	def dispatch void format(ThingMLModel thingMLModel, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (Import imports : thingMLModel.getImports()) {
			imports.format;
		}
		for (Type types : thingMLModel.getTypes()) {
			types.format;
		}
		for (Protocol protocols : thingMLModel.getProtocols()) {
			protocols.format;
		}
		for (Configuration configs : thingMLModel.getConfigs()) {
			configs.format;
		}
	}

	def dispatch void format(PrimitiveType primitiveType, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (PlatformAnnotation annotations : primitiveType.getAnnotations()) {
			annotations.format;
		}
	}
	
	// TODO: implement for ObjectType, Enumeration, EnumerationLiteral, Thing, PropertyAssign, Protocol, Function, Property, Message, Parameter, RequiredPort, ProvidedPort, InternalPort, Stream, JoinSources, MergeSources, SimpleSource, Filter, LengthWindow, TimeWindow, StateMachine, FinalState, CompositeState, Session, ParallelRegion, State, Transition, InternalTransition, ActionBlock, ExternStatement, LocalVariable, SendAction, VariableAssignment, LoopAction, ConditionalAction, ReturnAction, PrintAction, ErrorAction, StartSession, FunctionCallStatement, ExternExpression, Configuration, Instance, ConfigPropertyAssign, Connector, ExternalConnector
}
