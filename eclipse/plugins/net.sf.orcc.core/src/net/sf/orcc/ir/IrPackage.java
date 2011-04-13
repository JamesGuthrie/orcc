/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.orcc.ir;

import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see net.sf.orcc.ir.IrFactory
 * @model kind="package"
 * @generated
 */
public interface IrPackage extends EPackage {
	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '
		 * {@link net.sf.orcc.ir.impl.ActionImpl <em>Action</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see net.sf.orcc.ir.impl.ActionImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__BODY = eINSTANCE.getAction_Body();

		/**
		 * The meta object literal for the '<em><b>Input Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference ACTION__INPUT_PATTERN = eINSTANCE.getAction_InputPattern();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference ACTION__LOCATION = eINSTANCE.getAction_Location();

		/**
		 * The meta object literal for the '<em><b>Output Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference ACTION__OUTPUT_PATTERN = eINSTANCE.getAction_OutputPattern();

		/**
		 * The meta object literal for the '<em><b>Peek Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference ACTION__PEEK_PATTERN = eINSTANCE.getAction_PeekPattern();

		/**
		 * The meta object literal for the '<em><b>Scheduler</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference ACTION__SCHEDULER = eINSTANCE.getAction_Scheduler();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__TAG = eINSTANCE.getAction_Tag();

		/**
		 * The meta object literal for the '
		 * {@link net.sf.orcc.ir.impl.ActorImpl <em>Actor</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see net.sf.orcc.ir.impl.ActorImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__ACTIONS = eINSTANCE.getActor_Actions();

		/**
		 * The meta object literal for the '<em><b>Actions Outside Fsm</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__ACTIONS_OUTSIDE_FSM = eINSTANCE.getActor_ActionsOutsideFsm();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR__FILE = eINSTANCE.getActor_File();

		/**
		 * The meta object literal for the '<em><b>Fsm</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__FSM = eINSTANCE.getActor_Fsm();

		/**
		 * The meta object literal for the '<em><b>Initializes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__INITIALIZES = eINSTANCE.getActor_Initializes();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__INPUTS = eINSTANCE.getActor_Inputs();

		/**
		 * The meta object literal for the '<em><b>Mo C</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__MO_C = eINSTANCE.getActor_MoC();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR__NAME = eINSTANCE.getActor_Name();

		/**
		 * The meta object literal for the '<em><b>Native</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR__NATIVE = eINSTANCE.getActor_Native();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__OUTPUTS = eINSTANCE.getActor_Outputs();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__PARAMETERS = eINSTANCE.getActor_Parameters();

		/**
		 * The meta object literal for the '<em><b>Procs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__PROCS = eINSTANCE.getActor_Procs();

		/**
		 * The meta object literal for the '<em><b>State Vars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__STATE_VARS = eINSTANCE.getActor_StateVars();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.DefImpl <em>Def</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.DefImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getDef()
		 * @generated
		 */
		EClass DEF = eINSTANCE.getDef();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEF__VARIABLE = eINSTANCE.getDef_Variable();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.emf.common.util.EMap <em>EMap</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.common.util.EMap
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getEMap()
		 * @generated
		 */
		EClass EMAP = eINSTANCE.getEMap();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.ExprBinaryImpl <em>Expr Binary</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.ExprBinaryImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getExprBinary()
		 * @generated
		 */
		EClass EXPR_BINARY = eINSTANCE.getExprBinary();

		/**
		 * The meta object literal for the '<em><b>E1</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPR_BINARY__E1 = eINSTANCE.getExprBinary_E1();

		/**
		 * The meta object literal for the '<em><b>E2</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPR_BINARY__E2 = eINSTANCE.getExprBinary_E2();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPR_BINARY__OP = eINSTANCE.getExprBinary_Op();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPR_BINARY__TYPE = eINSTANCE.getExprBinary_Type();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.ExprBoolImpl <em>Expr Bool</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.ExprBoolImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getExprBool()
		 * @generated
		 */
		EClass EXPR_BOOL = eINSTANCE.getExprBool();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPR_BOOL__VALUE = eINSTANCE.getExprBool_Value();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.ExprFloatImpl <em>Expr Float</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.ExprFloatImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getExprFloat()
		 * @generated
		 */
		EClass EXPR_FLOAT = eINSTANCE.getExprFloat();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPR_FLOAT__VALUE = eINSTANCE.getExprFloat_Value();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.ExprIntImpl <em>Expr Int</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.ExprIntImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getExprInt()
		 * @generated
		 */
		EClass EXPR_INT = eINSTANCE.getExprInt();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPR_INT__VALUE = eINSTANCE.getExprInt_Value();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.ExprListImpl <em>Expr List</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.ExprListImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getExprList()
		 * @generated
		 */
		EClass EXPR_LIST = eINSTANCE.getExprList();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPR_LIST__VALUE = eINSTANCE.getExprList_Value();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.ExprStringImpl <em>Expr String</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.ExprStringImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getExprString()
		 * @generated
		 */
		EClass EXPR_STRING = eINSTANCE.getExprString();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPR_STRING__VALUE = eINSTANCE.getExprString_Value();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.ExprUnaryImpl <em>Expr Unary</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.ExprUnaryImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getExprUnary()
		 * @generated
		 */
		EClass EXPR_UNARY = eINSTANCE.getExprUnary();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPR_UNARY__EXPR = eINSTANCE.getExprUnary_Expr();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPR_UNARY__OP = eINSTANCE.getExprUnary_Op();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.ExprVarImpl <em>Expr Var</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.ExprVarImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getExprVar()
		 * @generated
		 */
		EClass EXPR_VAR = eINSTANCE.getExprVar();

		/**
		 * The meta object literal for the '<em><b>Use</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPR_VAR__USE = eINSTANCE.getExprVar_Use();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.ExpressionImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.FSMImpl <em>FSM</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.FSMImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getFSM()
		 * @generated
		 */
		EClass FSM = eINSTANCE.getFSM();

		/**
		 * The meta object literal for the '<em><b>Initial State</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM__INITIAL_STATE = eINSTANCE.getFSM_InitialState();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM__STATES = eINSTANCE.getFSM_States();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM__TRANSITIONS = eINSTANCE.getFSM_Transitions();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.InstAssignImpl <em>Inst Assign</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.InstAssignImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getInstAssign()
		 * @generated
		 */
		EClass INST_ASSIGN = eINSTANCE.getInstAssign();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INST_ASSIGN__TARGET = eINSTANCE.getInstAssign_Target();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INST_ASSIGN__VALUE = eINSTANCE.getInstAssign_Value();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.InstCallImpl <em>Inst Call</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.InstCallImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getInstCall()
		 * @generated
		 */
		EClass INST_CALL = eINSTANCE.getInstCall();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference INST_CALL__PARAMETERS = eINSTANCE.getInstCall_Parameters();

		/**
		 * The meta object literal for the '<em><b>Procedure</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INST_CALL__PROCEDURE = eINSTANCE.getInstCall_Procedure();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INST_CALL__TARGET = eINSTANCE.getInstCall_Target();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.InstLoadImpl <em>Inst Load</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.InstLoadImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getInstLoad()
		 * @generated
		 */
		EClass INST_LOAD = eINSTANCE.getInstLoad();

		/**
		 * The meta object literal for the '<em><b>Indexes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INST_LOAD__INDEXES = eINSTANCE.getInstLoad_Indexes();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INST_LOAD__SOURCE = eINSTANCE.getInstLoad_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INST_LOAD__TARGET = eINSTANCE.getInstLoad_Target();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.InstPhiImpl <em>Inst Phi</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.InstPhiImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getInstPhi()
		 * @generated
		 */
		EClass INST_PHI = eINSTANCE.getInstPhi();

		/**
		 * The meta object literal for the '<em><b>Old Variable</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INST_PHI__OLD_VARIABLE = eINSTANCE.getInstPhi_OldVariable();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INST_PHI__TARGET = eINSTANCE.getInstPhi_Target();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INST_PHI__VALUES = eINSTANCE.getInstPhi_Values();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.InstReturnImpl <em>Inst Return</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.InstReturnImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getInstReturn()
		 * @generated
		 */
		EClass INST_RETURN = eINSTANCE.getInstReturn();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INST_RETURN__VALUE = eINSTANCE.getInstReturn_Value();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.InstSpecificImpl <em>Inst Specific</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.InstSpecificImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getInstSpecific()
		 * @generated
		 */
		EClass INST_SPECIFIC = eINSTANCE.getInstSpecific();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.InstStoreImpl <em>Inst Store</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.InstStoreImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getInstStore()
		 * @generated
		 */
		EClass INST_STORE = eINSTANCE.getInstStore();

		/**
		 * The meta object literal for the '<em><b>Indexes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INST_STORE__INDEXES = eINSTANCE.getInstStore_Indexes();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INST_STORE__TARGET = eINSTANCE.getInstStore_Target();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INST_STORE__VALUE = eINSTANCE.getInstStore_Value();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.InstructionImpl <em>Instruction</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.InstructionImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getInstruction()
		 * @generated
		 */
		EClass INSTRUCTION = eINSTANCE.getInstruction();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference INSTRUCTION__LOCATION = eINSTANCE.getInstruction_Location();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTRUCTION__PREDICATE = eINSTANCE.getInstruction_Predicate();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.LocationImpl <em>Location</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.LocationImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getLocation()
		 * @generated
		 */
		EClass LOCATION = eINSTANCE.getLocation();

		/**
		 * The meta object literal for the '<em><b>End Column</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__END_COLUMN = eINSTANCE.getLocation_EndColumn();

		/**
		 * The meta object literal for the '<em><b>Start Column</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__START_COLUMN = eINSTANCE.getLocation_StartColumn();

		/**
		 * The meta object literal for the '<em><b>Start Line</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__START_LINE = eINSTANCE.getLocation_StartLine();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.NodeImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference NODE__LOCATION = eINSTANCE.getNode_Location();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.NodeBlockImpl <em>Node Block</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.NodeBlockImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getNodeBlock()
		 * @generated
		 */
		EClass NODE_BLOCK = eINSTANCE.getNodeBlock();

		/**
		 * The meta object literal for the '<em><b>Instructions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference NODE_BLOCK__INSTRUCTIONS = eINSTANCE.getNodeBlock_Instructions();

		/**
		 * The meta object literal for the '
		 * {@link net.sf.orcc.ir.impl.NodeIfImpl <em>Node If</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see net.sf.orcc.ir.impl.NodeIfImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getNodeIf()
		 * @generated
		 */
		EClass NODE_IF = eINSTANCE.getNodeIf();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference NODE_IF__CONDITION = eINSTANCE.getNodeIf_Condition();

		/**
		 * The meta object literal for the '<em><b>Else Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference NODE_IF__ELSE_NODES = eINSTANCE.getNodeIf_ElseNodes();

		/**
		 * The meta object literal for the '<em><b>Join Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference NODE_IF__JOIN_NODE = eINSTANCE.getNodeIf_JoinNode();

		/**
		 * The meta object literal for the '<em><b>Then Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference NODE_IF__THEN_NODES = eINSTANCE.getNodeIf_ThenNodes();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.NodeWhileImpl <em>Node While</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.NodeWhileImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getNodeWhile()
		 * @generated
		 */
		EClass NODE_WHILE = eINSTANCE.getNodeWhile();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference NODE_WHILE__CONDITION = eINSTANCE.getNodeWhile_Condition();

		/**
		 * The meta object literal for the '<em><b>Join Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference NODE_WHILE__JOIN_NODE = eINSTANCE.getNodeWhile_JoinNode();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_WHILE__NODES = eINSTANCE.getNodeWhile_Nodes();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.OpBinary
		 * <em>Op Binary</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see net.sf.orcc.ir.OpBinary
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getOpBinary()
		 * @generated
		 */
		EEnum OP_BINARY = eINSTANCE.getOpBinary();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.OpUnary
		 * <em>Op Unary</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see net.sf.orcc.ir.OpUnary
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getOpUnary()
		 * @generated
		 */
		EEnum OP_UNARY = eINSTANCE.getOpUnary();

		/**
		 * The meta object literal for the '
		 * {@link net.sf.orcc.ir.impl.PatternImpl <em>Pattern</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see net.sf.orcc.ir.impl.PatternImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getPattern()
		 * @generated
		 */
		EClass PATTERN = eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '<em><b>Num Tokens Map</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__NUM_TOKENS_MAP = eINSTANCE.getPattern_NumTokensMap();

		/**
		 * The meta object literal for the '<em><b>Port To Var Map</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__PORT_TO_VAR_MAP = eINSTANCE.getPattern_PortToVarMap();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__PORTS = eINSTANCE.getPattern_Ports();

		/**
		 * The meta object literal for the '<em><b>Var To Port Map</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__VAR_TO_PORT_MAP = eINSTANCE.getPattern_VarToPortMap();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.PortImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference PORT__LOCATION = eINSTANCE.getPort_Location();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__NAME = eINSTANCE.getPort_Name();

		/**
		 * The meta object literal for the '<em><b>Num Tokens Consumed</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__NUM_TOKENS_CONSUMED = eINSTANCE.getPort_NumTokensConsumed();

		/**
		 * The meta object literal for the '<em><b>Num Tokens Produced</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__NUM_TOKENS_PRODUCED = eINSTANCE.getPort_NumTokensProduced();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__TYPE = eINSTANCE.getPort_Type();

		/**
		 * The meta object literal for the '
		 * {@link net.sf.orcc.ir.impl.PortToEIntegerObjectMapEntryImpl
		 * <em>Port To EInteger Object Map Entry</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see net.sf.orcc.ir.impl.PortToEIntegerObjectMapEntryImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getPortToEIntegerObjectMapEntry()
		 * @generated
		 */
		EClass PORT_TO_EINTEGER_OBJECT_MAP_ENTRY = eINSTANCE.getPortToEIntegerObjectMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_TO_EINTEGER_OBJECT_MAP_ENTRY__KEY = eINSTANCE.getPortToEIntegerObjectMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_TO_EINTEGER_OBJECT_MAP_ENTRY__VALUE = eINSTANCE.getPortToEIntegerObjectMapEntry_Value();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.PortToVarMapEntryImpl <em>Port To Var Map Entry</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see net.sf.orcc.ir.impl.PortToVarMapEntryImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getPortToVarMapEntry()
		 * @generated
		 */
		EClass PORT_TO_VAR_MAP_ENTRY = eINSTANCE.getPortToVarMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_TO_VAR_MAP_ENTRY__KEY = eINSTANCE.getPortToVarMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_TO_VAR_MAP_ENTRY__VALUE = eINSTANCE.getPortToVarMapEntry_Value();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.ProcedureImpl <em>Procedure</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.ProcedureImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getProcedure()
		 * @generated
		 */
		EClass PROCEDURE = eINSTANCE.getProcedure();

		/**
		 * The meta object literal for the '<em><b>Locals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE__LOCALS = eINSTANCE.getProcedure_Locals();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE__LOCATION = eINSTANCE.getProcedure_Location();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCEDURE__NAME = eINSTANCE.getProcedure_Name();

		/**
		 * The meta object literal for the '<em><b>Native</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCEDURE__NATIVE = eINSTANCE.getProcedure_Native();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE__NODES = eINSTANCE.getProcedure_Nodes();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE__PARAMETERS = eINSTANCE.getProcedure_Parameters();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE__RETURN_TYPE = eINSTANCE.getProcedure_ReturnType();

		/**
		 * The meta object literal for the '
		 * {@link net.sf.orcc.ir.impl.StateImpl <em>State</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see net.sf.orcc.ir.impl.StateImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__NAME = eINSTANCE.getState_Name();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.TransitionsImpl <em>Transitions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.TransitionsImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTransitions()
		 * @generated
		 */
		EClass TRANSITIONS = eINSTANCE.getTransitions();

		/**
		 * The meta object literal for the '<em><b>List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITIONS__LIST = eINSTANCE.getTransitions_List();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.StateToTransitionsMapEntryImpl <em>State To Transitions Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.StateToTransitionsMapEntryImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getStateToTransitionsMapEntry()
		 * @generated
		 */
		EClass STATE_TO_TRANSITIONS_MAP_ENTRY = eINSTANCE.getStateToTransitionsMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_TO_TRANSITIONS_MAP_ENTRY__KEY = eINSTANCE.getStateToTransitionsMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_TO_TRANSITIONS_MAP_ENTRY__VALUE = eINSTANCE.getStateToTransitionsMapEntry_Value();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.TagImpl <em>Tag</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.TagImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTag()
		 * @generated
		 */
		EClass TAG = eINSTANCE.getTag();

		/**
		 * The meta object literal for the '<em><b>Identifiers</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__IDENTIFIERS = eINSTANCE.getTag_Identifiers();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.TransitionImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__ACTION = eINSTANCE.getTransition_Action();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__STATE = eINSTANCE.getTransition_State();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.TypeImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.TypeBoolImpl <em>Type Bool</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.TypeBoolImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTypeBool()
		 * @generated
		 */
		EClass TYPE_BOOL = eINSTANCE.getTypeBool();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.TypeFloatImpl <em>Type Float</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.TypeFloatImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTypeFloat()
		 * @generated
		 */
		EClass TYPE_FLOAT = eINSTANCE.getTypeFloat();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.TypeIntImpl <em>Type Int</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.TypeIntImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTypeInt()
		 * @generated
		 */
		EClass TYPE_INT = eINSTANCE.getTypeInt();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_INT__SIZE = eINSTANCE.getTypeInt_Size();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.TypeListImpl <em>Type List</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.TypeListImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTypeList()
		 * @generated
		 */
		EClass TYPE_LIST = eINSTANCE.getTypeList();

		/**
		 * The meta object literal for the '<em><b>Size Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference TYPE_LIST__SIZE_EXPR = eINSTANCE.getTypeList_SizeExpr();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_LIST__TYPE = eINSTANCE.getTypeList_Type();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.TypeStringImpl <em>Type String</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.TypeStringImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTypeString()
		 * @generated
		 */
		EClass TYPE_STRING = eINSTANCE.getTypeString();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_STRING__SIZE = eINSTANCE.getTypeString_Size();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.TypeUintImpl <em>Type Uint</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.TypeUintImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTypeUint()
		 * @generated
		 */
		EClass TYPE_UINT = eINSTANCE.getTypeUint();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_UINT__SIZE = eINSTANCE.getTypeUint_Size();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.TypeVoidImpl <em>Type Void</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.TypeVoidImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTypeVoid()
		 * @generated
		 */
		EClass TYPE_VOID = eINSTANCE.getTypeVoid();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.UseImpl <em>Use</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.UseImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getUse()
		 * @generated
		 */
		EClass USE = eINSTANCE.getUse();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE__VARIABLE = eINSTANCE.getUse_Variable();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.VarImpl <em>Var</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see net.sf.orcc.ir.impl.VarImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getVar()
		 * @generated
		 */
		EClass VAR = eINSTANCE.getVar();

		/**
		 * The meta object literal for the '<em><b>Assignable</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR__ASSIGNABLE = eINSTANCE.getVar_Assignable();

		/**
		 * The meta object literal for the '<em><b>Defs</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR__DEFS = eINSTANCE.getVar_Defs();

		/**
		 * The meta object literal for the '<em><b>Global</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR__GLOBAL = eINSTANCE.getVar_Global();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR__INDEX = eINSTANCE.getVar_Index();

		/**
		 * The meta object literal for the '<em><b>Initial Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference VAR__INITIAL_VALUE = eINSTANCE.getVar_InitialValue();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference VAR__LOCATION = eINSTANCE.getVar_Location();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR__NAME = eINSTANCE.getVar_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR__TYPE = eINSTANCE.getVar_Type();

		/**
		 * The meta object literal for the '<em><b>Uses</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR__USES = eINSTANCE.getVar_Uses();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR__VALUE = eINSTANCE.getVar_Value();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.ir.impl.VarToPortMapEntryImpl <em>Var To Port Map Entry</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see net.sf.orcc.ir.impl.VarToPortMapEntryImpl
		 * @see net.sf.orcc.ir.impl.IrPackageImpl#getVarToPortMapEntry()
		 * @generated
		 */
		EClass VAR_TO_PORT_MAP_ENTRY = eINSTANCE.getVarToPortMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_TO_PORT_MAP_ENTRY__KEY = eINSTANCE.getVarToPortMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_TO_PORT_MAP_ENTRY__VALUE = eINSTANCE.getVarToPortMapEntry_Value();

	}

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.ActionImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 6;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.ActorImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 0;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__ACTIONS = 0;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTOR__FILE = 1;

