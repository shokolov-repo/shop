package servlet.command;

import dao.ProductSoldDAO;
import dao.impl.ProductSoldDAOImpl;
import entity.ProductSold;
import servlet.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dmity on 27.10.15.
 */
public class OrderPage implements Command {
    ProductSoldDAO productSoldDAO = new ProductSoldDAOImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<ProductSold> products = productSoldDAO.findAll(Long.valueOf(id));
        req.setAttribute("products", products);
        req.getRequestDispatcher("/orderPage.jsp").forward(req, resp);
    }
}
