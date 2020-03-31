package dao.daoInterfaceImplementation;

import dao.daoInterface.BookExampleDaoInterface;
import entities.BookExample;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class BookExampleDao implements BookExampleDaoInterface {
    @SuppressWarnings("unchecked")
    @Override
    public List<BookExample> getBookExamplesByBookName(String bookName) {
        Session session = null;
        List<BookExample> bookExamples = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("select e from BookExample e inner join e.book b where b.name = :name");
            query.setParameter("name", bookName);
            bookExamples = query.list();
        } catch (Exception e) {
            System.out.println("error while reading the list");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return bookExamples;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BookExample> getBookExamplesByBookNameWhichAreAvailable(String bookName) {
        Session session = null;
        List<BookExample> bookExamples = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery(
                    "select e from BookExample e inner join e.book b inner join e.userActions us where (b.name = :name) and ((us.takeDate is not null) and (us.returnDate is not null)) or (us.takeDate is null)");
            query.setParameter("name", bookName);
            bookExamples = query.list();
        } catch (Exception e) {
            System.out.println("error while reading the list");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return bookExamples;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BookExample> getBookExamplesByBookNameWhichWereTaken(String bookName) {
        Session session = null;
        List<BookExample> bookExamples = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery(
                    "select e from BookExample e inner join e.book b inner join e.userActions us where (b.name = :name) and (us.returnDate is null)");
            query.setParameter("name", bookName);
            bookExamples = query.list();
        } catch (Exception e) {
            System.out.println("error while reading the list");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return bookExamples;
    }
}
