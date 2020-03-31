package servlets.users;

import service.serviceInterfaceImplementation.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AverageUsersAgeByBookServlet", urlPatterns = "/averageAgeOfUsersByBook")
public class AverageUsersAgeByBookServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("bookName");
        Double averageAgeOfUsersByBook = userService.getAverageAgeOfUsersByBook(bookName);
        String requestResult = "Average users' age who are reading " + bookName + " is " + averageAgeOfUsersByBook;
        request.setAttribute("averageAgeOfUsersByBook", requestResult);
        request.getRequestDispatcher("/users.jsp").include(request, response);
    }
}
