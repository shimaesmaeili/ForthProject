package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public class CustomerCRUD {
	public static String insert(Customer customer) throws ClassNotFoundException, SQLException {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		customer.setId(String.valueOf(nextId()));
		session.save(customer);
		t.commit();
		session.close();
		return customer.getId();
	}

	private static int nextId() throws SQLException, ClassNotFoundException {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query  = session.createQuery("select cast(id as integer) from dao.Customer");
		List<Integer> ids = query.list();
		int maxId = Collections.max(ids);
		session.close();
		return maxId + 1;
	}

//	public static void remove(String id) throws ClassNotFoundException, SQLException {
//		Session session = new Configuration().configure().buildSessionFactory().openSession();
//		Transaction t = session.beginTransaction();
//		Query query = session.createQuery("delete from dao.Customer where id=" + id);
//		query.executeUpdate();
//		t.commit();
//		session.close();
//	}
}
