package servlet.command;

import dao.ProductDAO;
import dao.impl.ProductDAOImpl;
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
public class DelFromCart implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAOImpl();
        List<Product> cart = (LinkedList<Product>) req.getSession().getAttribute("cart");
        String id = req.getParameter("id");
        cart.remove(productDAO.findById(Long.valueOf(id)));
        req.getSession().setAttribute("cart", cart);
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }
}
