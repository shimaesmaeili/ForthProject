package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class LoanCRUD {
	public static int insert(Loan loan) throws ClassNotFoundException, SQLException {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Set<GrantCondition> grantConditions = loan.getGrantConditions();
		loan.setGrantConditions(new HashSet<GrantCondition>());
		session.save(loan);
		for (GrantCondition grantCondition : grantConditions){
			session.save(grantCondition);
		}
		transaction.commit();
		session.close();
		return loan.getId();
	}
}
