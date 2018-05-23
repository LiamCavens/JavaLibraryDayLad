package db;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBHelper {

    private static Session session;
    private static Transaction transaction;

    public static void saveOrUpdate(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void deleteAll(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            String hql = "DELETE FROM " + classType.getName();
            transaction = session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    //    public static <T> void deleteAll(Class classType) {
//        session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            transaction = session.beginTransaction();
//            Criteria cr = session.createCriteria(classType);
//            List<T> results = cr.list();
//            for (T object : results) {
//                session.delete(object);
//            }
//        } catch (HibernateException e) {
//            transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }

    public static <T> List<T> getAll(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        try {
            Criteria criteria = session.createCriteria(classType);
            results = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


    public static <T> T find(Class classType, int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        try {
            Criteria criteria = session.createCriteria(classType);
            criteria.add(Restrictions.eq("id", id));
            result = (T) criteria.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}