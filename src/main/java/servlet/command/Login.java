package servlet.command;

import dao.UserDao;
import dao.impl.jdbc.UserDaoImpl;
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
    private Logger logger = Logger.getLogger(Login.class);
    private UserDao userDAO = new UserDaoImpl();


    @Override

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        User user = userDAO.findByEmail(email);

        if (user != null && user.getPassword().equals(req.getParameter("password"))) {
            HttpSession session = req.getSession();
            session.setAttribute("principal", user);

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
            req.setAttribute("error", "wrong email or password");
            req.getRequestDispatcher("dispatcher?command=indexPage").forward(req, resp);
        }
    }
}
