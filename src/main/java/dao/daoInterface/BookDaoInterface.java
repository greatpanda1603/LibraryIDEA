package dao.daoInterface;

import entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookDaoInterface {

    void add(Book book);

    Book fetchById(Long book_id);

    void updateById();

    void deleteById(Long book_id);

    Optional<Book> getById(Long book_id);

    List<Book> getAll();

    List<Book> getBookByAuthor(String firstName, String lastName);

    List<Book> getBookByCoauthor(String firstName, String lastName);

    List<Book> getAllBooksPublishedAfterUkraineProclaimedIndependence();

}
