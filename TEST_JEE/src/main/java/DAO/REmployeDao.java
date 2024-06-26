	package DAO;
	
	import java.util.List;
	
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;
	
	import entities.REmploye;
	
	public class REmployeDao {
	public List<REmploye> getAllREmployes(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		List<REmploye> remployes= session.createQuery("from REmploye", REmploye.class).list();
		sessionFactory.close();
		return remployes;
	}
	
	public REmploye addREmploye(REmploye remploye) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.persist(remploye);
		transaction.commit();
		session.close();
		sessionFactory.close();
		return remploye;
	}
	
	public void deleteREmploye(REmploye remploye) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.remove(remploye);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	}