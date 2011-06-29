/*
 * Copyright (c) 2011, IRISA
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *   * Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *   * Neither the name of IRISA nor the names of its
 *     contributors may be used to endorse or promote products derived from this
 *     software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */
package net.sf.orcc.backends.tta.architecture;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see net.sf.orcc.backends.tta.architecture.ArchitectureFactory
 * @model kind="package"
 * @generated
 */
public interface ArchitecturePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "architecture";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://orcc.sf.net/backends/tta/architecture/TTA_architecture";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "net.sf.orcc.backends.tta.architecture";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ArchitecturePackage eINSTANCE = net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl.init();

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.TTAImpl <em>TTA</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.TTAImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getTTA()
	 * @generated
	 */
	int TTA = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTA__NAME = 0;

	/**
	 * The feature id for the '<em><b>Gcu</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTA__GCU = 1;

	/**
	 * The feature id for the '<em><b>Buses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTA__BUSES = 2;

	/**
	 * The feature id for the '<em><b>Bridges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTA__BRIDGES = 3;

	/**
	 * The feature id for the '<em><b>Sockets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTA__SOCKETS = 4;

	/**
	 * The feature id for the '<em><b>Function Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTA__FUNCTION_UNITS = 5;

	/**
	 * The feature id for the '<em><b>Register Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTA__REGISTER_FILES = 6;

	/**
	 * The feature id for the '<em><b>Program</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTA__PROGRAM = 7;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTA__DATA = 8;

	/**
	 * The feature id for the '<em><b>Hardware Database</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTA__HARDWARE_DATABASE = 9;

	/**
	 * The number of structural features of the '<em>TTA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTA_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.BusImpl <em>Bus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.BusImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getBus()
	 * @generated
	 */
	int BUS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__WIDTH = 1;

	/**
	 * The feature id for the '<em><b>Guards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__GUARDS = 2;

	/**
	 * The feature id for the '<em><b>Segments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__SEGMENTS = 3;

	/**
	 * The feature id for the '<em><b>Short Immediate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__SHORT_IMMEDIATE = 4;

	/**
	 * The number of structural features of the '<em>Bus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.BridgeImpl <em>Bridge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.BridgeImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getBridge()
	 * @generated
	 */
	int BRIDGE = 2;

	/**
	 * The feature id for the '<em><b>Input Bus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE__INPUT_BUS = 0;

	/**
	 * The feature id for the '<em><b>Output Bus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE__OUTPUT_BUS = 1;

	/**
	 * The number of structural features of the '<em>Bridge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRIDGE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.SegmentImpl <em>Segment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.SegmentImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getSegment()
	 * @generated
	 */
	int SEGMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEGMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.GlobalControlUnitImpl <em>Global Control Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.GlobalControlUnitImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getGlobalControlUnit()
	 * @generated
	 */
	int GLOBAL_CONTROL_UNIT = 4;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONTROL_UNIT__PORTS = 0;

	/**
	 * The feature id for the '<em><b>Return Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONTROL_UNIT__RETURN_ADDRESS = 1;

	/**
	 * The feature id for the '<em><b>Address Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONTROL_UNIT__ADDRESS_SPACE = 2;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONTROL_UNIT__OPERATIONS = 3;

	/**
	 * The feature id for the '<em><b>Delay Slots</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONTROL_UNIT__DELAY_SLOTS = 4;

	/**
	 * The feature id for the '<em><b>Guard Latency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONTROL_UNIT__GUARD_LATENCY = 5;

	/**
	 * The number of structural features of the '<em>Global Control Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONTROL_UNIT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.FunctionUnitImpl <em>Function Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.FunctionUnitImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getFunctionUnit()
	 * @generated
	 */
	int FUNCTION_UNIT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_UNIT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_UNIT__OPERATIONS = 1;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_UNIT__PORTS = 2;

	/**
	 * The feature id for the '<em><b>Address Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_UNIT__ADDRESS_SPACE = 3;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_UNIT__IMPLEMENTATION = 4;

	/**
	 * The number of structural features of the '<em>Function Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_UNIT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.RegisterFileImpl <em>Register File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.RegisterFileImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getRegisterFile()
	 * @generated
	 */
	int REGISTER_FILE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER_FILE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER_FILE__SIZE = 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER_FILE__WIDTH = 2;

	/**
	 * The feature id for the '<em><b>Max Reads</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER_FILE__MAX_READS = 3;

	/**
	 * The feature id for the '<em><b>Max Writes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER_FILE__MAX_WRITES = 4;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER_FILE__PORTS = 5;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER_FILE__IMPLEMENTATION = 6;

	/**
	 * The number of structural features of the '<em>Register File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER_FILE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.PortImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getPort()
	 * @generated
	 */
	int PORT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Input Socket</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__INPUT_SOCKET = 1;

	/**
	 * The feature id for the '<em><b>Output Socket</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__OUTPUT_SOCKET = 2;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__WIDTH = 3;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__TRIGGER = 4;

	/**
	 * The feature id for the '<em><b>Opcode Selector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__OPCODE_SELECTOR = 5;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.SocketImpl <em>Socket</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.SocketImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getSocket()
	 * @generated
	 */
	int SOCKET = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCKET__NAME = 0;

	/**
	 * The feature id for the '<em><b>Connected Segments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCKET__CONNECTED_SEGMENTS = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCKET__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Socket</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCKET_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.OperationImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Pipeline</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PIPELINE = 1;

	/**
	 * The feature id for the '<em><b>Control</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__CONTROL = 2;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.AddressSpaceImpl <em>Address Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.AddressSpaceImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getAddressSpace()
	 * @generated
	 */
	int ADDRESS_SPACE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_SPACE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Min Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_SPACE__MIN_ADDRESS = 1;

	/**
	 * The feature id for the '<em><b>Max Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_SPACE__MAX_ADDRESS = 2;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_SPACE__WIDTH = 3;

	/**
	 * The number of structural features of the '<em>Address Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_SPACE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.Guard <em>Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.Guard
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getGuard()
	 * @generated
	 */
	int GUARD = 16;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.ExprUnaryImpl <em>Expr Unary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.ExprUnaryImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getExprUnary()
	 * @generated
	 */
	int EXPR_UNARY = 17;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.ExprBinaryImpl <em>Expr Binary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.ExprBinaryImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getExprBinary()
	 * @generated
	 */
	int EXPR_BINARY = 18;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.ExprTrueImpl <em>Expr True</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.ExprTrueImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getExprTrue()
	 * @generated
	 */
	int EXPR_TRUE = 19;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.ExprFalseImpl <em>Expr False</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.ExprFalseImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getExprFalse()
	 * @generated
	 */
	int EXPR_FALSE = 20;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.Term <em>Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.Term
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getTerm()
	 * @generated
	 */
	int TERM = 21;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.TermBoolImpl <em>Term Bool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.TermBoolImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getTermBool()
	 * @generated
	 */
	int TERM_BOOL = 22;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.TermUnitImpl <em>Term Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.TermUnitImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getTermUnit()
	 * @generated
	 */
	int TERM_UNIT = 23;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.Element <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.Element
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 11;

	/**
	 * The feature id for the '<em><b>Start Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__START_CYCLE = 0;

	/**
	 * The feature id for the '<em><b>Cycles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__CYCLES = 1;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.ReadsImpl <em>Reads</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.ReadsImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getReads()
	 * @generated
	 */
	int READS = 12;

	/**
	 * The feature id for the '<em><b>Start Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READS__START_CYCLE = ELEMENT__START_CYCLE;

	/**
	 * The feature id for the '<em><b>Cycles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READS__CYCLES = ELEMENT__CYCLES;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READS__PORT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reads</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READS_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.WritesImpl <em>Writes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.WritesImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getWrites()
	 * @generated
	 */
	int WRITES = 13;

	/**
	 * The feature id for the '<em><b>Start Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITES__START_CYCLE = ELEMENT__START_CYCLE;

	/**
	 * The feature id for the '<em><b>Cycles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITES__CYCLES = ELEMENT__CYCLES;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITES__PORT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Writes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITES_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.ResourceImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 14;

	/**
	 * The feature id for the '<em><b>Start Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__START_CYCLE = ELEMENT__START_CYCLE;

	/**
	 * The feature id for the '<em><b>Cycles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__CYCLES = ELEMENT__CYCLES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.PortToIndexMapEntryImpl <em>Port To Index Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.PortToIndexMapEntryImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getPortToIndexMapEntry()
	 * @generated
	 */
	int PORT_TO_INDEX_MAP_ENTRY = 25;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.ShortImmediateImpl <em>Short Immediate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.ShortImmediateImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getShortImmediate()
	 * @generated
	 */
	int SHORT_IMMEDIATE = 15;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_IMMEDIATE__EXTENSION = 0;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_IMMEDIATE__WIDTH = 1;

	/**
	 * The number of structural features of the '<em>Short Immediate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_IMMEDIATE_FEATURE_COUNT = 2;

	/**
	 * The number of structural features of the '<em>Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_UNARY__OPERATOR = GUARD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Term</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_UNARY__TERM = GUARD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Expr Unary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_UNARY_FEATURE_COUNT = GUARD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_BINARY__OPERATOR = GUARD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>E1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_BINARY__E1 = GUARD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>E2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_BINARY__E2 = GUARD_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Expr Binary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_BINARY_FEATURE_COUNT = GUARD_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Expr True</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_TRUE_FEATURE_COUNT = GUARD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expr False</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPR_FALSE_FEATURE_COUNT = GUARD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Register</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_BOOL__REGISTER = TERM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_BOOL__INDEX = TERM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Term Bool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_BOOL_FEATURE_COUNT = TERM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Function Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_UNIT__FUNCTION_UNIT = TERM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_UNIT__PORT = TERM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Term Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_UNIT_FEATURE_COUNT = TERM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.impl.ImplementationImpl <em>Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.impl.ImplementationImpl
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getImplementation()
	 * @generated
	 */
	int IMPLEMENTATION = 24;

	/**
	 * The feature id for the '<em><b>Hdb File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION__HDB_FILE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION__ID = 1;

	/**
	 * The number of structural features of the '<em>Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TO_INDEX_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TO_INDEX_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Port To Index Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_TO_INDEX_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.SocketType <em>Socket Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.SocketType
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getSocketType()
	 * @generated
	 */
	int SOCKET_TYPE = 26;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.Extension <em>Extension</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.Extension
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getExtension()
	 * @generated
	 */
	int EXTENSION = 27;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.OpUnary <em>Op Unary</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.OpUnary
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getOpUnary()
	 * @generated
	 */
	int OP_UNARY = 28;

	/**
	 * The meta object id for the '{@link net.sf.orcc.backends.tta.architecture.OpBinary <em>Op Binary</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.sf.orcc.backends.tta.architecture.OpBinary
	 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getOpBinary()
	 * @generated
	 */
	int OP_BINARY = 29;

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.TTA <em>TTA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TTA</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.TTA
	 * @generated
	 */
	EClass getTTA();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.TTA#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.TTA#getName()
	 * @see #getTTA()
	 * @generated
	 */
	EAttribute getTTA_Name();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.orcc.backends.tta.architecture.TTA#getGcu <em>Gcu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Gcu</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.TTA#getGcu()
	 * @see #getTTA()
	 * @generated
	 */
	EReference getTTA_Gcu();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.orcc.backends.tta.architecture.TTA#getBuses <em>Buses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Buses</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.TTA#getBuses()
	 * @see #getTTA()
	 * @generated
	 */
	EReference getTTA_Buses();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.orcc.backends.tta.architecture.TTA#getBridges <em>Bridges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bridges</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.TTA#getBridges()
	 * @see #getTTA()
	 * @generated
	 */
	EReference getTTA_Bridges();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.orcc.backends.tta.architecture.TTA#getSockets <em>Sockets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sockets</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.TTA#getSockets()
	 * @see #getTTA()
	 * @generated
	 */
	EReference getTTA_Sockets();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.orcc.backends.tta.architecture.TTA#getFunctionUnits <em>Function Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Function Units</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.TTA#getFunctionUnits()
	 * @see #getTTA()
	 * @generated
	 */
	EReference getTTA_FunctionUnits();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.orcc.backends.tta.architecture.TTA#getRegisterFiles <em>Register Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Register Files</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.TTA#getRegisterFiles()
	 * @see #getTTA()
	 * @generated
	 */
	EReference getTTA_RegisterFiles();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.orcc.backends.tta.architecture.TTA#getProgram <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Program</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.TTA#getProgram()
	 * @see #getTTA()
	 * @generated
	 */
	EReference getTTA_Program();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.orcc.backends.tta.architecture.TTA#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.TTA#getData()
	 * @see #getTTA()
	 * @generated
	 */
	EReference getTTA_Data();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.orcc.backends.tta.architecture.TTA#getHardwareDatabase <em>Hardware Database</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Hardware Database</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.TTA#getHardwareDatabase()
	 * @see #getTTA()
	 * @generated
	 */
	EReference getTTA_HardwareDatabase();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.Bus <em>Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bus</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Bus
	 * @generated
	 */
	EClass getBus();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.Bus#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Bus#getName()
	 * @see #getBus()
	 * @generated
	 */
	EAttribute getBus_Name();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.Bus#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Bus#getWidth()
	 * @see #getBus()
	 * @generated
	 */
	EAttribute getBus_Width();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.orcc.backends.tta.architecture.Bus#getGuards <em>Guards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Guards</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Bus#getGuards()
	 * @see #getBus()
	 * @generated
	 */
	EReference getBus_Guards();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.orcc.backends.tta.architecture.Bus#getSegments <em>Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Segments</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Bus#getSegments()
	 * @see #getBus()
	 * @generated
	 */
	EReference getBus_Segments();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.orcc.backends.tta.architecture.Bus#getShortImmediate <em>Short Immediate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Short Immediate</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Bus#getShortImmediate()
	 * @see #getBus()
	 * @generated
	 */
	EReference getBus_ShortImmediate();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.Bridge <em>Bridge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bridge</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Bridge
	 * @generated
	 */
	EClass getBridge();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.backends.tta.architecture.Bridge#getInputBus <em>Input Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input Bus</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Bridge#getInputBus()
	 * @see #getBridge()
	 * @generated
	 */
	EReference getBridge_InputBus();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.backends.tta.architecture.Bridge#getOutputBus <em>Output Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output Bus</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Bridge#getOutputBus()
	 * @see #getBridge()
	 * @generated
	 */
	EReference getBridge_OutputBus();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.Segment <em>Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Segment</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Segment
	 * @generated
	 */
	EClass getSegment();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.Segment#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Segment#getName()
	 * @see #getSegment()
	 * @generated
	 */
	EAttribute getSegment_Name();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.GlobalControlUnit <em>Global Control Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Control Unit</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.GlobalControlUnit
	 * @generated
	 */
	EClass getGlobalControlUnit();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.orcc.backends.tta.architecture.GlobalControlUnit#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.GlobalControlUnit#getPorts()
	 * @see #getGlobalControlUnit()
	 * @generated
	 */
	EReference getGlobalControlUnit_Ports();

	/**
	 * Returns the meta object for the containment reference '{@link net.sf.orcc.backends.tta.architecture.GlobalControlUnit#getReturnAddress <em>Return Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Address</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.GlobalControlUnit#getReturnAddress()
	 * @see #getGlobalControlUnit()
	 * @generated
	 */
	EReference getGlobalControlUnit_ReturnAddress();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.backends.tta.architecture.GlobalControlUnit#getAddressSpace <em>Address Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Address Space</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.GlobalControlUnit#getAddressSpace()
	 * @see #getGlobalControlUnit()
	 * @generated
	 */
	EReference getGlobalControlUnit_AddressSpace();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.orcc.backends.tta.architecture.GlobalControlUnit#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.GlobalControlUnit#getOperations()
	 * @see #getGlobalControlUnit()
	 * @generated
	 */
	EReference getGlobalControlUnit_Operations();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.GlobalControlUnit#getDelaySlots <em>Delay Slots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay Slots</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.GlobalControlUnit#getDelaySlots()
	 * @see #getGlobalControlUnit()
	 * @generated
	 */
	EAttribute getGlobalControlUnit_DelaySlots();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.GlobalControlUnit#getGuardLatency <em>Guard Latency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guard Latency</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.GlobalControlUnit#getGuardLatency()
	 * @see #getGlobalControlUnit()
	 * @generated
	 */
	EAttribute getGlobalControlUnit_GuardLatency();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.FunctionUnit <em>Function Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Unit</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.FunctionUnit
	 * @generated
	 */
	EClass getFunctionUnit();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.FunctionUnit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.FunctionUnit#getName()
	 * @see #getFunctionUnit()
	 * @generated
	 */
	EAttribute getFunctionUnit_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.orcc.backends.tta.architecture.FunctionUnit#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.FunctionUnit#getOperations()
	 * @see #getFunctionUnit()
	 * @generated
	 */
	EReference getFunctionUnit_Operations();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.orcc.backends.tta.architecture.FunctionUnit#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.FunctionUnit#getPorts()
	 * @see #getFunctionUnit()
	 * @generated
	 */
	EReference getFunctionUnit_Ports();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.backends.tta.architecture.FunctionUnit#getAddressSpace <em>Address Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Address Space</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.FunctionUnit#getAddressSpace()
	 * @see #getFunctionUnit()
	 * @generated
	 */
	EReference getFunctionUnit_AddressSpace();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.backends.tta.architecture.FunctionUnit#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.FunctionUnit#getImplementation()
	 * @see #getFunctionUnit()
	 * @generated
	 */
	EReference getFunctionUnit_Implementation();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.RegisterFile <em>Register File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Register File</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.RegisterFile
	 * @generated
	 */
	EClass getRegisterFile();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.RegisterFile#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.RegisterFile#getName()
	 * @see #getRegisterFile()
	 * @generated
	 */
	EAttribute getRegisterFile_Name();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.RegisterFile#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.RegisterFile#getSize()
	 * @see #getRegisterFile()
	 * @generated
	 */
	EAttribute getRegisterFile_Size();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.RegisterFile#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.RegisterFile#getWidth()
	 * @see #getRegisterFile()
	 * @generated
	 */
	EAttribute getRegisterFile_Width();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.RegisterFile#getMaxReads <em>Max Reads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Reads</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.RegisterFile#getMaxReads()
	 * @see #getRegisterFile()
	 * @generated
	 */
	EAttribute getRegisterFile_MaxReads();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.RegisterFile#getMaxWrites <em>Max Writes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Writes</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.RegisterFile#getMaxWrites()
	 * @see #getRegisterFile()
	 * @generated
	 */
	EAttribute getRegisterFile_MaxWrites();

	/**
	 * Returns the meta object for the containment reference list '{@link net.sf.orcc.backends.tta.architecture.RegisterFile#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.RegisterFile#getPorts()
	 * @see #getRegisterFile()
	 * @generated
	 */
	EReference getRegisterFile_Ports();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.backends.tta.architecture.RegisterFile#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.RegisterFile#getImplementation()
	 * @see #getRegisterFile()
	 * @generated
	 */
	EReference getRegisterFile_Implementation();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.Port#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Port#getName()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Name();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.backends.tta.architecture.Port#getInputSocket <em>Input Socket</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input Socket</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Port#getInputSocket()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_InputSocket();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.backends.tta.architecture.Port#getOutputSocket <em>Output Socket</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output Socket</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Port#getOutputSocket()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_OutputSocket();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.Port#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Port#getWidth()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Width();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.Port#isTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trigger</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Port#isTrigger()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Trigger();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.Port#isOpcodeSelector <em>Opcode Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Opcode Selector</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Port#isOpcodeSelector()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_OpcodeSelector();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.Socket <em>Socket</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Socket</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Socket
	 * @generated
	 */
	EClass getSocket();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.Socket#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Socket#getName()
	 * @see #getSocket()
	 * @generated
	 */
	EAttribute getSocket_Name();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.orcc.backends.tta.architecture.Socket#getConnectedSegments <em>Connected Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connected Segments</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Socket#getConnectedSegments()
	 * @see #getSocket()
	 * @generated
	 */
	EReference getSocket_ConnectedSegments();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.Socket#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Socket#getType()
	 * @see #getSocket()
	 * @generated
	 */
	EAttribute getSocket_Type();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.Operation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Operation#getName()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Name();

	/**
	 * Returns the meta object for the reference list '{@link net.sf.orcc.backends.tta.architecture.Operation#getPipeline <em>Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Pipeline</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Operation#getPipeline()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Pipeline();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.Operation#isControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Control</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Operation#isControl()
	 * @see #getOperation()
	 * @generated
	 */
	EAttribute getOperation_Control();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.AddressSpace <em>Address Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address Space</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.AddressSpace
	 * @generated
	 */
	EClass getAddressSpace();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.AddressSpace#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.AddressSpace#getName()
	 * @see #getAddressSpace()
	 * @generated
	 */
	EAttribute getAddressSpace_Name();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.AddressSpace#getMinAddress <em>Min Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Address</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.AddressSpace#getMinAddress()
	 * @see #getAddressSpace()
	 * @generated
	 */
	EAttribute getAddressSpace_MinAddress();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.AddressSpace#getMaxAddress <em>Max Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Address</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.AddressSpace#getMaxAddress()
	 * @see #getAddressSpace()
	 * @generated
	 */
	EAttribute getAddressSpace_MaxAddress();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.AddressSpace#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.AddressSpace#getWidth()
	 * @see #getAddressSpace()
	 * @generated
	 */
	EAttribute getAddressSpace_Width();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.Guard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Guard
	 * @generated
	 */
	EClass getGuard();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.ExprUnary <em>Expr Unary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expr Unary</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.ExprUnary
	 * @generated
	 */
	EClass getExprUnary();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.ExprUnary#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.ExprUnary#getOperator()
	 * @see #getExprUnary()
	 * @generated
	 */
	EAttribute getExprUnary_Operator();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.backends.tta.architecture.ExprUnary#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Term</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.ExprUnary#getTerm()
	 * @see #getExprUnary()
	 * @generated
	 */
	EReference getExprUnary_Term();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.ExprBinary <em>Expr Binary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expr Binary</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.ExprBinary
	 * @generated
	 */
	EClass getExprBinary();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.ExprBinary#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.ExprBinary#getOperator()
	 * @see #getExprBinary()
	 * @generated
	 */
	EAttribute getExprBinary_Operator();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.backends.tta.architecture.ExprBinary#getE1 <em>E1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>E1</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.ExprBinary#getE1()
	 * @see #getExprBinary()
	 * @generated
	 */
	EReference getExprBinary_E1();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.backends.tta.architecture.ExprBinary#getE2 <em>E2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>E2</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.ExprBinary#getE2()
	 * @see #getExprBinary()
	 * @generated
	 */
	EReference getExprBinary_E2();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.ExprTrue <em>Expr True</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expr True</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.ExprTrue
	 * @generated
	 */
	EClass getExprTrue();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.ExprFalse <em>Expr False</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expr False</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.ExprFalse
	 * @generated
	 */
	EClass getExprFalse();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Term
	 * @generated
	 */
	EClass getTerm();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.TermBool <em>Term Bool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term Bool</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.TermBool
	 * @generated
	 */
	EClass getTermBool();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.backends.tta.architecture.TermBool#getRegister <em>Register</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Register</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.TermBool#getRegister()
	 * @see #getTermBool()
	 * @generated
	 */
	EReference getTermBool_Register();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.TermBool#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.TermBool#getIndex()
	 * @see #getTermBool()
	 * @generated
	 */
	EAttribute getTermBool_Index();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.TermUnit <em>Term Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term Unit</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.TermUnit
	 * @generated
	 */
	EClass getTermUnit();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.backends.tta.architecture.TermUnit#getFunctionUnit <em>Function Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function Unit</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.TermUnit#getFunctionUnit()
	 * @see #getTermUnit()
	 * @generated
	 */
	EReference getTermUnit_FunctionUnit();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.backends.tta.architecture.TermUnit#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.TermUnit#getPort()
	 * @see #getTermUnit()
	 * @generated
	 */
	EReference getTermUnit_Port();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.Implementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implementation</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Implementation
	 * @generated
	 */
	EClass getImplementation();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.Implementation#getHdbFile <em>Hdb File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hdb File</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Implementation#getHdbFile()
	 * @see #getImplementation()
	 * @generated
	 */
	EAttribute getImplementation_HdbFile();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.Implementation#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Implementation#getId()
	 * @see #getImplementation()
	 * @generated
	 */
	EAttribute getImplementation_Id();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Port To Index Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port To Index Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="net.sf.orcc.backends.tta.architecture.Port"
	 *        valueDataType="org.eclipse.emf.ecore.EIntegerObject"
	 * @generated
	 */
	EClass getPortToIndexMapEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPortToIndexMapEntry()
	 * @generated
	 */
	EReference getPortToIndexMapEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPortToIndexMapEntry()
	 * @generated
	 */
	EAttribute getPortToIndexMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.Element#getStartCycle <em>Start Cycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Cycle</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Element#getStartCycle()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_StartCycle();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.Element#getCycles <em>Cycles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cycles</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Element#getCycles()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Cycles();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.Reads <em>Reads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reads</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Reads
	 * @generated
	 */
	EClass getReads();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.backends.tta.architecture.Reads#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Reads#getPort()
	 * @see #getReads()
	 * @generated
	 */
	EReference getReads_Port();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.Writes <em>Writes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Writes</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Writes
	 * @generated
	 */
	EClass getWrites();

	/**
	 * Returns the meta object for the reference '{@link net.sf.orcc.backends.tta.architecture.Writes#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Writes#getPort()
	 * @see #getWrites()
	 * @generated
	 */
	EReference getWrites_Port();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.Resource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Resource#getName()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Name();

	/**
	 * Returns the meta object for class '{@link net.sf.orcc.backends.tta.architecture.ShortImmediate <em>Short Immediate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Short Immediate</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.ShortImmediate
	 * @generated
	 */
	EClass getShortImmediate();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.ShortImmediate#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.ShortImmediate#getExtension()
	 * @see #getShortImmediate()
	 * @generated
	 */
	EAttribute getShortImmediate_Extension();

	/**
	 * Returns the meta object for the attribute '{@link net.sf.orcc.backends.tta.architecture.ShortImmediate#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.ShortImmediate#getWidth()
	 * @see #getShortImmediate()
	 * @generated
	 */
	EAttribute getShortImmediate_Width();

	/**
	 * Returns the meta object for enum '{@link net.sf.orcc.backends.tta.architecture.SocketType <em>Socket Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Socket Type</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.SocketType
	 * @generated
	 */
	EEnum getSocketType();

	/**
	 * Returns the meta object for enum '{@link net.sf.orcc.backends.tta.architecture.Extension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Extension</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.Extension
	 * @generated
	 */
	EEnum getExtension();

	/**
	 * Returns the meta object for enum '{@link net.sf.orcc.backends.tta.architecture.OpUnary <em>Op Unary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Op Unary</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.OpUnary
	 * @generated
	 */
	EEnum getOpUnary();

	/**
	 * Returns the meta object for enum '{@link net.sf.orcc.backends.tta.architecture.OpBinary <em>Op Binary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Op Binary</em>'.
	 * @see net.sf.orcc.backends.tta.architecture.OpBinary
	 * @generated
	 */
	EEnum getOpBinary();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ArchitectureFactory getArchitectureFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.TTAImpl <em>TTA</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.TTAImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getTTA()
		 * @generated
		 */
		EClass TTA = eINSTANCE.getTTA();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTA__NAME = eINSTANCE.getTTA_Name();

		/**
		 * The meta object literal for the '<em><b>Gcu</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTA__GCU = eINSTANCE.getTTA_Gcu();

		/**
		 * The meta object literal for the '<em><b>Buses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTA__BUSES = eINSTANCE.getTTA_Buses();

		/**
		 * The meta object literal for the '<em><b>Bridges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTA__BRIDGES = eINSTANCE.getTTA_Bridges();

		/**
		 * The meta object literal for the '<em><b>Sockets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTA__SOCKETS = eINSTANCE.getTTA_Sockets();

		/**
		 * The meta object literal for the '<em><b>Function Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTA__FUNCTION_UNITS = eINSTANCE.getTTA_FunctionUnits();

		/**
		 * The meta object literal for the '<em><b>Register Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTA__REGISTER_FILES = eINSTANCE.getTTA_RegisterFiles();

		/**
		 * The meta object literal for the '<em><b>Program</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTA__PROGRAM = eINSTANCE.getTTA_Program();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTA__DATA = eINSTANCE.getTTA_Data();

		/**
		 * The meta object literal for the '<em><b>Hardware Database</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTA__HARDWARE_DATABASE = eINSTANCE.getTTA_HardwareDatabase();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.BusImpl <em>Bus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.BusImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getBus()
		 * @generated
		 */
		EClass BUS = eINSTANCE.getBus();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUS__NAME = eINSTANCE.getBus_Name();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUS__WIDTH = eINSTANCE.getBus_Width();

		/**
		 * The meta object literal for the '<em><b>Guards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS__GUARDS = eINSTANCE.getBus_Guards();

		/**
		 * The meta object literal for the '<em><b>Segments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS__SEGMENTS = eINSTANCE.getBus_Segments();

		/**
		 * The meta object literal for the '<em><b>Short Immediate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS__SHORT_IMMEDIATE = eINSTANCE.getBus_ShortImmediate();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.BridgeImpl <em>Bridge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.BridgeImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getBridge()
		 * @generated
		 */
		EClass BRIDGE = eINSTANCE.getBridge();

		/**
		 * The meta object literal for the '<em><b>Input Bus</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRIDGE__INPUT_BUS = eINSTANCE.getBridge_InputBus();

		/**
		 * The meta object literal for the '<em><b>Output Bus</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRIDGE__OUTPUT_BUS = eINSTANCE.getBridge_OutputBus();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.SegmentImpl <em>Segment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.SegmentImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getSegment()
		 * @generated
		 */
		EClass SEGMENT = eINSTANCE.getSegment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEGMENT__NAME = eINSTANCE.getSegment_Name();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.GlobalControlUnitImpl <em>Global Control Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.GlobalControlUnitImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getGlobalControlUnit()
		 * @generated
		 */
		EClass GLOBAL_CONTROL_UNIT = eINSTANCE.getGlobalControlUnit();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GLOBAL_CONTROL_UNIT__PORTS = eINSTANCE.getGlobalControlUnit_Ports();

		/**
		 * The meta object literal for the '<em><b>Return Address</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GLOBAL_CONTROL_UNIT__RETURN_ADDRESS = eINSTANCE.getGlobalControlUnit_ReturnAddress();

		/**
		 * The meta object literal for the '<em><b>Address Space</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GLOBAL_CONTROL_UNIT__ADDRESS_SPACE = eINSTANCE.getGlobalControlUnit_AddressSpace();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GLOBAL_CONTROL_UNIT__OPERATIONS = eINSTANCE.getGlobalControlUnit_Operations();

		/**
		 * The meta object literal for the '<em><b>Delay Slots</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GLOBAL_CONTROL_UNIT__DELAY_SLOTS = eINSTANCE.getGlobalControlUnit_DelaySlots();

		/**
		 * The meta object literal for the '<em><b>Guard Latency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GLOBAL_CONTROL_UNIT__GUARD_LATENCY = eINSTANCE.getGlobalControlUnit_GuardLatency();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.FunctionUnitImpl <em>Function Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.FunctionUnitImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getFunctionUnit()
		 * @generated
		 */
		EClass FUNCTION_UNIT = eINSTANCE.getFunctionUnit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_UNIT__NAME = eINSTANCE.getFunctionUnit_Name();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_UNIT__OPERATIONS = eINSTANCE.getFunctionUnit_Operations();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_UNIT__PORTS = eINSTANCE.getFunctionUnit_Ports();

		/**
		 * The meta object literal for the '<em><b>Address Space</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_UNIT__ADDRESS_SPACE = eINSTANCE.getFunctionUnit_AddressSpace();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_UNIT__IMPLEMENTATION = eINSTANCE.getFunctionUnit_Implementation();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.RegisterFileImpl <em>Register File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.RegisterFileImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getRegisterFile()
		 * @generated
		 */
		EClass REGISTER_FILE = eINSTANCE.getRegisterFile();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTER_FILE__NAME = eINSTANCE.getRegisterFile_Name();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTER_FILE__SIZE = eINSTANCE.getRegisterFile_Size();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTER_FILE__WIDTH = eINSTANCE.getRegisterFile_Width();

		/**
		 * The meta object literal for the '<em><b>Max Reads</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTER_FILE__MAX_READS = eINSTANCE.getRegisterFile_MaxReads();

		/**
		 * The meta object literal for the '<em><b>Max Writes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGISTER_FILE__MAX_WRITES = eINSTANCE.getRegisterFile_MaxWrites();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTER_FILE__PORTS = eINSTANCE.getRegisterFile_Ports();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTER_FILE__IMPLEMENTATION = eINSTANCE.getRegisterFile_Implementation();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.PortImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__NAME = eINSTANCE.getPort_Name();

		/**
		 * The meta object literal for the '<em><b>Input Socket</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__INPUT_SOCKET = eINSTANCE.getPort_InputSocket();

		/**
		 * The meta object literal for the '<em><b>Output Socket</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__OUTPUT_SOCKET = eINSTANCE.getPort_OutputSocket();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__WIDTH = eINSTANCE.getPort_Width();

		/**
		 * The meta object literal for the '<em><b>Trigger</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__TRIGGER = eINSTANCE.getPort_Trigger();

		/**
		 * The meta object literal for the '<em><b>Opcode Selector</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__OPCODE_SELECTOR = eINSTANCE.getPort_OpcodeSelector();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.SocketImpl <em>Socket</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.SocketImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getSocket()
		 * @generated
		 */
		EClass SOCKET = eINSTANCE.getSocket();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOCKET__NAME = eINSTANCE.getSocket_Name();

		/**
		 * The meta object literal for the '<em><b>Connected Segments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOCKET__CONNECTED_SEGMENTS = eINSTANCE.getSocket_ConnectedSegments();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOCKET__TYPE = eINSTANCE.getSocket_Type();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.OperationImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__NAME = eINSTANCE.getOperation_Name();

		/**
		 * The meta object literal for the '<em><b>Pipeline</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__PIPELINE = eINSTANCE.getOperation_Pipeline();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION__CONTROL = eINSTANCE.getOperation_Control();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.AddressSpaceImpl <em>Address Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.AddressSpaceImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getAddressSpace()
		 * @generated
		 */
		EClass ADDRESS_SPACE = eINSTANCE.getAddressSpace();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESS_SPACE__NAME = eINSTANCE.getAddressSpace_Name();

		/**
		 * The meta object literal for the '<em><b>Min Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESS_SPACE__MIN_ADDRESS = eINSTANCE.getAddressSpace_MinAddress();

		/**
		 * The meta object literal for the '<em><b>Max Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESS_SPACE__MAX_ADDRESS = eINSTANCE.getAddressSpace_MaxAddress();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDRESS_SPACE__WIDTH = eINSTANCE.getAddressSpace_Width();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.Guard <em>Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.Guard
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getGuard()
		 * @generated
		 */
		EClass GUARD = eINSTANCE.getGuard();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.ExprUnaryImpl <em>Expr Unary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.ExprUnaryImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getExprUnary()
		 * @generated
		 */
		EClass EXPR_UNARY = eINSTANCE.getExprUnary();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPR_UNARY__OPERATOR = eINSTANCE.getExprUnary_Operator();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPR_UNARY__TERM = eINSTANCE.getExprUnary_Term();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.ExprBinaryImpl <em>Expr Binary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.ExprBinaryImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getExprBinary()
		 * @generated
		 */
		EClass EXPR_BINARY = eINSTANCE.getExprBinary();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPR_BINARY__OPERATOR = eINSTANCE.getExprBinary_Operator();

		/**
		 * The meta object literal for the '<em><b>E1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPR_BINARY__E1 = eINSTANCE.getExprBinary_E1();

		/**
		 * The meta object literal for the '<em><b>E2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPR_BINARY__E2 = eINSTANCE.getExprBinary_E2();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.ExprTrueImpl <em>Expr True</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.ExprTrueImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getExprTrue()
		 * @generated
		 */
		EClass EXPR_TRUE = eINSTANCE.getExprTrue();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.ExprFalseImpl <em>Expr False</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.ExprFalseImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getExprFalse()
		 * @generated
		 */
		EClass EXPR_FALSE = eINSTANCE.getExprFalse();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.Term <em>Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.Term
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getTerm()
		 * @generated
		 */
		EClass TERM = eINSTANCE.getTerm();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.TermBoolImpl <em>Term Bool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.TermBoolImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getTermBool()
		 * @generated
		 */
		EClass TERM_BOOL = eINSTANCE.getTermBool();

		/**
		 * The meta object literal for the '<em><b>Register</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERM_BOOL__REGISTER = eINSTANCE.getTermBool_Register();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERM_BOOL__INDEX = eINSTANCE.getTermBool_Index();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.TermUnitImpl <em>Term Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.TermUnitImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getTermUnit()
		 * @generated
		 */
		EClass TERM_UNIT = eINSTANCE.getTermUnit();

		/**
		 * The meta object literal for the '<em><b>Function Unit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERM_UNIT__FUNCTION_UNIT = eINSTANCE.getTermUnit_FunctionUnit();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERM_UNIT__PORT = eINSTANCE.getTermUnit_Port();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.ImplementationImpl <em>Implementation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.ImplementationImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getImplementation()
		 * @generated
		 */
		EClass IMPLEMENTATION = eINSTANCE.getImplementation();

		/**
		 * The meta object literal for the '<em><b>Hdb File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPLEMENTATION__HDB_FILE = eINSTANCE.getImplementation_HdbFile();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPLEMENTATION__ID = eINSTANCE.getImplementation_Id();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.Element <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.Element
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Start Cycle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__START_CYCLE = eINSTANCE.getElement_StartCycle();

		/**
		 * The meta object literal for the '<em><b>Cycles</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__CYCLES = eINSTANCE.getElement_Cycles();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.ReadsImpl <em>Reads</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.ReadsImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getReads()
		 * @generated
		 */
		EClass READS = eINSTANCE.getReads();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference READS__PORT = eINSTANCE.getReads_Port();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.WritesImpl <em>Writes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.WritesImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getWrites()
		 * @generated
		 */
		EClass WRITES = eINSTANCE.getWrites();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WRITES__PORT = eINSTANCE.getWrites_Port();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.ResourceImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__NAME = eINSTANCE.getResource_Name();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.PortToIndexMapEntryImpl <em>Port To Index Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.PortToIndexMapEntryImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getPortToIndexMapEntry()
		 * @generated
		 */
		EClass PORT_TO_INDEX_MAP_ENTRY = eINSTANCE.getPortToIndexMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_TO_INDEX_MAP_ENTRY__KEY = eINSTANCE.getPortToIndexMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_TO_INDEX_MAP_ENTRY__VALUE = eINSTANCE.getPortToIndexMapEntry_Value();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.impl.ShortImmediateImpl <em>Short Immediate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.impl.ShortImmediateImpl
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getShortImmediate()
		 * @generated
		 */
		EClass SHORT_IMMEDIATE = eINSTANCE.getShortImmediate();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHORT_IMMEDIATE__EXTENSION = eINSTANCE.getShortImmediate_Extension();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHORT_IMMEDIATE__WIDTH = eINSTANCE.getShortImmediate_Width();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.SocketType <em>Socket Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.SocketType
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getSocketType()
		 * @generated
		 */
		EEnum SOCKET_TYPE = eINSTANCE.getSocketType();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.Extension <em>Extension</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.Extension
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getExtension()
		 * @generated
		 */
		EEnum EXTENSION = eINSTANCE.getExtension();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.OpUnary <em>Op Unary</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.OpUnary
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getOpUnary()
		 * @generated
		 */
		EEnum OP_UNARY = eINSTANCE.getOpUnary();

		/**
		 * The meta object literal for the '{@link net.sf.orcc.backends.tta.architecture.OpBinary <em>Op Binary</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.sf.orcc.backends.tta.architecture.OpBinary
		 * @see net.sf.orcc.backends.tta.architecture.impl.ArchitecturePackageImpl#getOpBinary()
		 * @generated
		 */
		EEnum OP_BINARY = eINSTANCE.getOpBinary();

	}

} //ArchitecturePackage
