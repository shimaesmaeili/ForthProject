package logic;

import dao.LegalCRUD;
import dao.RealCRUD;

import java.sql.SQLException;

public class Remove {
	public static void removeRealCustomer(String id) throws SQLException, ClassNotFoundException {
		RealCRUD.remove(id);
	}

	public static void removeLegalCustomer(String id) throws SQLException, ClassNotFoundException {
		LegalCRUD.remove(id);
	}
}
