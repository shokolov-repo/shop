package servlet.command;

import servlet.Command;
import view.ProductCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CostProductCart implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductCart> cart = (List<ProductCart>) req.getSession().getAttribute("cart");

        for (ProductCart productCart : cart) {
            if (productCart.getId() == Long.valueOf(req.getParameter("id"))) {
                productCart.setQuantity(Integer.valueOf(req.getParameter("val")));
            }
        }
        req.getSession().setAttribute("cart", cart);
        req.getRequestDispatcher("dispatcher?command=cart").forward(req, resp);

    }
}
