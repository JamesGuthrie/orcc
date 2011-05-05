/*
 * Copyright (c) 2010-2011, IETR/INSA of Rennes
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
 *   * Neither the name of the IETR/INSA of Rennes nor the names of its
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
package net.sf.orcc.backends.instructions.impl;

import java.util.List;

import net.sf.orcc.backends.instructions.InstAssignIndex;
import net.sf.orcc.backends.instructions.InstCast;
import net.sf.orcc.backends.instructions.InstGetElementPtr;
import net.sf.orcc.backends.instructions.InstRamRead;
import net.sf.orcc.backends.instructions.InstRamSetAddress;
import net.sf.orcc.backends.instructions.InstRamWrite;
import net.sf.orcc.backends.instructions.InstSplit;
import net.sf.orcc.backends.instructions.InstTernary;
import net.sf.orcc.backends.instructions.InstructionsFactory;
import net.sf.orcc.backends.instructions.InstructionsPackage;
import net.sf.orcc.ir.Expression;
import net.sf.orcc.ir.IrFactory;
import net.sf.orcc.ir.Type;
import net.sf.orcc.ir.Var;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class InstructionsFactoryImpl extends EFactoryImpl implements
		InstructionsFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InstructionsPackage getPackage() {
		return InstructionsPackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static InstructionsFactory init() {
		try {
			InstructionsFactory theInstructionsFactory = (InstructionsFactory)EPackage.Registry.INSTANCE.getEFactory("http://orcc.sf.net/backends/instructions/Instructions"); 
			if (theInstructionsFactory != null) {
				return theInstructionsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InstructionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public InstructionsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case InstructionsPackage.INST_TERNARY: return createInstTernary();
			case InstructionsPackage.INST_ASSIGN_INDEX: return createInstAssignIndex();
			case InstructionsPackage.INST_SPLIT: return createInstSplit();
			case InstructionsPackage.INST_RAM_READ: return createInstRamRead();
			case InstructionsPackage.INST_RAM_SET_ADDRESS: return createInstRamSetAddress();
			case InstructionsPackage.INST_RAM_WRITE: return createInstRamWrite();
			case InstructionsPackage.INST_GET_ELEMENT_PTR: return createInstGetElementPtr();
			case InstructionsPackage.INST_CAST: return createInstCast();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InstAssignIndex createInstAssignIndex() {
		InstAssignIndexImpl instAssignIndex = new InstAssignIndexImpl();
		return instAssignIndex;
	}

	@Override
	public InstAssignIndex createInstAssignIndex(Var indexVar,
			List<Expression> indexes, Type type) {
		InstAssignIndexImpl instAssignIndex = new InstAssignIndexImpl();
		instAssignIndex.setTarget(IrFactory.eINSTANCE.createDef(indexVar));
		instAssignIndex.getIndexes().addAll(indexes);
		instAssignIndex.setListType(type);
		return instAssignIndex;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InstCast createInstCast() {
		InstCastImpl instCast = new InstCastImpl();
		return instCast;
	}

	@Override
	public InstCast createInstCast(Var source, Var target) {
		InstCastImpl instCast = new InstCastImpl();
		instCast.setSource(IrFactory.eINSTANCE.createUse(source));
		instCast.setTarget(IrFactory.eINSTANCE.createDef(target));
		return instCast;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InstGetElementPtr createInstGetElementPtr() {
		InstGetElementPtrImpl instGetElementPtr = new InstGetElementPtrImpl();
		return instGetElementPtr;
	}

	@Override
	public InstGetElementPtr createInstGetElementPtr(Var source, Var target,
			List<Expression> indexes) {
		InstGetElementPtrImpl instGetElementPtr = new InstGetElementPtrImpl();
		instGetElementPtr.setSource(IrFactory.eINSTANCE.createUse(source));
		instGetElementPtr.setTarget(IrFactory.eINSTANCE.createDef(source));
		instGetElementPtr.getIndexes().addAll(indexes);
		return instGetElementPtr;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InstRamRead createInstRamRead() {
		InstRamReadImpl instRamRead = new InstRamReadImpl();
		return instRamRead;
	}

	@Override
	public InstRamRead createInstRamRead(int port, Var variable, Var target) {
		InstRamReadImpl instRamRead = new InstRamReadImpl();
		instRamRead.setPort(port);
		instRamRead.setVariable(variable);
		instRamRead.setTarget(IrFactory.eINSTANCE.createDef(target));
		return instRamRead;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InstRamSetAddress createInstRamSetAddress() {
		InstRamSetAddressImpl instRamSetAddress = new InstRamSetAddressImpl();
		return instRamSetAddress;
	}

	@Override
	public InstRamSetAddress createInstRamSetAddress(int port, Var variable,
			List<Expression> indexes) {
		InstRamSetAddressImpl instRamSetAddress = new InstRamSetAddressImpl();
		instRamSetAddress.setPort(port);
		instRamSetAddress.setVariable(variable);
		instRamSetAddress.getIndexes().addAll(indexes);
		return instRamSetAddress;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InstRamWrite createInstRamWrite() {
		InstRamWriteImpl instRamWrite = new InstRamWriteImpl();
		return instRamWrite;
	}

	@Override
	public InstRamWrite createInstRamWrite(int port, Var variable,
			Expression value) {
		InstRamWriteImpl instRamWrite = new InstRamWriteImpl();
		instRamWrite.setPort(port);
		instRamWrite.setVariable(variable);
		instRamWrite.setValue(value);
		return instRamWrite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InstSplit createInstSplit() {
		InstSplitImpl instSplit = new InstSplitImpl();
		return instSplit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InstTernary createInstTernary() {
		InstTernaryImpl instTernary = new InstTernaryImpl();
		return instTernary;
	}

	@Override
	public InstTernary createInstTernary(Var target, Expression condition,
			Expression trueValue, Expression falseValue) {
		InstTernaryImpl instTernary = new InstTernaryImpl();
		instTernary.setTarget(IrFactory.eINSTANCE.createDef(target));
		instTernary.setConditionValue(condition);
		instTernary.setTrueValue(trueValue);
		instTernary.setFalseValue(falseValue);
		return instTernary;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InstructionsPackage getInstructionsPackage() {
		return (InstructionsPackage)getEPackage();
	}

} // InstructionsFactoryImpl
