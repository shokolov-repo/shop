package servlet.command;

import dao.ProductDAO;
import dao.impl.ProductDAOImpl;
import entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dmity on 26.10.15.
 */
public class AddProductToBasket implements Command {
    ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> addProducts = new LinkedList<>();
        String id = req.getParameter("productId");
        addProducts.add(productDAO.findById(Long.getLong(id)));
        req.getSession().setAttribute("addProducts", addProducts);
        CommandMap.getCommand("indexPage").execute(req, resp);


    }
}
