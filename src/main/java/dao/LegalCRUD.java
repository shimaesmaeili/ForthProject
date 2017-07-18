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

public class LegalCRUD {
	public static String insert(Legal legal) throws ClassNotFoundException, SQLException {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		CustomerCRUD.insert(legal);
		session.save(legal);
		t.commit();
		session.close();
		return legal.getId();
	}

	public static String findIdByCode(BigInteger eCode) throws ClassNotFoundException, SQLException {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("from dao.Legal where eCode=" + eCode);
		List<Legal> result = query.list();
		session.close();
		if (result.size() > 0) {
			return result.get(0).getId();
		}
		return null;
	}

	public static void remove(String id) throws ClassNotFoundException, SQLException {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("delete from dao.Legal where id='" + id + "'");
		query.executeUpdate();
		t.commit();
		session.close();
	}

	public static ArrayList<HashMap<String, String>> search(String field, String value) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		ArrayList<HashMap<String, String>> legalCustomers = new ArrayList<HashMap<String, String>>();
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("from dao.Legal where " + field + "='" + value + "'");
		List<Legal> results = query.list();
		session.close();
		for (int i = 0; i < results.size(); i++) {
			HashMap<String, String> fields = new HashMap<String, String>();
			fields.put("id", results.get(i).getId());
			fields.put("eCode", String.valueOf(results.get(i).geteCode()));
			fields.put("name", results.get(i).getName());
			fields.put("registrationDate", String.valueOf(results.get(i).getRegistrationDate()));

			legalCustomers.add(fields);
		}
		return legalCustomers;
	}

	public static HashMap<String, String> findById(String id) throws ClassNotFoundException, SQLException {
		HashMap<String, String> legalCustomer = new HashMap<String, String>();
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("from dao.Legal where id='" + id + "'");
		List<Legal> result = query.list();
		session.close();
		if (result.size() > 0) {
			legalCustomer.put("id", result.get(0).getId());
			legalCustomer.put("eCode", String.valueOf(result.get(0).geteCode()));
			legalCustomer.put("name", result.get(0).getName());
			legalCustomer.put("registrationDate", String.valueOf(result.get(0).getRegistrationDate()));
		}
		return legalCustomer;
	}

	public static void update(Legal legal) throws ClassNotFoundException, SQLException {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("update dao.Legal set eCode=:code, name=:name, registrationDate=:date where id=:id");
		query.setParameter("code", legal.geteCode());
		query.setParameter("name", legal.getName());
		query.setParameter("date", legal.getRegistrationDate());
		query.setParameter("id", legal.getId());
		Transaction t = session.beginTransaction();
		query.executeUpdate();
		t.commit();
		session.close();
	}
}