	/**
	 * The feature id for the '<em><b>Initializes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__INITIALIZES = 2;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__INPUTS = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTOR__NAME = 4;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__OUTPUTS = 5;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__PARAMETERS = 6;

	/**
	 * The feature id for the '<em><b>Procs</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__PROCS = 7;

	/**
	 * The feature id for the '<em><b>State Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__STATE_VARS = 8;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTOR__NATIVE = 9;

	/**
	 * The feature id for the '<em><b>Actions Outside Fsm</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__ACTIONS_OUTSIDE_FSM = 10;

	/**
	 * The feature id for the '<em><b>Fsm</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTOR__FSM = 11;

	/**
	 * The feature id for the '<em><b>Mo C</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTOR__MO_C = 12;

	/**
	 * The number of structural features of the '<em>Actor</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = 13;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.DefImpl <em>Def</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.DefImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getDef()
	 * @generated
	 */
	int DEF = 40;

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	IrPackage eINSTANCE = net.sf.orcc.ir.impl.IrPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.common.util.EMap <em>EMap</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.EMap
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getEMap()
	 * @generated
	 */
	int EMAP = 43;

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ir";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "net.sf.orcc.ir";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://orcc.sf.net/ir/Ir";

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.ExprBinaryImpl
	 * <em>Expr Binary</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see net.sf.orcc.ir.impl.ExprBinaryImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getExprBinary()
	 * @generated
	 */
	int EXPR_BINARY = 23;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.ExprBoolImpl <em>Expr Bool</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.ExprBoolImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getExprBool()
	 * @generated
	 */
	int EXPR_BOOL = 24;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.ExprFloatImpl
	 * <em>Expr Float</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see net.sf.orcc.ir.impl.ExprFloatImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getExprFloat()
	 * @generated
	 */
	int EXPR_FLOAT = 25;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.ExprIntImpl <em>Expr Int</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.ExprIntImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getExprInt()
	 * @generated
	 */
	int EXPR_INT = 26;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.ExprListImpl <em>Expr List</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.ExprListImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getExprList()
	 * @generated
	 */
	int EXPR_LIST = 27;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.ExprStringImpl
	 * <em>Expr String</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see net.sf.orcc.ir.impl.ExprStringImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getExprString()
	 * @generated
	 */
	int EXPR_STRING = 28;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.ExprUnaryImpl
	 * <em>Expr Unary</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see net.sf.orcc.ir.impl.ExprUnaryImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getExprUnary()
	 * @generated
	 */
	int EXPR_UNARY = 29;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.ExprVarImpl <em>Expr Var</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.ExprVarImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getExprVar()
	 * @generated
	 */
	int EXPR_VAR = 30;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.ExpressionImpl
	 * <em>Expression</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see net.sf.orcc.ir.impl.ExpressionImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 22;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.FSMImpl <em>FSM</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.FSMImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getFSM()
	 * @generated
	 */
	int FSM = 2;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.InstructionImpl
	 * <em>Instruction</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see net.sf.orcc.ir.impl.InstructionImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getInstruction()
	 * @generated
	 */
	int INSTRUCTION = 14;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.InstAssignImpl
	 * <em>Inst Assign</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see net.sf.orcc.ir.impl.InstAssignImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getInstAssign()
	 * @generated
	 */
	int INST_ASSIGN = 15;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.InstCallImpl <em>Inst Call</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.InstCallImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getInstCall()
	 * @generated
	 */
	int INST_CALL = 16;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.InstLoadImpl <em>Inst Load</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.InstLoadImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getInstLoad()
	 * @generated
	 */
	int INST_LOAD = 17;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.InstPhiImpl <em>Inst Phi</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.InstPhiImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getInstPhi()
	 * @generated
	 */
	int INST_PHI = 18;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.InstReturnImpl
	 * <em>Inst Return</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see net.sf.orcc.ir.impl.InstReturnImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getInstReturn()
	 * @generated
	 */
	int INST_RETURN = 19;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.InstSpecificImpl
	 * <em>Inst Specific</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see net.sf.orcc.ir.impl.InstSpecificImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getInstSpecific()
	 * @generated
	 */
	int INST_SPECIFIC = 20;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.InstStoreImpl
	 * <em>Inst Store</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see net.sf.orcc.ir.impl.InstStoreImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getInstStore()
	 * @generated
	 */
	int INST_STORE = 21;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.LocationImpl <em>Location</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.LocationImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getLocation()
	 * @generated
	 */
	int LOCATION = 39;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.NodeImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 10;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.NodeBlockImpl
	 * <em>Node Block</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see net.sf.orcc.ir.impl.NodeBlockImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getNodeBlock()
	 * @generated
	 */
	int NODE_BLOCK = 11;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.NodeIfImpl <em>Node If</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.NodeIfImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getNodeIf()
	 * @generated
	 */
	int NODE_IF = 12;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.NodeWhileImpl
	 * <em>Node While</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see net.sf.orcc.ir.impl.NodeWhileImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getNodeWhile()
	 * @generated
	 */
	int NODE_WHILE = 13;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.OpBinary <em>Op Binary</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.OpBinary
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getOpBinary()
	 * @generated
	 */
	int OP_BINARY = 48;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.OpUnary <em>Op Unary</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.OpUnary
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getOpUnary()
	 * @generated
	 */
	int OP_UNARY = 49;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.PatternImpl <em>Pattern</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.PatternImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 8;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.PortImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Num Tokens Consumed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NUM_TOKENS_CONSUMED = 2;

