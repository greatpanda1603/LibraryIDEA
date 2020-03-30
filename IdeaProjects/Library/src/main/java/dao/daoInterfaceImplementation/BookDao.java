package dao.daoInterfaceImplementation;

import dao.daoInterface.BookDaoInterface;
import entities.Book;
import org.hibernate.query.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;
import java.util.Optional;
import static util.Constants.YEAR_OF_UKRAINE_STATE_INDEPENDENCE;

public class BookDao implements BookDaoInterface {

    @Override
    public void add(Book book) {

    }

    @Override
    public Book fetchById(Long book_id) {

        return null;
    }

    @Override
    public void updateById() {

    }

    @Override
    public void deleteById(Long book_id) {

    }

    @Override
    public Optional<Book> getById(Long book_id) {

        return null;
    }

    @Override
    public List<Book> getAll() {

        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> getBookByAuthor(String firstName, String lastName) {
        Session session = null;
        List<Book> books = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session
                    .createQuery("select b.name from Book b inner join b.author a where a.firstName = :firstName and a.lastName = :lastName");
            query.setString("firstName", firstName);
            query.setString("lastName", lastName);
            books = query.list();
        } catch (Exception e) {
            System.out.println("error while reading the list");

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return books;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> getBookByCoauthor(String firstName, String lastName) {
        Session session = null;
        List<Book> books = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session
                    .createQuery("select b.name from Book b inner join b.coauthors c where c.firstName = :firstName and c.lastName = :lastName");
            query.setString("firstName", firstName);
            query.setString("lastName", lastName);
            books = query.list();
        } catch (Exception e) {
            System.out.println("error while reading the list");

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return books;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> getAllBooksPublishedAfterUkraineProclaimedIndependence() {
        Session session = null;
        List<Book> books = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery(
                    "select b.name from Book b inner join b.bookExamples e where e.pubslishingYear > :pubslishingYear");
            query.setInteger("pubslishingYear", YEAR_OF_UKRAINE_STATE_INDEPENDENCE);
            books = query.list();
        } catch (Exception e) {
            System.out.println("error while reading the list");

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return books;
    }
}
