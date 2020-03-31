package servlets.books;

import service.serviceInterfaceImplementation.BookService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndependenceBooksServlet", urlPatterns = "/independenceBooks")
public class IndependenceBooksServlet extends HttpServlet {

    private BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer numOfBooks = bookService.getAllBooksPublishedAfterUkraineProclaimedIndependence();
        String requestResult = "There are " + numOfBooks + " books published after Ukraine proclaimed independence";
        request.setAttribute("numOfBooks", requestResult);
        request.getRequestDispatcher("/books.jsp").include(request, response);
    }
}
