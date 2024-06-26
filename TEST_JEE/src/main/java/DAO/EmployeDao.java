package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.*;

public class EmployeDao {
public List<Employe> getAllEmployes(){
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	List<Employe> employes= session.createQuery("from Employe", Employe.class).list();
	sessionFactory.close();
	return employes;
}

public Employe addEmploye(Employe employe) {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction=session.beginTransaction();
	session.persist(employe);
	transaction.commit();
	session.close();
	sessionFactory.close();
	return employe;
}

public void deleteEmploye(Employe employe) {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction=session.beginTransaction();
	session.remove(employe);
	transaction.commit();
	session.close();
	sessionFactory.close();
}
}