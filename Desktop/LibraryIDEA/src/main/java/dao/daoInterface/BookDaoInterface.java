package dao.daoInterface;

import entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookDaoInterface {

    List<Book> getAll();

    List<Book> getBookByAuthor(String firstName, String lastName);

    List<Book> getBookByCoauthor(String firstName, String lastName);

    List<Book> getAllBooksPublishedAfterUkraineProclaimedIndependence();

}
