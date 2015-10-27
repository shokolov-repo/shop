package servlet.command;

import entity.Order;
import entity.Product;
import servlet.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dmity on 21.10.15.
 */
public class Buy implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        Product product = (Product) req.getAttribute("product");
        Order order = new Order();
        order.setStatus("");
//        order.setDateOrder();

    }
}
