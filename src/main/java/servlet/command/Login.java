package servlet.command;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.Product;
import entity.User;
import org.apache.log4j.Logger;
import servlet.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dmity on 21.10.15.
 */
public class Login implements Command {
    Logger logger = Logger.getLogger(Login.class);
    UserDAO userDAO = new UserDAOImpl();

    @Override

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        User user = userDAO.findByEmail(email);

        if (user != null && user.getPassword().equals(req.getParameter("password"))) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            switch (user.getRole()) {
                case "customer":
                    List<Product> cart = new LinkedList<>();
                    req.getSession().setAttribute("cart", cart);
                    resp.sendRedirect("dispatcher?command=indexPage");
                    break;
                case "seller":
                    resp.sendRedirect("dispatcher?command=sellerPage");
                    break;
                case "admin":
                    resp.sendRedirect("dispatcher?command=adminPage");
                    break;
            }
        } else {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
