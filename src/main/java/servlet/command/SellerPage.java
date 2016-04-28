package servlet.command;

import dao.OrderDao;
import dao.impl.jdbc.OrderDaoImpl;
import entity.Order;
import servlet.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dmity on 24.10.15.
 */
public class SellerPage implements Command {
    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = (List<Order>) orderDao.findAll();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/sellerPage.jsp").forward(req, resp);
    }
}
