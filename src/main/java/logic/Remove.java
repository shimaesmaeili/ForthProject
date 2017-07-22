package logic;

import dao.LegalCRUD;
import dao.RealCRUD;

public class Remove {
	public static void removeRealCustomer(String id) {
		RealCRUD.remove(id);
	}

	public static void removeLegalCustomer(String id) {
		LegalCRUD.remove(id);
	}
}
