package logic;

import dao.LegalCRUD;
import dao.RealCRUD;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Search {
	public static ArrayList<HashMap<String, String>> findRealCustomers(String field, String value) throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException {
		return RealCRUD.search(field, value);
	}

	public static ArrayList<HashMap<String, String>> findLegalCustomers(String field, String value) throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException {
		return LegalCRUD.search(field, value);
	}

	public static HashMap<String, String> findRealCustomerById(String id) throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException {
		return RealCRUD.findById(id);
	}

	public static HashMap<String, String> findLegalCustomerById(String id) throws SQLException, ClassNotFoundException {
		return LegalCRUD.findById(id);
	}
}
