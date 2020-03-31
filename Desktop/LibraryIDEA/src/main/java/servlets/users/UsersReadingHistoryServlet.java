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

@WebServlet(name = "UsersReadingHistoryServlet", urlPatterns = "/usersReadingHistory")
public class UsersReadingHistoryServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        List<Book> booksReadInThePast = userService.getUserReadingHistory(userName);
        request.setAttribute("booksReadInThePast", booksReadInThePast);
        request.getRequestDispatcher("/users.jsp").include(request, response);
    }
}
