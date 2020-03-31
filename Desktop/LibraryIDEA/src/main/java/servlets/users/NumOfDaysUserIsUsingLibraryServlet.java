package servlets.users;

import service.serviceInterfaceImplementation.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NumOfDaysUserIsUsingLibraryServlet", urlPatterns = "/numOfDaysUserIsUsingLibrary")
public class NumOfDaysUserIsUsingLibraryServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        Integer numOfDaysUserIsUsingLibrary = userService.getNumOfDaysUserIsUsingLibrary(userName);
        String requestResult = "User " + userName + " has been using library for " + numOfDaysUserIsUsingLibrary+" days already";
        request.setAttribute("numOfDaysUserIsUsingLibrary", requestResult);
        request.getRequestDispatcher("/users.jsp").include(request, response);
    }
}
