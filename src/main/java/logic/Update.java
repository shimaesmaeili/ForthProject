package logic;

import dao.Legal;
import dao.LegalCRUD;
import dao.Real;
import dao.RealCRUD;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;

public class Update {
	public static boolean updateRealCustomer(HashMap<String, String> newValues) {
		if (Verify.isValidCodeReal(newValues.get("id"), new BigInteger(newValues.get("idCode")))) {
			Real real = new Real();
			real.setId(newValues.get("id"));
			real.setIdCode(new BigInteger(newValues.get("idCode")));
			real.setFirstName(newValues.get("firstName"));
			real.setLastName(newValues.get("lastName"));
			real.setFatherName(newValues.get("fatherName"));
			real.setBirthDate(Date.valueOf(newValues.get("birthDate")));
			RealCRUD.update(real);
			return true;
		} else {
			return false;
		}
	}

	public static boolean updateLegalCustomer(HashMap<String, String> newValues) {
		if (Verify.isValidCodeLegal(newValues.get("id"), new BigInteger(newValues.get("eCode")))) {
			Legal legal = new Legal();
			legal.setId(newValues.get("id"));
			legal.seteCode(new BigInteger(newValues.get("eCode")));
			legal.setName(newValues.get("name"));
			legal.setRegistrationDate(Date.valueOf(newValues.get("registrationDate")));

			LegalCRUD.update(legal);
			return true;
		} else {
			return false;
		}
	}
}
