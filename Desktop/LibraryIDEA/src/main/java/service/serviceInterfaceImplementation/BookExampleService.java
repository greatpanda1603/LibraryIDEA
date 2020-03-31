package service.serviceInterfaceImplementation;

        import dao.daoInterfaceImplementation.BookExampleDao;
        import entities.BookExample;
        import service.serviceInterface.BookExampleServiceInterface;

        import java.util.List;

public class BookExampleService implements BookExampleServiceInterface {
    @Override
    public Integer getNumOfBookExamplesByBookName(String bookName) {
        return new BookExampleDao().getBookExamplesByBookName(bookName).size();
    }

    @Override
    public List<BookExample> getBookExamplesByBookNameWhichAreAvailable(String bookName) {
        return new BookExampleDao()
                .getBookExamplesByBookNameWhichAreAvailable(bookName);
    }

    @Override
    public List<BookExample> getBookExamplesByBookNameWhichWereTaken(String bookName) {
        return new BookExampleDao().getBookExamplesByBookNameWhichWereTaken(bookName);
    }
}
