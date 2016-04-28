package servlet.command;

import dao.OrderDao;
import dao.UserDao;
import dao.impl.jdbc.OrderDaoImpl;
import dao.impl.jdbc.UserDaoImpl;
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
    private UserDao userDAO = new UserDaoImpl();
    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = orderDao.findById(Long.valueOf(req.getParameter("id")));
        User customer = userDAO.findById(order.getUserId());
        req.setAttribute("customer", customer);
        req.getRequestDispatcher("/getCustomer.jsp").forward(req, resp);
    }
}
