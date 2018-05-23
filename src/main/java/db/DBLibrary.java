package db;

import models.Book;
import models.Library;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBLibrary {

    private static Session session;
    private static Transaction transaction;

    public static List<Book> getBookFromLibrary(Library library) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Book> results = null;
        try {
            Criteria criteria = session.createCriteria(Book.class);
            criteria.add(Restrictions.eq("library", library));
            results = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;

    }

}
