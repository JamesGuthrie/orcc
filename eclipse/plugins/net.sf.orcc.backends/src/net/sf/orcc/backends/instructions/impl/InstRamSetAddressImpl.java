/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.orcc.backends.instructions.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sf.orcc.backends.instructions.InstRamSetAddress;
import net.sf.orcc.backends.instructions.InstructionsPackage;

import net.sf.orcc.ir.Expression;
import net.sf.orcc.ir.impl.ExprIntImpl;
import net.sf.orcc.ir.util.ExpressionPrinter;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Inst Ram Set Address</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link net.sf.orcc.backends.instructions.impl.InstRamSetAddressImpl#getIndexes
 * <em>Indexes</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class InstRamSetAddressImpl extends InstRamImpl implements
		InstRamSetAddress {
	/**
	 * The cached value of the '{@link #getIndexes() <em>Indexes</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getIndexes()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> indexes;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected InstRamSetAddressImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case InstructionsPackage.INST_RAM_SET_ADDRESS__INDEXES:
			return getIndexes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case InstructionsPackage.INST_RAM_SET_ADDRESS__INDEXES:
			return ((InternalEList<?>) getIndexes())
					.basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case InstructionsPackage.INST_RAM_SET_ADDRESS__INDEXES:
			return indexes != null && !indexes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case InstructionsPackage.INST_RAM_SET_ADDRESS__INDEXES:
			getIndexes().clear();
			getIndexes().addAll((Collection<? extends Expression>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstructionsPackage.Literals.INST_RAM_SET_ADDRESS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case InstructionsPackage.INST_RAM_SET_ADDRESS__INDEXES:
			getIndexes().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Expression> getIndexes() {
		if (indexes == null) {
			indexes = new EObjectContainmentEList<Expression>(Expression.class,
					this, InstructionsPackage.INST_RAM_SET_ADDRESS__INDEXES);
		}
		return indexes;
	}

	/**
	 * Returns a list containing the sizes of the indexes.
	 * 
	 * @return a list containing the sizes of the indexes
	 */
	public List<Integer> getIndexesSizes() {
		List<Integer> dimensions = getVariable().getType().getDimensions();
		List<Integer> indexSizes = new ArrayList<Integer>(dimensions.size());
		for (int size : dimensions) {
			// index goes from 0 to size - 1, and we remove the sign bit
			int indexSize = ExprIntImpl.getSize(size - 1) - 1;
			indexSizes.add(indexSize);
		}

		return indexSizes;
	}

	/**
	 * Returns <code>true</code>. Intended for use in template.
	 * 
	 * @return <code>true</code>
	 */
	public boolean isRamSetAddress() {
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("RamSetAddress(").append(getVariable().getName())
				.append("_address_p").append(getPort());
		for (Expression index : indexes) {
			builder.append("[");
			builder.append(new ExpressionPrinter().doSwitch(index));
			builder.append("]");
		}
		builder.append(")");
		return builder.toString();
	}

} // InstRamSetAddressImpl
