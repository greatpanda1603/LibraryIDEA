package servlets.reporting;

import entities.BookExample;
import service.serviceInterfaceImplementation.BookExampleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookExamplesByBookNameWhichWereTakenServlet", urlPatterns = "/bookExamplesByBookNameWhichWereTaken")
public class BookExamplesByBookNameWhichWereTakenServlet extends HttpServlet {
    private BookExampleService bookExampleService;

    @Override
    public void init() throws ServletException {
        bookExampleService = new BookExampleService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("bookName");
        List<BookExample> bookExamplesByBookNameWhichWereTaken = bookExampleService.getBookExamplesByBookNameWhichWereTaken(bookName);
        request.setAttribute("bookExamplesByBookNameWhichWereTaken", bookExamplesByBookNameWhichWereTaken);
        request.getRequestDispatcher("/reporting.jsp").include(request, response);
    }
}
