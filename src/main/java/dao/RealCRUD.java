package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RealCRUD {
	public static String insert(Real real) throws ClassNotFoundException, SQLException {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		CustomerCRUD.insert(real);
		session.save(real);
		t.commit();
		session.close();
		return real.getId();
	}

	public static String findIdByCode(BigInteger idCode) throws ClassNotFoundException, SQLException {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("from dao.Real where idCode=" + idCode);
		List<Real> result = query.list();
		session.close();
		if (result.size() > 0) {
			return result.get(0).getId();
		}
		return null;
	}

	public static void remove(String id) throws ClassNotFoundException, SQLException {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("delete from dao.Real where id='" + id + "'");
		query.executeUpdate();
		t.commit();
		session.close();
	}

	public static ArrayList<HashMap<String, String>> search(String field, String value) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		ArrayList<HashMap<String, String>> realCustomers = new ArrayList<HashMap<String, String>>();
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("from dao.Real where " + field + "='" + value + "'");
		System.out.println("from dao.Real where " + field + "='" + value + "'");
		List<Real> results = query.list();
		session.close();
		for (int i = 0; i < results.size(); i++) {
			HashMap<String, String> fields = new HashMap<String, String>();
			fields.put("id", results.get(i).getId());
			fields.put("idCode", String.valueOf(results.get(i).getIdCode()));
			fields.put("firstName", results.get(i).getFirstName());
			fields.put("lastName", results.get(i).getLastName());
			fields.put("fatherName", results.get(i).getFatherName());
			fields.put("birthDate", String.valueOf(results.get(i).getBirthDate()));

			realCustomers.add(fields);
		}
		return realCustomers;
	}

	public static HashMap<String, String> findById(String id) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		HashMap<String, String> realCustomer = new HashMap<String, String>();
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("from dao.Real where id='" + id + "'");
		List<Real> result = query.list();
		session.close();
		if (result.size() > 0) {
			realCustomer.put("id", result.get(0).getId());
			realCustomer.put("idCode", String.valueOf(result.get(0).getIdCode()));
			realCustomer.put("firstName", result.get(0).getFirstName());
			realCustomer.put("lastName", result.get(0).getLastName());
			realCustomer.put("fatherName", result.get(0).getFatherName());
			realCustomer.put("birthDate", String.valueOf(result.get(0).getBirthDate()));
		}
		return realCustomer;
	}

	public static void update(Real real) throws ClassNotFoundException, SQLException {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("update dao.Real set idCode=:code, firstName=:first, lastName=:last, fatherName=:father, birthDate=:birth where id=:id");
		query.setParameter("code", real.getIdCode());
		query.setParameter("first", real.getFirstName());
		query.setParameter("last", real.getLastName());
		query.setParameter("father", real.getFatherName());
		query.setParameter("birth", real.getBirthDate());
		query.setParameter("id", real.getId());
		Transaction t = session.beginTransaction();
		query.executeUpdate();
		t.commit();
		session.close();
	}
}