	/**
	 * The feature id for the '<em><b>Num Tokens Produced</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NUM_TOKENS_PRODUCED = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT__TYPE = 4;

	/**
	 * The number of structural features of the '<em>Port</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = 5;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FSM__INITIAL_STATE = 0;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM__STATES = 1;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM__TRANSITIONS = 2;

	/**
	 * The number of structural features of the '<em>FSM</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FSM_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.PortToEIntegerObjectMapEntryImpl <em>Port To EInteger Object Map Entry</em>}' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.PortToEIntegerObjectMapEntryImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getPortToEIntegerObjectMapEntry()
	 * @generated
	 */
	int PORT_TO_EINTEGER_OBJECT_MAP_ENTRY = 46;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.PortToVarMapEntryImpl <em>Port To Var Map Entry</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see net.sf.orcc.ir.impl.PortToVarMapEntryImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getPortToVarMapEntry()
	 * @generated
	 */
	int PORT_TO_VAR_MAP_ENTRY = 45;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.ProcedureImpl <em>Procedure</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.ProcedureImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getProcedure()
	 * @generated
	 */
	int PROCEDURE = 9;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.StateImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getState()
	 * @generated
	 */
	int STATE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = 0;

	/**
	 * The number of structural features of the '<em>State</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.TransitionsImpl <em>Transitions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.TransitionsImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTransitions()
	 * @generated
	 */
	int TRANSITIONS = 4;

