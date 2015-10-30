package servlet.command;

import dao.ProductDAO;
import dao.impl.ProductDAOImpl;
import entity.Product;
import servlet.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dmity on 26.10.15.
 */
public class IndexPage implements Command {
    ProductDAO productDAO = new ProductDAOImpl();


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productDAO.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
