import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/shopping-cart")
public class ShoppingCartServlet extends HttpServlet {

    // adds items to shopping cart stored in the user's session
    private void addItem(HttpSession session, String item) {

        // get the existing cart
        List<String> cart = getCartItems(session);

        // add the new item
        cart.add(item);

        // store the updated cart back in the session
        session.setAttribute("cart", cart);
    }

    // retrieves the shopping cart from the user session
    @SuppressWarnings("unchecked")
    private List<String> getCartItems(HttpSession session) {

        List<String> cart =
                (List<String>) session.getAttribute("cart");

        // create a new cart if one doesnt exist
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        return cart;
    }

    // Handles GET requests and displays the current cart
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // retrieve the existing session
        HttpSession session = request.getSession();

        // retrieve the cart from session
        List<String> cart = getCartItems(session);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Shopping Cart</title></head>");
        out.println("<body>");

        out.println("<h1>Shopping Cart</h1>");
        out.println("<form method='post' action='shopping-cart'>");
         out.println("<input type='text' name='item' placeholder='Enter item'>");
         out.println("<button type='submit'>Add to Cart</button>");
         out.println("</form>");

        if (cart.isEmpty()) {
            out.println("<p>cart is empty</p>");
        } else {
            out.println("<ul>");

            for (String item : cart) {
                out.println("<li>" + item + "</li>");
            }
            out.println("</ul>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    // POST requests for putting items to the cart
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // get/create the user session
        HttpSession session = request.getSession();

        // get item submitted by the client
        String item = request.getParameter("item");

        if (item != null && !item.trim().isEmpty()) {

            //add item to the session cart
            addItem(session, item);
            response.getWriter().println(
                    "item added to cart: " + item
            );

        } else {
            response.getWriter().println(
                    "provide an item."
            );
        }
    }
}