	/**
	 * The feature id for the '<em><b>List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITIONS__LIST = 0;

	/**
	 * The number of structural features of the '<em>Transitions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITIONS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.TagImpl <em>Tag</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.TagImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTag()
	 * @generated
	 */
	int TAG = 7;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.TransitionImpl
	 * <em>Transition</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see net.sf.orcc.ir.impl.TransitionImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 5;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ACTION = 0;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__STATE = 1;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION__BODY = 0;

	/**
	 * The feature id for the '<em><b>Input Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__INPUT_PATTERN = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Output Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__OUTPUT_PATTERN = 3;

	/**
	 * The feature id for the '<em><b>Scheduler</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__SCHEDULER = 4;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION__TAG = 5;

	/**
	 * The feature id for the '<em><b>Peek Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__PEEK_PATTERN = 6;

	/**
	 * The number of structural features of the '<em>Action</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 7;

	/**
	 * The feature id for the '<em><b>Identifiers</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAG__IDENTIFIERS = 0;

	/**
	 * The number of structural features of the '<em>Tag</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAG_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PATTERN__PORTS = 0;

	/**
	 * The feature id for the '<em><b>Num Tokens Map</b></em>' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PATTERN__NUM_TOKENS_MAP = 1;

	/**
	 * The feature id for the '<em><b>Port To Var Map</b></em>' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PATTERN__PORT_TO_VAR_MAP = 2;

	/**
	 * The feature id for the '<em><b>Var To Port Map</b></em>' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PATTERN__VAR_TO_PORT_MAP = 3;

	/**
	 * The number of structural features of the '<em>Pattern</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PATTERN_FEATURE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__NODES = 2;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__RETURN_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__NATIVE = 4;

	/**
	 * The feature id for the '<em><b>Locals</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__LOCALS = 5;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__PARAMETERS = 6;

	/**
	 * The number of structural features of the '<em>Procedure</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_FEATURE_COUNT = 7;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__LOCATION = 0;

	/**
	 * The number of structural features of the '<em>Node</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_BLOCK__LOCATION = NODE__LOCATION;

	/**
	 * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_BLOCK__INSTRUCTIONS = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node Block</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_BLOCK_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_IF__LOCATION = NODE__LOCATION;

	/**
	 * The feature id for the '<em><b>Else Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_IF__ELSE_NODES = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Join Node</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_IF__JOIN_NODE = NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Then Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_IF__THEN_NODES = NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_IF__CONDITION = NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Node If</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NODE_IF_FEATURE_COUNT = NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_WHILE__LOCATION = NODE__LOCATION;

	/**
	 * The feature id for the '<em><b>Join Node</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_WHILE__JOIN_NODE = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_WHILE__NODES = NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_WHILE__CONDITION = NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Node While</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_WHILE_FEATURE_COUNT = NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION__LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION__PREDICATE = 1;

	/**
	 * The number of structural features of the '<em>Instruction</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INST_ASSIGN__LOCATION = INSTRUCTION__LOCATION;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INST_ASSIGN__PREDICATE = INSTRUCTION__PREDICATE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INST_ASSIGN__TARGET = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INST_ASSIGN__VALUE = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Inst Assign</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INST_ASSIGN_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INST_CALL__LOCATION = INSTRUCTION__LOCATION;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INST_CALL__PREDICATE = INSTRUCTION__PREDICATE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INST_CALL__PARAMETERS = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Procedure</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INST_CALL__PROCEDURE = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INST_CALL__TARGET = INSTRUCTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Inst Call</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INST_CALL_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INST_LOAD__LOCATION = INSTRUCTION__LOCATION;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INST_LOAD__PREDICATE = INSTRUCTION__PREDICATE;

	/**
	 * The feature id for the '<em><b>Indexes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INST_LOAD__INDEXES = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INST_LOAD__SOURCE = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INST_LOAD__TARGET = INSTRUCTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Inst Load</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INST_LOAD_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INST_PHI__LOCATION = INSTRUCTION__LOCATION;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INST_PHI__PREDICATE = INSTRUCTION__PREDICATE;

	/**
	 * The feature id for the '<em><b>Old Variable</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INST_PHI__OLD_VARIABLE = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INST_PHI__TARGET = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INST_PHI__VALUES = INSTRUCTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Inst Phi</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INST_PHI_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INST_RETURN__LOCATION = INSTRUCTION__LOCATION;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INST_RETURN__PREDICATE = INSTRUCTION__PREDICATE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INST_RETURN__VALUE = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Inst Return</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INST_RETURN_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INST_SPECIFIC__LOCATION = INSTRUCTION__LOCATION;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INST_SPECIFIC__PREDICATE = INSTRUCTION__PREDICATE;

	/**
	 * The number of structural features of the '<em>Inst Specific</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INST_SPECIFIC_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INST_STORE__LOCATION = INSTRUCTION__LOCATION;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INST_STORE__PREDICATE = INSTRUCTION__PREDICATE;

	/**
	 * The feature id for the '<em><b>Indexes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INST_STORE__INDEXES = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INST_STORE__TARGET = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INST_STORE__VALUE = INSTRUCTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Inst Store</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INST_STORE_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>E1</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPR_BINARY__E1 = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>E2</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPR_BINARY__E2 = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPR_BINARY__OP = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPR_BINARY__TYPE = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Expr Binary</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_BINARY_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPR_BOOL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expr Bool</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPR_BOOL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPR_FLOAT__VALUE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expr Float</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_FLOAT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPR_INT__VALUE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expr Int</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPR_INT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_LIST__VALUE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expr List</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPR_LIST_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPR_STRING__VALUE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expr String</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_STRING_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPR_UNARY__EXPR = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPR_UNARY__OP = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Expr Unary</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_UNARY_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Use</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPR_VAR__USE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expr Var</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPR_VAR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.TypeImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 31;

	/**
	 * The number of structural features of the '<em>Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.TypeBoolImpl <em>Type Bool</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.TypeBoolImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTypeBool()
	 * @generated
	 */
	int TYPE_BOOL = 32;

	/**
	 * The number of structural features of the '<em>Type Bool</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_BOOL_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.TypeFloatImpl
	 * <em>Type Float</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see net.sf.orcc.ir.impl.TypeFloatImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTypeFloat()
	 * @generated
	 */
	int TYPE_FLOAT = 33;

	/**
	 * The number of structural features of the '<em>Type Float</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FLOAT_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.TypeIntImpl <em>Type Int</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.TypeIntImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTypeInt()
	 * @generated
	 */
	int TYPE_INT = 34;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_INT__SIZE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Int</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_INT_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.TypeListImpl <em>Type List</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.TypeListImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTypeList()
	 * @generated
	 */
	int TYPE_LIST = 35;

