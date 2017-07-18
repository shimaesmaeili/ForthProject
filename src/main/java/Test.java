import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args){
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("delete from dao.Real where id='113'");
		query.executeUpdate();
		t.commit();
		session.close();
	}
}
