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
 * Created by dmity on 25.10.15.
 */
public class CustomerPage implements Command {
    private OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<Order> orders = orderDAO.findAllByUserId(Long.valueOf(id));
        req.getSession().setAttribute("orders", orders);
        req.getRequestDispatcher("/customerPage.jsp").forward(req, resp);
    }
}
