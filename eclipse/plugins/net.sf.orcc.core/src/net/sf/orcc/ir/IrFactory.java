/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.orcc.ir;

import java.math.BigInteger;
import java.util.List;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * @see net.sf.orcc.ir.IrPackage
 * @generated
 */
public interface IrFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	IrFactory eINSTANCE = net.sf.orcc.ir.impl.IrFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action</em>'.
	 * @generated
	 */
	Action createAction();

	/**
	 * Creates a new action.
	 * 
	 * @param location
	 *            location of the action
	 * @param tag
	 *            action tag
	 * @param inputPattern
	 *            input pattern
	 * @param outputPattern
	 *            output pattern
	 * @param peekedPattern
	 *            peeked pattern
	 * @param scheduler
	 *            procedure that computes scheduling information
	 * @param body
	 *            procedure that holds the body of the action
	 */
	Action createAction(Location location, Tag tag, Pattern inputPattern,
			Pattern outputPattern, Pattern peekedPattern, Procedure scheduler,
			Procedure body);

	/**
	 * Returns a new object of class '<em>Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actor</em>'.
	 * @generated
	 */
	Actor createActor();

	/**
	 * Returns a new object of class '<em>Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Def</em>'.
	 * @generated
	 */
	Def createDef();

	/**
	 * Creates a new definition of the given variable.
	 * 
	 * @param variable
	 *            a variable
	 * @return a new definition of the given variable
	 */
	Def createDef(Var variable);

	/**
	 * Returns a new object of class '<em>Expr Binary</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Expr Binary</em>'.
	 * @generated
	 */
	ExprBinary createExprBinary();

	/**
	 * Creates a new ExprBinary. Type is copied.
	 * 
	 * @param e1
	 * @param op
	 * @param e2
	 * @param type
	 * @return
	 */
	ExprBinary createExprBinary(Expression e1, OpBinary op, Expression e2,
			Type type);

	/**
	 * Returns a new object of class '<em>Expr Bool</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Expr Bool</em>'.
	 * @generated
	 */
	ExprBool createExprBool();

	ExprBool createExprBool(boolean value);

	/**
	 * Returns a new object of class '<em>Expr Float</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Expr Float</em>'.
	 * @generated
	 */
	ExprFloat createExprFloat();

	ExprFloat createExprFloat(float value);

	/**
	 * Returns a new object of class '<em>Expr Int</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Expr Int</em>'.
	 * @generated
	 */
	ExprInt createExprInt();

	ExprInt createExprInt(BigInteger value);

	ExprInt createExprInt(int value);

	ExprInt createExprInt(long value);

	/**
	 * Returns a new object of class '<em>Expr List</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Expr List</em>'.
	 * @generated
	 */
	ExprList createExprList();

	ExprList createExprList(ExprList l1, ExprList l2);

	ExprList createExprList(List<Expression> exprs);

	/**
	 * Returns a new object of class '<em>Expr String</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Expr String</em>'.
	 * @generated
	 */
	ExprString createExprString();

	ExprString createExprString(String value);

	/**
	 * Returns a new object of class '<em>Expr Unary</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Expr Unary</em>'.
	 * @generated
	 */
	ExprUnary createExprUnary();

	/**
	 * Creates a new ExprUnary. Type is copied.
	 * 
	 * @param op
	 * @param expression
	 * @param type
	 * @return
	 */
	ExprUnary createExprUnary(OpUnary op, Expression expression, Type type);

	/**
	 * Returns a new object of class '<em>Expr Var</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Expr Var</em>'.
	 * @generated
	 */
	ExprVar createExprVar();

	ExprVar createExprVar(Use use);

	ExprVar createExprVar(Var variable);

	/**
	 * Returns a new object of class '<em>FSM</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FSM</em>'.
	 * @generated
	 */
	FSM createFSM();

	/**
	 * Returns a new object of class '<em>Inst Assign</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Inst Assign</em>'.
	 * @generated
	 */
	InstAssign createInstAssign();

	/**
	 * Creates an InstAssign with the given location, target and value.
	 * 
	 * @param location
	 *            location
	 * @param target
	 *            target variable
	 * @param value
	 *            value
	 * @return an InstAssign with the given location, target and value.
	 */
	InstAssign createInstAssign(Location location, Var target, Expression value);

	/**
	 * Creates an InstAssign with the given target and value.
	 * 
	 * @param target
	 *            target variable
	 * @param value
	 *            value
	 * @return an InstAssign with the given location, target and value.
	 */
	InstAssign createInstAssign(Var target, Expression value);

	/**
	 * Returns a new object of class '<em>Inst Call</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Inst Call</em>'.
	 * @generated
	 */
	InstCall createInstCall();

	/**
	 * Creates an InstCall with the given location, target, procedure,
	 * parameters.
	 * 
	 * @param location
	 * @param target
	 * @param procedure
	 * @param parameters
	 * @return a call
	 */
	InstCall createInstCall(Location location, Var target, Procedure procedure,
			List<Expression> parameters);

	/**
	 * Creates an InstCall with the given target, procedure, parameters.
	 * 
	 * @param location
	 * @param target
	 * @param procedure
	 * @param parameters
	 * @return a call
	 */
	InstCall createInstCall(Var target, Procedure procedure,
			List<Expression> parameters);

	/**
	 * Returns a new object of class '<em>Inst Load</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Inst Load</em>'.
	 * @generated
	 */
	InstLoad createInstLoad();

	/**
	 * Creates an InstLoad with the given location, target, source, indexes.
	 * 
	 * @param location
	 * @param target
	 * @param source
	 * @param indexes
	 * @return a load
	 */
	InstLoad createInstLoad(Location location, Def target, Use source,
			List<Expression> indexes);

	/**
	 * Creates an InstLoad with the given location, target, source, indexes.
	 * 
	 * @param location
	 * @param target
	 * @param source
	 * @param indexes
	 * @return a load
	 */
	InstLoad createInstLoad(Location location, Var target, Var source,
			List<Expression> indexes);

	/**
	 * Creates an InstLoad with the given target and source.
	 * 
	 * @param target
	 * @param source
	 * @return a load
	 */
	InstLoad createInstLoad(Var target, Var source);

	/**
	 * Creates an InstLoad with the given target, source, and indexes.
	 * 
	 * @param target
	 * @param source
	 * @param indexes
	 * @return a load
	 */
	InstLoad createInstLoad(Var target, Var source, List<Expression> indexes);

	/**
	 * Returns a new object of class '<em>Inst Phi</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Inst Phi</em>'.
	 * @generated
	 */
	InstPhi createInstPhi();

	/**
	 * Creates an InstPhi with the given location, target, and values.
	 * 
	 * @param location
	 * @param target
	 * @param values
	 * @return a phi
	 */
	InstPhi createInstPhi(Location location, Def target, List<Expression> values);

	/**
	 * Creates an InstPhi with the given location, target, and values.
	 * 
	 * @param location
	 * @param target
	 * @param values
	 * @return a phi
	 */
	InstPhi createInstPhi(Location location, Var target, List<Expression> values);

	/**
	 * Creates an InstPhi with the given target and values.
	 * 
	 * @param target
	 * @param values
	 * @return a phi
	 */
	InstPhi createInstPhi(Var target, List<Expression> values);

	/**
	 * Returns a new object of class '<em>Inst Return</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Inst Return</em>'.
	 * @generated
	 */
	InstReturn createInstReturn();

	/**
	 * Creates an InstReturn with the given location and value.
	 * 
	 * @param value
	 * @return a return
	 */
	InstReturn createInstReturn(Expression value);

	/**
	 * Creates an InstReturn with the given location and value.
	 * 
	 * @param location
	 * @param value
	 * @return a return
	 */
	InstReturn createInstReturn(Location location, Expression value);

	/**
	 * Returns a new object of class '<em>Inst Specific</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Inst Specific</em>'.
	 * @generated
	 */
	InstSpecific createInstSpecific();

	/**
	 * Returns a new object of class '<em>Inst Store</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Inst Store</em>'.
	 * @generated
	 */
	InstStore createInstStore();

	/**
	 * Creates an InstStore with the given location, target, indexes, value.
	 * 
	 * @param location
	 * @param target
	 * @param source
	 * @param indexes
	 * @return a store
	 */
	InstStore createInstStore(Location location, Def target,
			List<Expression> indexes, Expression value);

	/**
	 * Creates an InstStore with the given location, target, indexes, value.
	 * 
	 * @param location
	 * @param target
	 * @param source
	 * @param indexes
	 * @return a store
	 */
	InstStore createInstStore(Location location, Var target,
			List<Expression> indexes, Expression value);

	/**
	 * Creates an InstStore with the given target and source.
	 * 
	 * @param target
	 * @param value
	 * @return a store
	 */
	InstStore createInstStore(Var target, Expression value);

	/**
	 * Returns a new object of class '<em>Location</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Location</em>'.
	 * @generated
	 */
	Location createLocation();

	/**
	 * Constructs a location from the specified start line, start column, end
	 * column.
	 * 
	 * @param startLine
	 *            The line where the location starts.
	 * @param startColumn
	 *            The column where the location starts.
	 * @param endColumn
	 *            The column where the location ends.
	 */
	Location createLocation(int startLine, int startColumn, int endColumn);

	/**
	 * Returns a new object of class '<em>Node Block</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Block</em>'.
	 * @generated
	 */
	NodeBlock createNodeBlock();

	/**
	 * Returns a new object of class '<em>Node If</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node If</em>'.
	 * @generated
	 */
	NodeIf createNodeIf();

	/**
	 * Returns a new object of class '<em>Node While</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Node While</em>'.
	 * @generated
	 */
	NodeWhile createNodeWhile();

	/**
	 * Returns a new object of class '<em>Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern</em>'.
	 * @generated
	 */
	Pattern createPattern();

	/**
	 * Returns a new object of class '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port</em>'.
	 * @generated
	 */
	Port createPort();

	Port createPort(Location location, Type type, String name);

	Port createPort(Port port);

	/**
	 * Returns a new object of class '<em>Procedure</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Procedure</em>'.
	 * @generated
	 */
	Procedure createProcedure();

	/**
	 * Creates a new procedure, not external, with empty parameters, locals, and
	 * nodes. Return type is copied.
	 * 
	 * @param name
	 *            The procedure name.
	 * @param external
	 *            Whether it is external or not.
	 * @param location
	 *            The procedure location.
	 * @param returnType
	 *            The procedure return type.
	 */
	Procedure createProcedure(String name, Location location, Type returnType);

	/**
	 * Returns a new object of class '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State</em>'.
	 * @generated
	 */
	State createState();

	/**
	 * Creates a state with the given name.
	 * 
	 * @param name
	 *            name of the state
	 * @return a state with the given name
	 */
	State createState(String name);

	/**
	 * Returns a new object of class '<em>Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tag</em>'.
	 * @generated
	 */
	Tag createTag();

	Tag createTag(List<String> identifiers);

	Tag createTag(String tagName);

	Tag createTag(Tag tag);

	/**
	 * Returns a new object of class '<em>Transition</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition</em>'.
	 * @generated
	 */
	Transition createTransition();

	Transition createTransition(Action action, State target);

	/**
	 * Returns a new object of class '<em>Transitions</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transitions</em>'.
	 * @generated
	 */
	Transitions createTransitions();

	/**
	 * Returns a new object of class '<em>Type Bool</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Bool</em>'.
	 * @generated
	 */
	TypeBool createTypeBool();

	/**
	 * Returns a new object of class '<em>Type Float</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Float</em>'.
	 * @generated
	 */
	TypeFloat createTypeFloat();

	/**
	 * Returns a new object of class '<em>Type Int</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Int</em>'.
	 * @generated
	 */
	TypeInt createTypeInt();

	/**
	 * Creates a new int type with the given size.
	 * 
	 * @param size
	 *            the size of this int type
	 */
	TypeInt createTypeInt(int size);

	/**
	 * Returns a new object of class '<em>Type List</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Type List</em>'.
	 * @generated
	 */
	TypeList createTypeList();

	/**
	 * Creates a new list type with the given size and element type. Type is
	 * copied.
	 * 
	 * @param size
	 *            the size of this list type
	 * @param type
	 *            the type of this list's elements
	 */
	TypeList createTypeList(Expression size, Type type);

	/**
	 * Creates a new list type with the given size and element type. Type is
	 * copied.
	 * 
	 * @param size
	 *            the size of this list type
	 * @param type
	 *            the type of this list's elements
	 */
	TypeList createTypeList(int size, Type type);

	/**
	 * Returns a new object of class '<em>Type String</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Type String</em>'.
	 * @generated
	 */
	TypeString createTypeString();

	/**
	 * Returns a new object of class '<em>Type Uint</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Uint</em>'.
	 * @generated
	 */
	TypeUint createTypeUint();

	/**
	 * Creates a new uint type with the given size.
	 * 
	 * @param size
	 *            the size of this uint type
	 */
	TypeUint createTypeUint(int size);

	/**
	 * Returns a new object of class '<em>Type Void</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Void</em>'.
	 * @generated
	 */
	TypeVoid createTypeVoid();

	/**
	 * Returns a new object of class '<em>Use</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Use</em>'.
	 * @generated
	 */
	Use createUse();

	/**
	 * Creates a new use of the given variable.
	 * 
	 * @param variable
	 *            a variable
	 * @return a new use of the given variable
	 */
	Use createUse(Var variable);

	/**
	 * Returns a new object of class '<em>Var</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Var</em>'.
	 * @generated
	 */
	Var createVar();

	/**
	 * Creates a new variable with the given location, type, and name. The
	 * variable may be global or local, and assignable or not. Type is copied.
	 * 
	 * @param location
	 *            the variable location
	 * @param type
	 *            the variable type
	 * @param name
	 *            the variable name
	 * @param global
	 *            whether this variable is global
	 * @param assignable
	 *            whether this variable is assignable
	 */
	Var createVar(Location location, Type type, String name, boolean global,
			boolean assignable);

	/**
	 * Creates a new global variable with the given location, type, name,
	 * initial value. The variable may be assignable or not.
	 * 
	 * @param location
	 *            the variable location
	 * @param type
	 *            the variable type
	 * @param name
	 *            the variable name
	 * @param assignable
	 *            whether this variable is assignable
	 * @param initialValue
	 *            initial value of this variable
	 */
	Var createVar(Location location, Type type, String name,
			boolean assignable, Expression initialValue);

	/**
	 * Creates a new local variable with the given location, type, name, index.
	 * The variable may be assignable or not. Type is copied.
	 * 
	 * @param location
	 *            the variable location
	 * @param type
	 *            the variable type
	 * @param name
	 *            the variable name
	 * @param assignable
	 *            whether this variable is assignable
	 * @param index
	 *            index of this variable
	 */
	Var createVar(Location location, Type type, String name,
			boolean assignable, int index);

	/**
	 * Creates a new local variable with the given type, name, index. The
	 * variable may be assignable or not. Type is copied.
	 * 
	 * @param type
	 *            the variable type
	 * @param name
	 *            the variable name
	 * @param assignable
	 *            whether this variable is assignable
	 * @param index
	 *            index of this variable
	 */
	Var createVar(Type type, String name, boolean assignable, int index);

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	IrPackage getIrPackage();

} // IrFactory
