package service.serviceInterfaceImplementation;

import dao.daoInterfaceImplementation.BookDao;
import entities.Book;
import service.serviceInterface.BookServiceInterface;

import java.util.List;

public class BookService implements BookServiceInterface {

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
