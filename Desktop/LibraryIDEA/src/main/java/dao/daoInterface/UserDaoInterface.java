package dao.daoInterface;

import entities.Book;
import entities.User;

import java.time.LocalDate;
import java.util.List;

public interface UserDaoInterface {

    List<User> getAll();

    Double getAverageUsersAge();

    Double getAverageAgeOfUsersByAuthor(String firstName, String lastName);

    Double getAverageAgeOfUsersByBook(String bookName);

    List<Book> getUserReadingHistory(String userName);

    List<Book> getBooksUserIsCurrentlyReading(String userName);

    LocalDate getUserRegistrationDateByName(String userName);

    List<User> getDebtors();

}
