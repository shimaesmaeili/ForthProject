package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.Collections;
import java.util.List;

public class CustomerCRUD {
	public static String insert(Customer customer) {
		customer.setId(String.valueOf(nextId()));
		return customer.getId();
	}

	private static int nextId() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("select cast(id as integer) from dao.Customer");
		List<Integer> ids = query.list();
		int maxId = 0;
		if (ids.size() > 0) {
			maxId = Collections.max(ids);
		}
		session.close();
		return maxId + 1;
	}
}
