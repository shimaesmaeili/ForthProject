package dao;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RealCRUD {

	public static String insert(Real real) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		CustomerCRUD.insert(real);
		session.save(real);
		transaction.commit();
		session.close();
		return real.getId();
	}

	public static String findIdByCode(BigInteger idCode) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("from dao.Real where idCode=" + idCode);
		List<Real> result = query.list();
		session.close();
		if (result.size() > 0) {
			return result.get(0).getId();
		} else {
			return null;
		}
	}

	public static void remove(String id) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("delete from dao.Real where id='" + id + "'");
		query.executeUpdate();
		t.commit();
		session.close();
	}

	public static ArrayList<HashMap<String, String>> search(String field, String value) {
		ArrayList<HashMap<String, String>> realCustomers = new ArrayList<HashMap<String, String>>();
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("from dao.Real where " + field + "='" + value + "'");
		List<Real> results = query.list();
		session.close();
		for (Real result : results) {
			HashMap<String, String> fields = new HashMap<String, String>();
			fields.put("id", result.getId());
			fields.put("idCode", String.valueOf(result.getIdCode()));
			fields.put("firstName", result.getFirstName());
			fields.put("lastName", result.getLastName());
			fields.put("fatherName", result.getFatherName());
			fields.put("birthDate", String.valueOf(result.getBirthDate()));

			realCustomers.add(fields);
		}
		return realCustomers;
	}

	public static Real findById(String id) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("from dao.Real where id='" + id + "'");
		List<Real> result = query.list();
		session.close();
		return result.get(0);
	}

	public static void update(Real real) {
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
