package servlet.command;

import entity.Product;
import servlet.Command;
import view.ProductCart;

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


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double cost = 0.0d;
        List<ProductCart> cart = (List<ProductCart>) req.getSession().getAttribute("cart");

        if (cart.size() > 0) {
            for (ProductCart cartProduct : cart) {
                cost += cartProduct.getPrice() * cartProduct.getQuantity();
            }
            req.setAttribute("cost", cost);
        }
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }
}
