package service;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import DAO.EmployeDao;
import entities.Employe;
import util.*;

public class EmployeService {
    EmployeDao employeDao;

    public EmployeService() {
        employeDao = new EmployeDao();
    }

    public Employe addEmploye(Employe employe) {
        return employeDao.addEmploye(employe);
    }

    public List<Employe> getAllEmployes() {
        return employeDao.getAllEmployes();
    }

    public void deleteEmploye(Employe employe) {
        employeDao.deleteEmploye(employe);
    }

    public boolean emailExists(String email) {
        // Use the HibernateUtil to get the SessionFactory
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Employe> query = session.createQuery("FROM ecole WHERE email = :email", Employe.class);
            query.setParameter("email", email);
            return query.uniqueResult() != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePassword(String email, String newPassword) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query<Employe> query = session.createQuery("FROM ecole WHERE email = :email", Employe.class);
            query.setParameter("email", email);
            Employe signup = query.uniqueResult();
            if (signup != null) {
                signup.setPass(newPassword); // Ensure you hash the password before saving it
                session.update(signup);
                session.getTransaction().commit();
                return true;
            } else {
                session.getTransaction().rollback();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
