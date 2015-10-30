package servlet.command;

import dao.ProductDAO;
import dao.impl.ProductDAOImpl;
import entity.Product;
import servlet.Command;
import servlet.CommandMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dmity on 26.10.15.
 */
public class AddProductToCart implements Command {
    ProductDAO productDAO = new ProductDAOImpl();


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> cart = (List<Product>) req.getSession().getAttribute("cart");
        String id = req.getParameter("id");
        Product product = productDAO.findById(Long.valueOf(id));
        if (!cart.contains(product)) {
            cart.add(product);
        } else {
            req.setAttribute("error","cart contains this product");
        }
        req.getSession().setAttribute("cart", cart);
        CommandMap.getCommand("indexPage").execute(req, resp);


    }
}
