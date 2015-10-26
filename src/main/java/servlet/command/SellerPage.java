package servlet.command;

import dao.OrderDAO;
import dao.impl.OrderDAOImpl;
import entity.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dmity on 24.10.15.
 */
public class SellerPage implements Command {
    private OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderDAO.findAll();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/sellerPage.jsp").forward(req, resp);
    }
}