	/**
	 * The feature id for the '<em><b>Size Expr</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LIST__SIZE_EXPR = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_LIST__TYPE = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type List</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_LIST_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.TypeStringImpl
	 * <em>Type String</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see net.sf.orcc.ir.impl.TypeStringImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTypeString()
	 * @generated
	 */
	int TYPE_STRING = 36;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_STRING__SIZE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type String</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_STRING_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.TypeUintImpl <em>Type Uint</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.TypeUintImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTypeUint()
	 * @generated
	 */
	int TYPE_UINT = 37;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_UINT__SIZE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Uint</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_UINT_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.TypeVoidImpl <em>Type Void</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.TypeVoidImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getTypeVoid()
	 * @generated
	 */
	int TYPE_VOID = 38;

	/**
	 * The number of structural features of the '<em>Type Void</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_VOID_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Column</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCATION__END_COLUMN = 0;

	/**
	 * The feature id for the '<em><b>Start Column</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCATION__START_COLUMN = 1;

	/**
	 * The feature id for the '<em><b>Start Line</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCATION__START_LINE = 2;

	/**
	 * The number of structural features of the '<em>Location</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCATION_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEF__VARIABLE = 0;

	/**
	 * The number of structural features of the '<em>Def</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEF_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.UseImpl <em>Use</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.UseImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getUse()
	 * @generated
	 */
	int USE = 42;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.VarImpl <em>Var</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.VarImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getVar()
	 * @generated
	 */
	int VAR = 41;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VAR__INDEX = 0;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__INITIAL_VALUE = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VAR__NAME = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VAR__TYPE = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__VALUE = 5;

	/**
	 * The feature id for the '<em><b>Assignable</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VAR__ASSIGNABLE = 6;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VAR__GLOBAL = 7;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VAR__USES = 8;

	/**
	 * The feature id for the '<em><b>Defs</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VAR__DEFS = 9;

	/**
	 * The number of structural features of the '<em>Var</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VAR_FEATURE_COUNT = 10;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USE__VARIABLE = 0;

	/**
	 * The number of structural features of the '<em>Use</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USE_FEATURE_COUNT = 1;

	/**
	 * The number of structural features of the '<em>EMap</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMAP_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.VarToPortMapEntryImpl <em>Var To Port Map Entry</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see net.sf.orcc.ir.impl.VarToPortMapEntryImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getVarToPortMapEntry()
	 * @generated
	 */
	int VAR_TO_PORT_MAP_ENTRY = 44;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VAR_TO_PORT_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VAR_TO_PORT_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Var To Port Map Entry</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_TO_PORT_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_TO_VAR_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_TO_VAR_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Port To Var Map Entry</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TO_VAR_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_TO_EINTEGER_OBJECT_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_TO_EINTEGER_OBJECT_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Port To EInteger Object Map Entry</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TO_EINTEGER_OBJECT_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link net.sf.orcc.ir.impl.StateToTransitionsMapEntryImpl <em>State To Transitions Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.ir.impl.StateToTransitionsMapEntryImpl
	 * @see net.sf.orcc.ir.impl.IrPackageImpl#getStateToTransitionsMapEntry()
	 * @generated
	 */
	int STATE_TO_TRANSITIONS_MAP_ENTRY = 47;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TO_TRANSITIONS_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TO_TRANSITIONS_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>State To Transitions Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TO_TRANSITIONS_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.Action <em>Action</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see net.sf.orcc.ir.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.orcc.ir.Action#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see net.sf.orcc.ir.Action#getBody()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Body();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.orcc.ir.Action#getInputPattern <em>Input Pattern</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input Pattern</em>'.
	 * @see net.sf.orcc.ir.Action#getInputPattern()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_InputPattern();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.Action#getLocation <em>Location</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Location</em>
	 *         '.
	 * @see net.sf.orcc.ir.Action#getLocation()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Location();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.orcc.ir.Action#getOutputPattern <em>Output Pattern</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output Pattern</em>'.
	 * @see net.sf.orcc.ir.Action#getOutputPattern()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_OutputPattern();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.Action#getPeekPattern <em>Peek Pattern</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '
	 *         <em>Peek Pattern</em>'.
	 * @see net.sf.orcc.ir.Action#getPeekPattern()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_PeekPattern();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.Action#getScheduler <em>Scheduler</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Scheduler</em>
	 *         '.
	 * @see net.sf.orcc.ir.Action#getScheduler()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Scheduler();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.orcc.ir.Action#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tag</em>'.
	 * @see net.sf.orcc.ir.Action#getTag()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Tag();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see net.sf.orcc.ir.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.Actor#getActions <em>Actions</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Actions</em>'.
	 * @see net.sf.orcc.ir.Actor#getActions()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Actions();

	/**
	 * Returns the meta object for the reference list '
	 * {@link net.sf.orcc.ir.Actor#getActionsOutsideFsm
	 * <em>Actions Outside Fsm</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference list '
	 *         <em>Actions Outside Fsm</em>'.
	 * @see net.sf.orcc.ir.Actor#getActionsOutsideFsm()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_ActionsOutsideFsm();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.ir.Actor#getFile <em>File</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see net.sf.orcc.ir.Actor#getFile()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_File();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.orcc.ir.Actor#getFsm <em>Fsm</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fsm</em>'.
	 * @see net.sf.orcc.ir.Actor#getFsm()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Fsm();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.Actor#getInitializes <em>Initializes</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Initializes</em>'.
	 * @see net.sf.orcc.ir.Actor#getInitializes()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Initializes();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.Actor#getInputs <em>Inputs</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Inputs</em>'.
	 * @see net.sf.orcc.ir.Actor#getInputs()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Inputs();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.orcc.ir.Actor#getMoC <em>Mo C</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mo C</em>'.
	 * @see net.sf.orcc.ir.Actor#getMoC()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_MoC();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.ir.Actor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.orcc.ir.Actor#getName()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_Name();

	/**
	 * Returns the meta object for the attribute '
	 * {@link net.sf.orcc.ir.Actor#isNative <em>Native</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Native</em>'.
	 * @see net.sf.orcc.ir.Actor#isNative()
	 * @see #getActor()
	 * @generated
	 */
	EAttribute getActor_Native();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.Actor#getOutputs <em>Outputs</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Outputs</em>'.
	 * @see net.sf.orcc.ir.Actor#getOutputs()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Outputs();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.Actor#getParameters <em>Parameters</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Parameters</em>'.
	 * @see net.sf.orcc.ir.Actor#getParameters()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Parameters();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.Actor#getProcs <em>Procs</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Procs</em>'.
	 * @see net.sf.orcc.ir.Actor#getProcs()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Procs();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.Actor#getStateVars <em>State Vars</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>State Vars</em>'.
	 * @see net.sf.orcc.ir.Actor#getStateVars()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_StateVars();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.Def <em>Def</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Def</em>'.
	 * @see net.sf.orcc.ir.Def
	 * @generated
	 */
	EClass getDef();

	/**
	 * Returns the meta object for the reference '
	 * {@link net.sf.orcc.ir.Def#getVariable <em>Variable</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see net.sf.orcc.ir.Def#getVariable()
	 * @see #getDef()
	 * @generated
	 */
	EReference getDef_Variable();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.emf.common.util.EMap <em>EMap</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>EMap</em>'.
	 * @see org.eclipse.emf.common.util.EMap
	 * @model instanceClass="org.eclipse.emf.common.util.EMap"
	 *        typeParameters="T T1"
	 * @generated
	 */
	EClass getEMap();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.ExprBinary <em>Expr Binary</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expr Binary</em>'.
	 * @see net.sf.orcc.ir.ExprBinary
	 * @generated
	 */
	EClass getExprBinary();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.orcc.ir.ExprBinary#getE1 <em>E1</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>E1</em>'.
	 * @see net.sf.orcc.ir.ExprBinary#getE1()
	 * @see #getExprBinary()
	 * @generated
	 */
	EReference getExprBinary_E1();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.orcc.ir.ExprBinary#getE2 <em>E2</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>E2</em>'.
	 * @see net.sf.orcc.ir.ExprBinary#getE2()
	 * @see #getExprBinary()
	 * @generated
	 */
	EReference getExprBinary_E2();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.ir.ExprBinary#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see net.sf.orcc.ir.ExprBinary#getOp()
	 * @see #getExprBinary()
	 * @generated
	 */
	EAttribute getExprBinary_Op();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.ExprBinary#getType <em>Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see net.sf.orcc.ir.ExprBinary#getType()
	 * @see #getExprBinary()
	 * @generated
	 */
	EReference getExprBinary_Type();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.ExprBool <em>Expr Bool</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expr Bool</em>'.
	 * @see net.sf.orcc.ir.ExprBool
	 * @generated
	 */
	EClass getExprBool();

	/**
	 * Returns the meta object for the attribute '
	 * {@link net.sf.orcc.ir.ExprBool#isValue <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see net.sf.orcc.ir.ExprBool#isValue()
	 * @see #getExprBool()
	 * @generated
	 */
	EAttribute getExprBool_Value();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see net.sf.orcc.ir.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.ExprFloat <em>Expr Float</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expr Float</em>'.
	 * @see net.sf.orcc.ir.ExprFloat
	 * @generated
	 */
	EClass getExprFloat();

