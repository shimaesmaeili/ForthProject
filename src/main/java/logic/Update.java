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
	public static void updateRealCustomer(HashMap<String, String> newValues) throws SQLException, ClassNotFoundException {
		Real real = new Real();
		real.setId(newValues.get("id"));
		real.setIdCode(new BigInteger(newValues.get("idCode")));
		real.setFirstName(newValues.get("firstName"));
		real.setLastName(newValues.get("lastName"));
		real.setFatherName(newValues.get("fatherName"));
		real.setBirthDate(Date.valueOf(newValues.get("birthDate")));

		RealCRUD.update(real);
	}

	public static void updateLegalCustomer(HashMap<String, String> newValues) throws SQLException, ClassNotFoundException {
		Legal legal = new Legal();
		legal.setId(newValues.get("id"));
		legal.seteCode(new BigInteger(newValues.get("eCode")));
		legal.setName(newValues.get("name"));
		legal.setRegistrationDate(Date.valueOf(newValues.get("registrationDate")));

		LegalCRUD.update(legal);
	}
}
