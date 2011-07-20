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
package net.sf.orcc.backends.instructions.util;

import net.sf.orcc.backends.instructions.InstAssignIndex;
import net.sf.orcc.backends.instructions.InstCast;
import net.sf.orcc.backends.instructions.InstGetElementPtr;
import net.sf.orcc.backends.instructions.InstRam;
import net.sf.orcc.backends.instructions.InstRamRead;
import net.sf.orcc.backends.instructions.InstRamSetAddress;
import net.sf.orcc.backends.instructions.InstRamWrite;
import net.sf.orcc.backends.instructions.InstSplit;
import net.sf.orcc.backends.instructions.InstTernary;
import net.sf.orcc.backends.instructions.InstructionsPackage;
import net.sf.orcc.ir.InstSpecific;
import net.sf.orcc.ir.Instruction;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see net.sf.orcc.backends.instructions.InstructionsPackage
 * @generated
 */
public class InstructionsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static InstructionsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstructionsSwitch() {
		if (modelPackage == null) {
			modelPackage = InstructionsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case InstructionsPackage.INST_TERNARY: {
				InstTernary instTernary = (InstTernary)theEObject;
				T result = caseInstTernary(instTernary);
				if (result == null) result = caseInstSpecific(instTernary);
				if (result == null) result = caseInstruction(instTernary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InstructionsPackage.INST_ASSIGN_INDEX: {
				InstAssignIndex instAssignIndex = (InstAssignIndex)theEObject;
				T result = caseInstAssignIndex(instAssignIndex);
				if (result == null) result = caseInstSpecific(instAssignIndex);
				if (result == null) result = caseInstruction(instAssignIndex);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InstructionsPackage.INST_SPLIT: {
				InstSplit instSplit = (InstSplit)theEObject;
				T result = caseInstSplit(instSplit);
				if (result == null) result = caseInstSpecific(instSplit);
				if (result == null) result = caseInstruction(instSplit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InstructionsPackage.INST_RAM: {
				InstRam instRam = (InstRam)theEObject;
				T result = caseInstRam(instRam);
				if (result == null) result = caseInstSpecific(instRam);
				if (result == null) result = caseInstruction(instRam);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InstructionsPackage.INST_RAM_READ: {
				InstRamRead instRamRead = (InstRamRead)theEObject;
				T result = caseInstRamRead(instRamRead);
				if (result == null) result = caseInstRam(instRamRead);
				if (result == null) result = caseInstSpecific(instRamRead);
				if (result == null) result = caseInstruction(instRamRead);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InstructionsPackage.INST_RAM_SET_ADDRESS: {
				InstRamSetAddress instRamSetAddress = (InstRamSetAddress)theEObject;
				T result = caseInstRamSetAddress(instRamSetAddress);
				if (result == null) result = caseInstRam(instRamSetAddress);
				if (result == null) result = caseInstSpecific(instRamSetAddress);
				if (result == null) result = caseInstruction(instRamSetAddress);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InstructionsPackage.INST_RAM_WRITE: {
				InstRamWrite instRamWrite = (InstRamWrite)theEObject;
				T result = caseInstRamWrite(instRamWrite);
				if (result == null) result = caseInstRam(instRamWrite);
				if (result == null) result = caseInstSpecific(instRamWrite);
				if (result == null) result = caseInstruction(instRamWrite);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InstructionsPackage.INST_GET_ELEMENT_PTR: {
				InstGetElementPtr instGetElementPtr = (InstGetElementPtr)theEObject;
				T result = caseInstGetElementPtr(instGetElementPtr);
				if (result == null) result = caseInstSpecific(instGetElementPtr);
				if (result == null) result = caseInstruction(instGetElementPtr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InstructionsPackage.INST_CAST: {
				InstCast instCast = (InstCast)theEObject;
				T result = caseInstCast(instCast);
				if (result == null) result = caseInstSpecific(instCast);
				if (result == null) result = caseInstruction(instCast);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inst Ternary</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inst Ternary</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstTernary(InstTernary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inst Assign Index</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inst Assign Index</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstAssignIndex(InstAssignIndex object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inst Split</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inst Split</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstSplit(InstSplit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inst Ram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inst Ram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstRam(InstRam object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inst Ram Read</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inst Ram Read</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstRamRead(InstRamRead object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inst Ram Set Address</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inst Ram Set Address</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstRamSetAddress(InstRamSetAddress object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inst Ram Write</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inst Ram Write</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstRamWrite(InstRamWrite object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inst Get Element Ptr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inst Get Element Ptr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstGetElementPtr(InstGetElementPtr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inst Cast</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inst Cast</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstCast(InstCast object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstruction(Instruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inst Specific</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inst Specific</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstSpecific(InstSpecific object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //InstructionsSwitch
