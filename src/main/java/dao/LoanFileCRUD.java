package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LoanFileCRUD {
	public static void insert(LoanFile loanFile) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println(loanFile.getLoanDuration());

		session.save(loanFile);
		transaction.commit();
		session.close();

//		RealCRUD.addLoanFile(loanFile);
	}
}
