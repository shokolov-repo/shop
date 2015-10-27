package servlet.command;

import dao.ProductDAO;
import dao.impl.ProductDAOImpl;
import servlet.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmity on 27.10.15.
 */
public class Cart implements Command {
    ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }
}
