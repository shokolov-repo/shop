package servlet.command;

import entity.Order;
import servlet.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dmity on 23.10.15.
 */
public class FindAllOrders implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Order> orders = ORDER_DAO.findAll();
//
//        if (orders.size() > 0) {
//            req.setAttribute("orders", orders);
//            req.getRequestDispatcher("/seller.jsp").forward(req, resp);
//        } else {
//            req.getRequestDispatcher("/seller.jsp").forward(req, resp);
//        }
    }
}