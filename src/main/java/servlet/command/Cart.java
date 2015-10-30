package servlet.command;

import entity.Product;
import servlet.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dmity on 27.10.15.
 */
public class Cart implements Command {

    List<Product> cart = new LinkedList<>();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double totalPrice = 0.0d;
        cart = (List<Product>) req.getSession().getAttribute("cart");

        if (cart.size() > 0) {
            for (Product cartProduct : cart) {
                totalPrice += cartProduct.getPrice();
            }
            req.setAttribute("totalPrice", totalPrice);
        }
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }
}
