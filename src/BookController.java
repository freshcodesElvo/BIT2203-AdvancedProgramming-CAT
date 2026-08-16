package library;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class BookController extends HttpServlet {

    private BookDAO bookDAO;

    @Override
    public void init() throws ServletException {
        bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Book> books = bookDAO.getAllBooks();

        request.setAttribute("books", books);

        request.getRequestDispatcher("/bookList.jsp")
               .forward(request, response);
    }
}