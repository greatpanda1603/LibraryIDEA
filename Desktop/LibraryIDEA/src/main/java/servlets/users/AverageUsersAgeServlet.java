package servlets.users;

import service.serviceInterfaceImplementation.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AverageUsersAgeServlet", urlPatterns = "/averageUsersAge")
public class AverageUsersAgeServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double averageUsersAge = userService.getAverageUsersAge();
        String requestResult = "Average users' age is " + averageUsersAge;
        request.setAttribute("averageUsersAge", requestResult);
        request.getRequestDispatcher("/users.jsp").include(request, response);
    }
}
