package servlet.command;

import dao.OrderDao;
import dao.impl.jdbc.OrderDaoImpl;
import entity.Order;
import entity.User;
import servlet.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dmity on 25.10.15.
 */
public class CustomerPage implements Command {
    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("principal");
        List<Order> orders = (List<Order>) orderDao.findAllByUserId(user.getId());
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/customerPage.jsp").forward(req, resp);

    }
}
