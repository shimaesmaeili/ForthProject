package logic;

import dao.GrantCondition;
import dao.LegalCRUD;
import dao.LoanCRUD;
import dao.RealCRUD;

import java.math.BigInteger;
import java.util.List;

public class Verify {
	public static String getRealId(BigInteger idCode) {
		return RealCRUD.findIdByCode(idCode);
	}

	public static String getLegalId(BigInteger eCode) {
		return LegalCRUD.findIdByCode(eCode);
	}

	public static boolean isValidCodeReal(String id, BigInteger newIdCode) {
		String assignedId = RealCRUD.findIdByCode(newIdCode);
		if (assignedId==null || assignedId.equals(id)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidCodeLegal(String id, BigInteger newCode) {
		String assignedId = LegalCRUD.findIdByCode(newCode);
		if (assignedId==null || assignedId.equals(id)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean hasValidCondition(int loanId, int duration, BigInteger amount) {
		List<GrantCondition> grantConditions = LoanCRUD.findConditionsById(loanId);
		for (GrantCondition grantCondition : grantConditions){
			if (grantCondition.getMinDuration() < duration && grantCondition.getMaxDuration() > duration) {
				if (grantCondition.getMinAmount().compareTo(amount) < 0 && grantCondition.getMaxAmount().compareTo(amount) > 0) {
					return true;
				}
			}
		}
		return false;
	}
}
