import dao.GrantCondition;
import dao.Loan;
import dao.Real;
import dao.RealCRUD;
import logic.Insert;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		Session session = new Configuration().configure().buildSessionFactory().openSession();
//		Transaction t = session.beginTransaction();
//		Query query = session.createQuery("delete from dao.Real where id='113'");
//		query.executeUpdate();
//		t.commit();
//		session.close();
//		Insert.insertNewLoan("مسکن", 10, new String[]{"شرط۱", "شرط۲"}, new String[]{"5", "10"}, new String[]{"10", "20"}, new String[]{"10", "100"}, new String[]{"100", "200"});

//		HashMap<String, String> realCustomer = new HashMap<String, String>();
//		Session session = new Configuration().configure().buildSessionFactory().openSession();
//		Query query = session.createQuery("from dao.Real where id='" + 1 + "'");
//		List<Real> result = query.list();
//		session.close();
//		if (result.size() > 0) {
//			realCustomer.put("id", result.get(0).getId());
//			realCustomer.put("idCode", String.valueOf(result.get(0).getIdCode()));
//			realCustomer.put("firstName", result.get(0).getFirstName());
//			realCustomer.put("lastName", result.get(0).getLastName());
//			realCustomer.put("fatherName", result.get(0).getFatherName());
//			realCustomer.put("birthDate", String.valueOf(result.get(0).getBirthDate()));
//		}

        Loan loan = new Loan();
        loan.setName("خرید خودرو");
        loan.setInterestRate(15);

//        session.save(loan);

		GrantCondition grantCondition1 = new GrantCondition();
		grantCondition1.setName("شرط اول");
		grantCondition1.setMinDuration(10);
		grantCondition1.setMaxDuration(100);
		grantCondition1.setMinAmount(new BigInteger("50"));
		grantCondition1.setMaxAmount(new BigInteger("600"));
		grantCondition1.setLoan(loan);

        GrantCondition grantCondition2 = new GrantCondition();
        grantCondition2.setName("شرط دوم");
        grantCondition2.setMinDuration(100);
        grantCondition2.setMaxDuration(500);
        grantCondition2.setMinAmount(new BigInteger("500"));
        grantCondition2.setMaxAmount(new BigInteger("1800"));
        grantCondition2.setLoan(loan);

        Set<GrantCondition> grantConditionSet = new HashSet<GrantCondition>();
        grantConditionSet.add(grantCondition1);
        grantConditionSet.add(grantCondition2);

        loan.setGrantConditions(new HashSet<GrantCondition>());
        loan.getGrantConditions().add(grantCondition1);
        loan.getGrantConditions().add(grantCondition2);

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(loan);
//        session.save(grantCondition1);
//        session.save(grantCondition2);

//        loan.setGrantConditions(new HashSet<GrantCondition>());
//        loan.getGrantConditions().add(grantCondition1);
//
//        session.save(grantCondition1);
//        transaction.commit();
//        session.close();
//
//        session = new Configuration().configure().buildSessionFactory().openSession();
//        transaction = session.beginTransaction();
//        session.save(grantCondition2);
//        transaction.commit();
//        session.close();
//
//        session = new Configuration().configure().buildSessionFactory().openSession();
//        transaction = session.beginTransaction();
//        session.save(loan);
        transaction.commit();
        session.close();
	}
}
