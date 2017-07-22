package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LegalCRUD {
	public static String insert(Legal legal) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		CustomerCRUD.insert(legal);
		session.save(legal);
		transaction.commit();
		session.close();
		return legal.getId();
	}

	public static String findIdByCode(BigInteger eCode) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("from dao.Legal where eCode=" + eCode);
		List<Legal> result = query.list();
		session.close();
		if (result.size() > 0) {
			return result.get(0).getId();
		} else {
			return null;
		}
	}

	public static void remove(String id) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("delete from dao.Legal where id='" + id + "'");
		query.executeUpdate();
		transaction.commit();
		session.close();
	}

	public static ArrayList<HashMap<String, String>> search(String field, String value) {
		ArrayList<HashMap<String, String>> legalCustomers = new ArrayList<HashMap<String, String>>();
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("from dao.Legal where " + field + "='" + value + "'");
		List<Legal> results = query.list();
		session.close();
		for (Legal result : results) {
			HashMap<String, String> fields = new HashMap<String, String>();
			fields.put("id", result.getId());
			fields.put("eCode", String.valueOf(result.geteCode()));
			fields.put("name", result.getName());
			fields.put("registrationDate", String.valueOf(result.getRegistrationDate()));

			legalCustomers.add(fields);
		}
		return legalCustomers;
	}

	public static HashMap<String, String> findById(String id) {
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

	public static void update(Legal legal) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("update dao.Legal set eCode=:code, name=:name, registrationDate=:date where id=:id");
		query.setParameter("code", legal.geteCode());
		query.setParameter("name", legal.getName());
		query.setParameter("date", legal.getRegistrationDate());
		query.setParameter("id", legal.getId());
		Transaction transaction = session.beginTransaction();
		query.executeUpdate();
		transaction.commit();
		session.close();
	}
}
