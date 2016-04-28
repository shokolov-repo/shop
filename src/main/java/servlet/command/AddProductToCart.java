package servlet.command;

import dao.ProductDao;
import dao.impl.jdbc.ProductDaoImpl;
import entity.Product;
import servlet.Command;
import view.ProductCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dmity on 26.10.15.
 */
public class AddProductToCart implements Command {
    ProductDao productDao = new ProductDaoImpl();


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductCart> cart = (List<ProductCart>) req.getSession().getAttribute("cart");
        String id = req.getParameter("id");
        Product product = productDao.findById(Long.valueOf(id));

        ProductCart productCart = getProductCartById(cart, product.getId());
        if (productCart == null) {
            cart.add(new ProductCart(product));
//        } else {
//            productCart.setQuantity(productCart.getQuantity() + 1);
        }
        req.getSession().setAttribute("cart", cart);
        req.getRequestDispatcher("dispatcher?command=indexPage").forward(req, resp);
    }

    private ProductCart getProductCartById(List<ProductCart> cart, long id) {
        for (ProductCart productCart : cart) {
            if (productCart.getId() == id) {
                return productCart;
            }
        }
        return null;
    }
}
