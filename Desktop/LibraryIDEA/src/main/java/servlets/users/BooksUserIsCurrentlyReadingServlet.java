package servlets.users;

import entities.Book;
import entities.User;
import service.serviceInterfaceImplementation.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BooksUserIsCurrentlyReadingServlet", urlPatterns = "/booksUserIsCurrentlyReading")
public class BooksUserIsCurrentlyReadingServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        List<Book> booksReadCurrently = userService.getBooksUserIsCurrentlyReading(userName);
        request.setAttribute("booksReadCurrently", booksReadCurrently);
        request.getRequestDispatcher("/users.jsp").include(request, response);
    }
}
