package servlet.command;

import dao.OrderDao;
import dao.impl.jdbc.OrderDaoImpl;
import entity.Order;
import servlet.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmity on 29.10.15.
 */
public class EditStatus implements Command {
    OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.valueOf(req.getParameter("id"));
        Order order = orderDao.findById(id);
        if (order.getStatus().equals("check")) {
            order.setStatus("sold");
            orderDao.update(order);
        } else if (order.getStatus().equals("sold")) {
            order.setStatus("check");
            orderDao.update(order);
        }
        req.getRequestDispatcher("dispatcher?command=sellerPage").forward(req, resp);
    }
}
