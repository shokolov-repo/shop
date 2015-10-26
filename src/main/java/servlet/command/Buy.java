package servlet.command;

import entity.Order;
import entity.Product;
import servlet.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.SimpleDateFormat;

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
