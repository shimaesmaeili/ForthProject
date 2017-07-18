package logic;

import dao.LegalCRUD;
import dao.RealCRUD;

import java.math.BigInteger;
import java.sql.SQLException;

public class Uniqueness {
	public static String getRealId(BigInteger idCode) throws SQLException, ClassNotFoundException {
		return RealCRUD.findIdByCode(idCode);
	}

	public static String getLegalId(BigInteger eCode) throws SQLException, ClassNotFoundException {
		return LegalCRUD.findIdByCode(eCode);
	}

	public static boolean isValidCodeReal(String id, BigInteger newIdCode) throws SQLException, ClassNotFoundException {
		String assignedId = RealCRUD.findIdByCode(newIdCode);
		if (assignedId==null || assignedId.equals(id)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidCodeLegal(String id, BigInteger newCode) throws SQLException, ClassNotFoundException {
		String assignedId = LegalCRUD.findIdByCode(newCode);
		if (assignedId==null || assignedId.equals(id)) {
			return true;
		} else {
			return false;
		}
	}
}
