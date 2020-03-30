package service.serviceInterfaceImplementation;

import dao.daoInterfaceImplementation.BookDao;
import entities.Book;
import service.serviceInterface.BookServiceInterface;

import java.util.List;

public class BookService implements BookServiceInterface {

    @Override
    public void create(Book book) {
        new BookDao().add(book);

    }

    @Override
    public Book getById(Long book_id) {
        return new BookDao().fetchById(book_id);
    }

    @Override
    public void updateById() {
        new BookDao().updateById();

    }

    @Override
    public void deleteById(Long book_id) {
        new BookDao().deleteById(book_id);

    }

    @Override
    public List<Book> getBookByAuthor(String firstName, String lastName) {
        List<Book> books = new BookDao().getBookByAuthor(firstName, lastName);
        return books;
    }

    @Override
    public List<Book> getBookByCoauthor(String firstName, String lastName) {
        List<Book> books = new BookDao().getBookByCoauthor(firstName, lastName);
        return books;
    }

    @Override
    public Integer getAllBooksPublishedAfterUkraineProclaimedIndependence() {
        List<Book> books = new BookDao().getAllBooksPublishedAfterUkraineProclaimedIndependence();
        return books.size();
    }
}
