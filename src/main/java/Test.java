import dao.Real;
import logic.Insert;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class Test {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		Session session = new Configuration().configure().buildSessionFactory().openSession();
//		Transaction t = session.beginTransaction();
//		Query query = session.createQuery("delete from dao.Real where id='113'");
//		query.executeUpdate();
//		t.commit();
//		session.close();
//		Insert.insertNewLoan("مسکن", 10, new String[]{"شرط۱", "شرط۲"}, new String[]{"5", "10"}, new String[]{"10", "20"}, new String[]{"10", "100"}, new String[]{"100", "200"});

		HashMap<String, String> realCustomer = new HashMap<String, String>();
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("from dao.Real where id='" + 1 + "'");
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
	}
}
