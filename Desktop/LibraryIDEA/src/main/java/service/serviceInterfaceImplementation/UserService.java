package service.serviceInterfaceImplementation;

import dao.daoInterfaceImplementation.UserDao;
import entities.Book;
import entities.User;
import service.serviceInterface.UserServiceInterface;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class UserService implements UserServiceInterface {

    @Override
    public Double getAverageUsersAge() {
        return new UserDao().getAverageUsersAge();
    }

    @Override
    public Double getAverageAgeOfUsersByAuthor(String firstName, String lastName) {
        return new UserDao().getAverageAgeOfUsersByAuthor(firstName, lastName);

    }

    @Override
    public Double getAverageAgeOfUsersByBook(String bookName) {
        return new UserDao().getAverageAgeOfUsersByBook(bookName);
    }

    @Override
    public List<Book> getUserReadingHistory(String userName) {
        return new UserDao().getUserReadingHistory(userName);
    }

    @Override
    public List<Book> getBooksUserIsCurrentlyReading(String userName) {
        return new UserDao().getBooksUserIsCurrentlyReading(userName);
    }

    @Override
    public Integer getNumOfDaysUserIsUsingLibrary(String userName) {
        Integer days = (int) ChronoUnit.DAYS.between(new UserDao().getUserRegistrationDateByName(userName),
                LocalDate.now());
        return days;
    }

    @Override
    public List<User> getDebtors() {
        return new UserDao().getDebtors();
    }
}
