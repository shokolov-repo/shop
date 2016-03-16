package servlet.command;

import dao.OrderDAO;
import dao.impl.OrderDAOImpl;
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
    OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.valueOf(req.getParameter("id"));
        Order order = orderDAO.findById(id);
        if (order.getStatus().equals("check")) {
            order.setStatus("sold");
            orderDAO.update(order);
        } else if (order.getStatus().equals("sold")) {
            order.setStatus("check");
            orderDAO.update(order);
        }
        req.getRequestDispatcher("dispatcher?command=sellerPage").forward(req, resp);
    }
}
