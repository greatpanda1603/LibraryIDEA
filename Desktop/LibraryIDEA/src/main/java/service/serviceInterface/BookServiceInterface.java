package service.serviceInterface;

import entities.Book;

import java.util.List;

public interface BookServiceInterface {

    List<Book> getBookByAuthor(String firstName, String lastName);

    List<Book> getBookByCoauthor(String firstName, String lastName);

    Integer getAllBooksPublishedAfterUkraineProclaimedIndependence();
}
