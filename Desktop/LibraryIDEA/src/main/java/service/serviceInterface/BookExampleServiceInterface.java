package service.serviceInterface;

import entities.BookExample;

import java.util.List;

public interface BookExampleServiceInterface {

    Integer getNumOfBookExamplesByBookName(String bookName);

    List<BookExample> getBookExamplesByBookNameWhichAreAvailable(String bookName);

    List<BookExample> getBookExamplesByBookNameWhichWereTaken(String bookName);
}
