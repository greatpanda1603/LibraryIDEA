package dao.daoInterface;

import entities.BookExample;

import java.util.List;

public interface BookExampleDaoInterface {

    List<BookExample> getBookExamplesByBookName(String bookName);

    List<BookExample> getBookExamplesByBookNameWhichAreAvailable(String bookName);

    List<BookExample> getBookExamplesByBookNameWhichWereTaken(String bookName);
}
