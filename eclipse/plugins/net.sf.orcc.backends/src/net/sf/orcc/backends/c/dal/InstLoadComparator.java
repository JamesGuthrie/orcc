package net.sf.orcc.backends.c.dal;

import java.util.Comparator;
import java.util.List;

import net.sf.orcc.ir.ExprInt;
import net.sf.orcc.ir.Expression;
import net.sf.orcc.ir.InstLoad;

/**
 * Helper class to compare source port and indices of a load instruction
 *
 * @author James Guthrie
 *
 */
public class InstLoadComparator implements Comparator<InstLoad> {

	@Override
	public int compare(InstLoad u, InstLoad v) {
		List<Expression> uIndexes = u.getIndexes();
		List<Expression> vIndexes = v.getIndexes();
		boolean flag = true;
		for (Expression e : uIndexes) {
			boolean iflag = false;
			for (Expression f : vIndexes) {
				if (e instanceof ExprInt && f instanceof ExprInt) {
					if (((ExprInt) e).getIntValue() == ((ExprInt) f).getIntValue()) {
						iflag = true;
					}
				}
			}
			if (iflag == false) {
				flag = false;
			}
		}
		String uName = u.getSource().getVariable().getName();
		String vName = v.getSource().getVariable().getName();
		if (uName.equals(vName) && flag == true) {
			return 0;
		} else {
			return uName.concat(uIndexes.toString()).compareTo(vName.concat(vIndexes.toString()));
		}
	}
}