package servlets.reporting;

import entities.Book;
import entities.BookExample;
import service.serviceInterfaceImplementation.BookExampleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookExamplesByBookNameWhichAreAvailableServlet", urlPatterns = "/bookExamplesByBookNameWhichAreAvailable")
public class BookExamplesByBookNameWhichAreAvailableServlet extends HttpServlet {
    private BookExampleService bookExampleService;

    @Override
    public void init() throws ServletException {
        bookExampleService = new BookExampleService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("bookName");
        List<BookExample> bookExamplesByBookNameWhichAreAvailable = bookExampleService.getBookExamplesByBookNameWhichAreAvailable(bookName);
        request.setAttribute("bookExamplesByBookNameWhichAreAvailable", bookExamplesByBookNameWhichAreAvailable);
        request.getRequestDispatcher("/reporting.jsp").include(request, response);
    }
}
