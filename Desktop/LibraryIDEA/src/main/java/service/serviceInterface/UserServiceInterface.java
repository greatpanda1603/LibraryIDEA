package service.serviceInterface;

import entities.Book;
import entities.User;
import java.util.List;

public interface UserServiceInterface {

    Double getAverageUsersAge();

    Double getAverageAgeOfUsersByAuthor(String firstName, String lastName);

    Double getAverageAgeOfUsersByBook(String bookName);

    List<Book> getUserReadingHistory(String userName);

    List<Book> getBooksUserIsCurrentlyReading(String userName);

    Integer getNumOfDaysUserIsUsingLibrary(String userName);

    List<User> getDebtors();
}