	/**
	 * Returns the meta object for the attribute '
	 * {@link net.sf.orcc.ir.ExprFloat#getValue <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see net.sf.orcc.ir.ExprFloat#getValue()
	 * @see #getExprFloat()
	 * @generated
	 */
	EAttribute getExprFloat_Value();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.ExprInt <em>Expr Int</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expr Int</em>'.
	 * @see net.sf.orcc.ir.ExprInt
	 * @generated
	 */
	EClass getExprInt();

	/**
	 * Returns the meta object for the attribute '
	 * {@link net.sf.orcc.ir.ExprInt#getValue <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see net.sf.orcc.ir.ExprInt#getValue()
	 * @see #getExprInt()
	 * @generated
	 */
	EAttribute getExprInt_Value();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.ExprList <em>Expr List</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expr List</em>'.
	 * @see net.sf.orcc.ir.ExprList
	 * @generated
	 */
	EClass getExprList();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.ExprList#getValue <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Value</em>'.
	 * @see net.sf.orcc.ir.ExprList#getValue()
	 * @see #getExprList()
	 * @generated
	 */
	EReference getExprList_Value();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.ExprString <em>Expr String</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expr String</em>'.
	 * @see net.sf.orcc.ir.ExprString
	 * @generated
	 */
	EClass getExprString();

	/**
	 * Returns the meta object for the reference '
	 * {@link net.sf.orcc.ir.ExprString#getValue <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see net.sf.orcc.ir.ExprString#getValue()
	 * @see #getExprString()
	 * @generated
	 */
	EAttribute getExprString_Value();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.ExprUnary <em>Expr Unary</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expr Unary</em>'.
	 * @see net.sf.orcc.ir.ExprUnary
	 * @generated
	 */
	EClass getExprUnary();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.ExprUnary#getExpr <em>Expr</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see net.sf.orcc.ir.ExprUnary#getExpr()
	 * @see #getExprUnary()
	 * @generated
	 */
	EReference getExprUnary_Expr();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.ir.ExprUnary#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see net.sf.orcc.ir.ExprUnary#getOp()
	 * @see #getExprUnary()
	 * @generated
	 */
	EAttribute getExprUnary_Op();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.ExprVar <em>Expr Var</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expr Var</em>'.
	 * @see net.sf.orcc.ir.ExprVar
	 * @generated
	 */
	EClass getExprVar();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.orcc.ir.ExprVar#getUse <em>Use</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Use</em>'.
	 * @see net.sf.orcc.ir.ExprVar#getUse()
	 * @see #getExprVar()
	 * @generated
	 */
	EReference getExprVar_Use();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.FSM <em>FSM</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>FSM</em>'.
	 * @see net.sf.orcc.ir.FSM
	 * @generated
	 */
	EClass getFSM();

	/**
	 * Returns the meta object for the reference '
	 * {@link net.sf.orcc.ir.FSM#getInitialState <em>Initial State</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Initial State</em>'.
	 * @see net.sf.orcc.ir.FSM#getInitialState()
	 * @see #getFSM()
	 * @generated
	 */
	EReference getFSM_InitialState();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.FSM#getStates <em>States</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>States</em>'.
	 * @see net.sf.orcc.ir.FSM#getStates()
	 * @see #getFSM()
	 * @generated
	 */
	EReference getFSM_States();

	/**
	 * Returns the meta object for the map '{@link net.sf.orcc.ir.FSM#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Transitions</em>'.
	 * @see net.sf.orcc.ir.FSM#getTransitions()
	 * @see #getFSM()
	 * @generated
	 */
	EReference getFSM_Transitions();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.InstAssign <em>Inst Assign</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inst Assign</em>'.
	 * @see net.sf.orcc.ir.InstAssign
	 * @generated
	 */
	EClass getInstAssign();

	/**
	 * Returns the meta object for the reference '
	 * {@link net.sf.orcc.ir.InstAssign#getTarget <em>Target</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see net.sf.orcc.ir.InstAssign#getTarget()
	 * @see #getInstAssign()
	 * @generated
	 */
	EReference getInstAssign_Target();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.InstAssign#getValue <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see net.sf.orcc.ir.InstAssign#getValue()
	 * @see #getInstAssign()
	 * @generated
	 */
	EReference getInstAssign_Value();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.InstCall <em>Inst Call</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inst Call</em>'.
	 * @see net.sf.orcc.ir.InstCall
	 * @generated
	 */
	EClass getInstCall();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.InstCall#getParameters <em>Parameters</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Parameters</em>'.
	 * @see net.sf.orcc.ir.InstCall#getParameters()
	 * @see #getInstCall()
	 * @generated
	 */
	EReference getInstCall_Parameters();

	/**
	 * Returns the meta object for the reference '
	 * {@link net.sf.orcc.ir.InstCall#getProcedure <em>Procedure</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Procedure</em>'.
	 * @see net.sf.orcc.ir.InstCall#getProcedure()
	 * @see #getInstCall()
	 * @generated
	 */
	EReference getInstCall_Procedure();

	/**
	 * Returns the meta object for the reference '
	 * {@link net.sf.orcc.ir.InstCall#getTarget <em>Target</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see net.sf.orcc.ir.InstCall#getTarget()
	 * @see #getInstCall()
	 * @generated
	 */
	EReference getInstCall_Target();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.InstLoad <em>Inst Load</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inst Load</em>'.
	 * @see net.sf.orcc.ir.InstLoad
	 * @generated
	 */
	EClass getInstLoad();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.InstLoad#getIndexes <em>Indexes</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Indexes</em>'.
	 * @see net.sf.orcc.ir.InstLoad#getIndexes()
	 * @see #getInstLoad()
	 * @generated
	 */
	EReference getInstLoad_Indexes();

	/**
	 * Returns the meta object for the reference '
	 * {@link net.sf.orcc.ir.InstLoad#getSource <em>Source</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see net.sf.orcc.ir.InstLoad#getSource()
	 * @see #getInstLoad()
	 * @generated
	 */
	EReference getInstLoad_Source();

	/**
	 * Returns the meta object for the reference '
	 * {@link net.sf.orcc.ir.InstLoad#getTarget <em>Target</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see net.sf.orcc.ir.InstLoad#getTarget()
	 * @see #getInstLoad()
	 * @generated
	 */
	EReference getInstLoad_Target();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.InstPhi <em>Inst Phi</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inst Phi</em>'.
	 * @see net.sf.orcc.ir.InstPhi
	 * @generated
	 */
	EClass getInstPhi();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.ir.InstPhi#getOldVariable <em>Old Variable</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Old Variable</em>'.
	 * @see net.sf.orcc.ir.InstPhi#getOldVariable()
	 * @see #getInstPhi()
	 * @generated
	 */
	EReference getInstPhi_OldVariable();

	/**
	 * Returns the meta object for the reference '
	 * {@link net.sf.orcc.ir.InstPhi#getTarget <em>Target</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see net.sf.orcc.ir.InstPhi#getTarget()
	 * @see #getInstPhi()
	 * @generated
	 */
	EReference getInstPhi_Target();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.InstPhi#getValues <em>Values</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Values</em>'.
	 * @see net.sf.orcc.ir.InstPhi#getValues()
	 * @see #getInstPhi()
	 * @generated
	 */
	EReference getInstPhi_Values();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.InstReturn <em>Inst Return</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inst Return</em>'.
	 * @see net.sf.orcc.ir.InstReturn
	 * @generated
	 */
	EClass getInstReturn();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.InstReturn#getValue <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see net.sf.orcc.ir.InstReturn#getValue()
	 * @see #getInstReturn()
	 * @generated
	 */
	EReference getInstReturn_Value();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.Instruction <em>Instruction</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instruction</em>'.
	 * @see net.sf.orcc.ir.Instruction
	 * @generated
	 */
	EClass getInstruction();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.Instruction#getLocation <em>Location</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Location</em>
	 *         '.
	 * @see net.sf.orcc.ir.Instruction#getLocation()
	 * @see #getInstruction()
	 * @generated
	 */
	EReference getInstruction_Location();

