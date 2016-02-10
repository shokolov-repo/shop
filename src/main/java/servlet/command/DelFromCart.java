package servlet.command;

import dao.ProductDAO;
import dao.impl.ProductDAOImpl;
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
public class DelFromCart implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductCart> cart = (LinkedList<ProductCart>) req.getSession().getAttribute("cart");
        String id = req.getParameter("id");
        long productId = Long.valueOf(id);
        ProductCart product = null;

        for (ProductCart productCart : cart) {
            if (productCart.getId() == productId) {
                product = productCart;
//                break;
//            }
//        }
//
//        if (product != null && product.getQuantity() > 1) {
//            product.setQuantity(product.getQuantity() - 1);
//        } else {

            }
        }
        cart.remove(product);

        req.getSession().setAttribute("cart", cart);
        req.getRequestDispatcher("dispatcher?command=cart").forward(req, resp);
    }
}
