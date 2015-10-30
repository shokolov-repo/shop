package servlet.command;

import dao.OrderDAO;
import dao.UserDAO;
import dao.impl.OrderDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Order;
import entity.User;
import servlet.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmity on 29.10.15.
 */
public class GetCustomer implements Command {
    UserDAO userDAO = new UserDAOImpl();
    OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = orderDAO.findById(Long.valueOf(req.getParameter("id")));
        User customer = userDAO.findById(order.getUserId());
        req.setAttribute("customer", customer);
        req.getRequestDispatcher("/getCustomer.jsp").forward(req, resp);
    }
}