	/**
	 * Returns the meta object for the reference '
	 * {@link net.sf.orcc.ir.Instruction#getPredicate <em>Predicate</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Predicate</em>'.
	 * @see net.sf.orcc.ir.Instruction#getPredicate()
	 * @see #getInstruction()
	 * @generated
	 */
	EReference getInstruction_Predicate();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.InstSpecific <em>Inst Specific</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inst Specific</em>'.
	 * @see net.sf.orcc.ir.InstSpecific
	 * @generated
	 */
	EClass getInstSpecific();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.InstStore <em>Inst Store</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inst Store</em>'.
	 * @see net.sf.orcc.ir.InstStore
	 * @generated
	 */
	EClass getInstStore();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.InstStore#getIndexes <em>Indexes</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Indexes</em>'.
	 * @see net.sf.orcc.ir.InstStore#getIndexes()
	 * @see #getInstStore()
	 * @generated
	 */
	EReference getInstStore_Indexes();

	/**
	 * Returns the meta object for the reference '
	 * {@link net.sf.orcc.ir.InstStore#getTarget <em>Target</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see net.sf.orcc.ir.InstStore#getTarget()
	 * @see #getInstStore()
	 * @generated
	 */
	EReference getInstStore_Target();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.InstStore#getValue <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see net.sf.orcc.ir.InstStore#getValue()
	 * @see #getInstStore()
	 * @generated
	 */
	EReference getInstStore_Value();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IrFactory getIrFactory();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.Location <em>Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location</em>'.
	 * @see net.sf.orcc.ir.Location
	 * @generated
	 */
	EClass getLocation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link net.sf.orcc.ir.Location#getEndColumn <em>End Column</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>End Column</em>'.
	 * @see net.sf.orcc.ir.Location#getEndColumn()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_EndColumn();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.ir.Location#getStartColumn <em>Start Column</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Column</em>'.
	 * @see net.sf.orcc.ir.Location#getStartColumn()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_StartColumn();

	/**
	 * Returns the meta object for the attribute '
	 * {@link net.sf.orcc.ir.Location#getStartLine <em>Start Line</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Start Line</em>'.
	 * @see net.sf.orcc.ir.Location#getStartLine()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_StartLine();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.Node <em>Node</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see net.sf.orcc.ir.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.Node#getLocation <em>Location</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Location</em>
	 *         '.
	 * @see net.sf.orcc.ir.Node#getLocation()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Location();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.NodeBlock <em>Node Block</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Block</em>'.
	 * @see net.sf.orcc.ir.NodeBlock
	 * @generated
	 */
	EClass getNodeBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.orcc.ir.NodeBlock#getInstructions <em>Instructions</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instructions</em>'.
	 * @see net.sf.orcc.ir.NodeBlock#getInstructions()
	 * @see #getNodeBlock()
	 * @generated
	 */
	EReference getNodeBlock_Instructions();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.NodeIf <em>Node If</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node If</em>'.
	 * @see net.sf.orcc.ir.NodeIf
	 * @generated
	 */
	EClass getNodeIf();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.NodeIf#getCondition <em>Condition</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Condition</em>
	 *         '.
	 * @see net.sf.orcc.ir.NodeIf#getCondition()
	 * @see #getNodeIf()
	 * @generated
	 */
	EReference getNodeIf_Condition();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.NodeIf#getElseNodes <em>Else Nodes</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Else Nodes</em>'.
	 * @see net.sf.orcc.ir.NodeIf#getElseNodes()
	 * @see #getNodeIf()
	 * @generated
	 */
	EReference getNodeIf_ElseNodes();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.NodeIf#getJoinNode <em>Join Node</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Join Node</em>
	 *         '.
	 * @see net.sf.orcc.ir.NodeIf#getJoinNode()
	 * @see #getNodeIf()
	 * @generated
	 */
	EReference getNodeIf_JoinNode();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.NodeIf#getThenNodes <em>Then Nodes</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Then Nodes</em>'.
	 * @see net.sf.orcc.ir.NodeIf#getThenNodes()
	 * @see #getNodeIf()
	 * @generated
	 */
	EReference getNodeIf_ThenNodes();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.NodeWhile <em>Node While</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node While</em>'.
	 * @see net.sf.orcc.ir.NodeWhile
	 * @generated
	 */
	EClass getNodeWhile();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.NodeWhile#getCondition <em>Condition</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Condition</em>
	 *         '.
	 * @see net.sf.orcc.ir.NodeWhile#getCondition()
	 * @see #getNodeWhile()
	 * @generated
	 */
	EReference getNodeWhile_Condition();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.NodeWhile#getJoinNode <em>Join Node</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Join Node</em>
	 *         '.
	 * @see net.sf.orcc.ir.NodeWhile#getJoinNode()
	 * @see #getNodeWhile()
	 * @generated
	 */
	EReference getNodeWhile_JoinNode();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.NodeWhile#getNodes <em>Nodes</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Nodes</em>'.
	 * @see net.sf.orcc.ir.NodeWhile#getNodes()
	 * @see #getNodeWhile()
	 * @generated
	 */
	EReference getNodeWhile_Nodes();

	/**
	 * Returns the meta object for enum '{@link net.sf.orcc.ir.OpBinary <em>Op Binary</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Op Binary</em>'.
	 * @see net.sf.orcc.ir.OpBinary
	 * @generated
	 */
	EEnum getOpBinary();

	/**
	 * Returns the meta object for enum '{@link net.sf.orcc.ir.OpUnary <em>Op Unary</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Op Unary</em>'.
	 * @see net.sf.orcc.ir.OpUnary
	 * @generated
	 */
	EEnum getOpUnary();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see net.sf.orcc.ir.Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for the map '{@link net.sf.orcc.ir.Pattern#getNumTokensMap <em>Num Tokens Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Num Tokens Map</em>'.
	 * @see net.sf.orcc.ir.Pattern#getNumTokensMap()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_NumTokensMap();

	/**
	 * Returns the meta object for the reference list '
	 * {@link net.sf.orcc.ir.Pattern#getPorts <em>Ports</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Ports</em>'.
	 * @see net.sf.orcc.ir.Pattern#getPorts()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Ports();

	/**
	 * Returns the meta object for the map '{@link net.sf.orcc.ir.Pattern#getPortToVarMap <em>Port To Var Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Port To Var Map</em>'.
	 * @see net.sf.orcc.ir.Pattern#getPortToVarMap()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_PortToVarMap();

	/**
	 * Returns the meta object for the map '{@link net.sf.orcc.ir.Pattern#getVarToPortMap <em>Var To Port Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Var To Port Map</em>'.
	 * @see net.sf.orcc.ir.Pattern#getVarToPortMap()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_VarToPortMap();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.Port <em>Port</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see net.sf.orcc.ir.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.Port#getLocation <em>Location</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Location</em>
	 *         '.
	 * @see net.sf.orcc.ir.Port#getLocation()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Location();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.ir.Port#getName <em>Name</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.orcc.ir.Port#getName()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Name();

	/**
	 * Returns the meta object for the attribute '
	 * {@link net.sf.orcc.ir.Port#getNumTokensConsumed
	 * <em>Num Tokens Consumed</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the attribute '<em>Num Tokens Consumed</em>'.
	 * @see net.sf.orcc.ir.Port#getNumTokensConsumed()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_NumTokensConsumed();

	/**
	 * Returns the meta object for the attribute '
	 * {@link net.sf.orcc.ir.Port#getNumTokensProduced
	 * <em>Num Tokens Produced</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the attribute '<em>Num Tokens Produced</em>'.
	 * @see net.sf.orcc.ir.Port#getNumTokensProduced()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_NumTokensProduced();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.orcc.ir.Port#getType <em>Type</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see net.sf.orcc.ir.Port#getType()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Type();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Port To EInteger Object Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port To EInteger Object Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="net.sf.orcc.ir.Port"
	 *        valueDataType="org.eclipse.emf.ecore.EIntegerObject"
	 * @generated
	 */
	EClass getPortToEIntegerObjectMapEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPortToEIntegerObjectMapEntry()
	 * @generated
	 */
	EReference getPortToEIntegerObjectMapEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPortToEIntegerObjectMapEntry()
	 * @generated
	 */
	EAttribute getPortToEIntegerObjectMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Port To Var Map Entry</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for class '<em>Port To Var Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="net.sf.orcc.ir.Port"
	 *        valueType="net.sf.orcc.ir.Var"
	 * @generated
	 */
	EClass getPortToVarMapEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPortToVarMapEntry()
	 * @generated
	 */
	EReference getPortToVarMapEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPortToVarMapEntry()
	 * @generated
	 */
	EReference getPortToVarMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.Procedure <em>Procedure</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Procedure</em>'.
	 * @see net.sf.orcc.ir.Procedure
	 * @generated
	 */
	EClass getProcedure();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.Procedure#getLocals <em>Locals</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Locals</em>'.
	 * @see net.sf.orcc.ir.Procedure#getLocals()
	 * @see #getProcedure()
	 * @generated
	 */
	EReference getProcedure_Locals();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.Procedure#getLocation <em>Location</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Location</em>
	 *         '.
	 * @see net.sf.orcc.ir.Procedure#getLocation()
	 * @see #getProcedure()
	 * @generated
	 */
	EReference getProcedure_Location();

