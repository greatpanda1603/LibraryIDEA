package servlets.users;

import service.serviceInterfaceImplementation.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AverageAgeOfUsersByAuthorServlet", urlPatterns = "/averageAgeOfUsersByAuthor")
public class AverageAgeOfUsersByAuthorServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Double averageAgeOfUsersByAuthor = userService.getAverageAgeOfUsersByAuthor(firstName, lastName);
        String requestResult = "Average users' age who are reading " + firstName + " " + lastName + " is " + averageAgeOfUsersByAuthor;
        request.setAttribute("averageAgeOfUsersByAuthor", requestResult);
        request.getRequestDispatcher("/users.jsp").include(request, response);
    }
}
