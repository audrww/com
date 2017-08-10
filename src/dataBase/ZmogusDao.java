package dataBase;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ZmogusDao {

    public void addZmogus(Zmogus zmogus) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(zmogus);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if(trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteZmogus(int id) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Zmogus zmogus = session.load(Zmogus.class, id);
            session.delete(zmogus);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if(trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateZmogus(Zmogus zmogus) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            session.update(zmogus);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if(trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Zmogus> getAllZmones() {
        List<Zmogus> zmogus = new ArrayList<Zmogus>();
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            zmogus = session.createQuery("FROM Zmogus").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return zmogus;
    }

    public List<Zmogus> getZmogusByVardas(String vardas) {
        List<Zmogus> zmogus = new ArrayList<Zmogus>();
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM Zmogus WHERE vardas = :vardas");
            query.setParameter("vardas", vardas);
            zmogus = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return zmogus;
    }

    public Zmogus getZmogusById(int id) {
        Zmogus zmogus = null;
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM Zmogus WHERE id = :id");
            query.setInteger("id", id);
            zmogus = (Zmogus) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return zmogus;
    }

}
