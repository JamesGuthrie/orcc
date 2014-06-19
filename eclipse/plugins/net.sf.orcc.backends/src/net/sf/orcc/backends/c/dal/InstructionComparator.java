package net.sf.orcc.backends.c.dal;

import java.util.Comparator;

import net.sf.orcc.ir.Instruction;

public class InstructionComparator implements Comparator<Instruction> {

	@Override
	public int compare(Instruction o1, Instruction o2) {
		return o1.toString().compareTo(o2.toString());
	}
}