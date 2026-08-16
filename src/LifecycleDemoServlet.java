import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class LifecycleDemoServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        System.out.println("Servlet initialized.");
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Servlet Lifecycle</title></head>");
        out.println("<body>");
        out.println("<h1>Servlet Lifecycle Demo</h1>");
        out.println("<p>doGet() method executed.</p>");
        out.println("</body>");
        out.println("</html>");

        System.out.println("doGet() method executed.");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet destroyed.");

        super.destroy();
    }
}