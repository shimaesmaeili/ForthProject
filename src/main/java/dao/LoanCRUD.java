package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class LoanCRUD {
	public static int insert(Loan loan) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(loan);
		transaction.commit();
		session.close();
		return loan.getId();
	}

	public static ArrayList<HashMap<String, String>> findAll() {
		ArrayList<HashMap<String, String>> loans = new ArrayList<HashMap<String, String>>();
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("from dao.Loan");
		List<Loan> results = query.list();
		session.close();
		for (Loan result : results){
			HashMap<String, String> fields = new HashMap<String, String>();
			fields.put("id", String.valueOf(result.getId()));
			fields.put("name", result.getName());
			fields.put("interestRate", String.valueOf(result.getInterestRate()));

			loans.add(fields);
		}
		return loans;
	}
	
	public static List<GrantCondition> findConditionsById(int loanId) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("from dao.GrantCondition where loan.id=" + loanId);
		List<GrantCondition> results = query.list();
		session.close();
		return results;
	}

	public static Loan findLoanById(int loanId) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query query = session.createQuery("from dao.Loan where id=" + loanId);
		List<Loan> results = query.list();
		session.close();
		return results.get(0);
	}
}
