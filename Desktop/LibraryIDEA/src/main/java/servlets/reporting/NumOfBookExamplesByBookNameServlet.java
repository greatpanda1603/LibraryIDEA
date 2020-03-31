package servlets.reporting;

import entities.BookExample;
import service.serviceInterfaceImplementation.BookExampleService;
import service.serviceInterfaceImplementation.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NumOfBookExamplesByBookNameServlet", urlPatterns = "/numOfBookExamplesByBookName")
public class NumOfBookExamplesByBookNameServlet extends HttpServlet {
    private BookExampleService bookExampleService;

    @Override
    public void init() throws ServletException {
        bookExampleService = new BookExampleService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("bookName");
        Integer numOfBooks = bookExampleService.getNumOfBookExamplesByBookName(bookName);
        String requestResult = "There are " + numOfBooks + " examples of "+bookName+" stored in the library";
        request.setAttribute("numOfBookExamplesByBookName", requestResult);
        request.getRequestDispatcher("/reporting.jsp").include(request, response);
    }
}