	/**
	 * Returns the meta object for the reference '
	 * {@link net.sf.orcc.ir.Procedure#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Name</em>'.
	 * @see net.sf.orcc.ir.Procedure#getName()
	 * @see #getProcedure()
	 * @generated
	 */
	EAttribute getProcedure_Name();

	/**
	 * Returns the meta object for the attribute '
	 * {@link net.sf.orcc.ir.Procedure#isNative <em>Native</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Native</em>'.
	 * @see net.sf.orcc.ir.Procedure#isNative()
	 * @see #getProcedure()
	 * @generated
	 */
	EAttribute getProcedure_Native();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.Procedure#getNodes <em>Nodes</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Nodes</em>'.
	 * @see net.sf.orcc.ir.Procedure#getNodes()
	 * @see #getProcedure()
	 * @generated
	 */
	EReference getProcedure_Nodes();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link net.sf.orcc.ir.Procedure#getParameters <em>Parameters</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Parameters</em>'.
	 * @see net.sf.orcc.ir.Procedure#getParameters()
	 * @see #getProcedure()
	 * @generated
	 */
	EReference getProcedure_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.orcc.ir.Procedure#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see net.sf.orcc.ir.Procedure#getReturnType()
	 * @see #getProcedure()
	 * @generated
	 */
	EReference getProcedure_ReturnType();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.State <em>State</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see net.sf.orcc.ir.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.ir.State#getName <em>Name</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.orcc.ir.State#getName()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Name();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.Transitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transitions</em>'.
	 * @see net.sf.orcc.ir.Transitions
	 * @generated
	 */
	EClass getTransitions();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.orcc.ir.Transitions#getList <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>List</em>'.
	 * @see net.sf.orcc.ir.Transitions#getList()
	 * @see #getTransitions()
	 * @generated
	 */
	EReference getTransitions_List();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>State To Transitions Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State To Transitions Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="net.sf.orcc.ir.State"
	 *        valueType="net.sf.orcc.ir.Transitions"
	 * @generated
	 */
	EClass getStateToTransitionsMapEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStateToTransitionsMapEntry()
	 * @generated
	 */
	EReference getStateToTransitionsMapEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStateToTransitionsMapEntry()
	 * @generated
	 */
	EReference getStateToTransitionsMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.Tag <em>Tag</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag</em>'.
	 * @see net.sf.orcc.ir.Tag
	 * @generated
	 */
	EClass getTag();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link net.sf.orcc.ir.Tag#getIdentifiers <em>Identifiers</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Identifiers</em>'.
	 * @see net.sf.orcc.ir.Tag#getIdentifiers()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Identifiers();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see net.sf.orcc.ir.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.ir.Transition#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see net.sf.orcc.ir.Transition#getAction()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Action();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.ir.Transition#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State</em>'.
	 * @see net.sf.orcc.ir.Transition#getState()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_State();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.Type <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see net.sf.orcc.ir.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.TypeBool <em>Type Bool</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Bool</em>'.
	 * @see net.sf.orcc.ir.TypeBool
	 * @generated
	 */
	EClass getTypeBool();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.TypeFloat <em>Type Float</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Float</em>'.
	 * @see net.sf.orcc.ir.TypeFloat
	 * @generated
	 */
	EClass getTypeFloat();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.TypeInt <em>Type Int</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Int</em>'.
	 * @see net.sf.orcc.ir.TypeInt
	 * @generated
	 */
	EClass getTypeInt();

	/**
	 * Returns the meta object for the attribute '
	 * {@link net.sf.orcc.ir.TypeInt#getSize <em>Size</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see net.sf.orcc.ir.TypeInt#getSize()
	 * @see #getTypeInt()
	 * @generated
	 */
	EAttribute getTypeInt_Size();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.TypeList <em>Type List</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type List</em>'.
	 * @see net.sf.orcc.ir.TypeList
	 * @generated
	 */
	EClass getTypeList();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.TypeList#getSizeExpr <em>Size Expr</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Size Expr</em>
	 *         '.
	 * @see net.sf.orcc.ir.TypeList#getSizeExpr()
	 * @see #getTypeList()
	 * @generated
	 */
	EReference getTypeList_SizeExpr();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.TypeList#getType <em>Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see net.sf.orcc.ir.TypeList#getType()
	 * @see #getTypeList()
	 * @generated
	 */
	EReference getTypeList_Type();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.TypeString <em>Type String</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type String</em>'.
	 * @see net.sf.orcc.ir.TypeString
	 * @generated
	 */
	EClass getTypeString();

	/**
	 * Returns the meta object for the attribute '
	 * {@link net.sf.orcc.ir.TypeString#getSize <em>Size</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see net.sf.orcc.ir.TypeString#getSize()
	 * @see #getTypeString()
	 * @generated
	 */
	EAttribute getTypeString_Size();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.TypeUint <em>Type Uint</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Uint</em>'.
	 * @see net.sf.orcc.ir.TypeUint
	 * @generated
	 */
	EClass getTypeUint();

	/**
	 * Returns the meta object for the attribute '
	 * {@link net.sf.orcc.ir.TypeUint#getSize <em>Size</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see net.sf.orcc.ir.TypeUint#getSize()
	 * @see #getTypeUint()
	 * @generated
	 */
	EAttribute getTypeUint_Size();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.TypeVoid <em>Type Void</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Void</em>'.
	 * @see net.sf.orcc.ir.TypeVoid
	 * @generated
	 */
	EClass getTypeVoid();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.Use <em>Use</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use</em>'.
	 * @see net.sf.orcc.ir.Use
	 * @generated
	 */
	EClass getUse();

	/**
	 * Returns the meta object for the container reference '
	 * {@link net.sf.orcc.ir.Use#getVariable <em>Variable</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Variable</em>'.
	 * @see net.sf.orcc.ir.Use#getVariable()
	 * @see #getUse()
	 * @generated
	 */
	EReference getUse_Variable();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.ir.Var <em>Var</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var</em>'.
	 * @see net.sf.orcc.ir.Var
	 * @generated
	 */
	EClass getVar();

	/**
	 * Returns the meta object for the attribute '
	 * {@link net.sf.orcc.ir.Var#isAssignable <em>Assignable</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Assignable</em>'.
	 * @see net.sf.orcc.ir.Var#isAssignable()
	 * @see #getVar()
	 * @generated
	 */
	EAttribute getVar_Assignable();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.orcc.ir.Var#getDefs <em>Defs</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Defs</em>'.
	 * @see net.sf.orcc.ir.Var#getDefs()
	 * @see #getVar()
	 * @generated
	 */
	EReference getVar_Defs();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.ir.Var#isGlobal <em>Global</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Global</em>'.
	 * @see net.sf.orcc.ir.Var#isGlobal()
	 * @see #getVar()
	 * @generated
	 */
	EAttribute getVar_Global();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.ir.Var#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see net.sf.orcc.ir.Var#getIndex()
	 * @see #getVar()
	 * @generated
	 */
	EAttribute getVar_Index();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.Var#getInitialValue <em>Initial Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '
	 *         <em>Initial Value</em>'.
	 * @see net.sf.orcc.ir.Var#getInitialValue()
	 * @see #getVar()
	 * @generated
	 */
	EReference getVar_InitialValue();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link net.sf.orcc.ir.Var#getLocation <em>Location</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Location</em>
	 *         '.
	 * @see net.sf.orcc.ir.Var#getLocation()
	 * @see #getVar()
	 * @generated
	 */
	EReference getVar_Location();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.ir.Var#getName <em>Name</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.orcc.ir.Var#getName()
	 * @see #getVar()
	 * @generated
	 */
	EAttribute getVar_Name();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.orcc.ir.Var#getType <em>Type</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see net.sf.orcc.ir.Var#getType()
	 * @see #getVar()
	 * @generated
	 */
	EReference getVar_Type();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.orcc.ir.Var#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Uses</em>'.
	 * @see net.sf.orcc.ir.Var#getUses()
	 * @see #getVar()
	 * @generated
	 */
	EReference getVar_Uses();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.orcc.ir.Var#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see net.sf.orcc.ir.Var#getValue()
	 * @see #getVar()
	 * @generated
	 */
	EReference getVar_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Var To Port Map Entry</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for class '<em>Var To Port Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="net.sf.orcc.ir.Var"
	 *        valueType="net.sf.orcc.ir.Port"
	 * @generated
	 */
	EClass getVarToPortMapEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getVarToPortMapEntry()
	 * @generated
	 */
	EReference getVarToPortMapEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getVarToPortMapEntry()
	 * @generated
	 */
	EReference getVarToPortMapEntry_Value();

} // IrPackage
