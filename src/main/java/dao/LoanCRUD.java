package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
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
		for (int i=0; i<results.size(); i++){
			HashMap<String, String> fields = new HashMap<String, String>();
			fields.put("id", String.valueOf(results.get(i).getId()));
			fields.put("name", results.get(i).getName());
			fields.put("interestRate", String.valueOf(results.get(i).getInterestRate()));

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
