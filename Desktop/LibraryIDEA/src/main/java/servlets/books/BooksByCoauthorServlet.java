package servlets.books;

import entities.Book;
import service.serviceInterfaceImplementation.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BooksByCoauthorServlet", urlPatterns = "/booksByCoauthor")
public class BooksByCoauthorServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        List<Book> booksByCoauthor = bookService.getBookByCoauthor(firstName, lastName);
        request.setAttribute("booksByCoauthor", booksByCoauthor);
        request.getRequestDispatcher("/books.jsp").include(request, response);
    }
}
