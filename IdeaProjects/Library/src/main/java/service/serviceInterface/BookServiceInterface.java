package service.serviceInterface;

import entities.Book;

import java.util.List;

public interface BookServiceInterface {

    void create(Book book);

    Book getById(Long book_id);

    void updateById();

    void deleteById(Long book_id);

    List<Book> getBookByAuthor(String firstName, String lastName);

    List<Book> getBookByCoauthor(String firstName, String lastName);

    Integer getAllBooksPublishedAfterUkraineProclaimedIndependence();
}
