package servlet.command;

import entity.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmity on 21.10.15.
 */
public class Registration implements Command {
    Logger logger = Logger.getLogger(Registration.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setAddress(req.getParameter("address"));
        user.setPhone(req.getParameter("phone"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
//        if (user.getEmail() != null && user.getPassword() != null) {
//            CUSTOMER_DAO.create(user);
//        }
//        if (CUSTOMER_DAO.findByEmail(req.getParameter("email")).getEmail().equals(user.getEmail())) {
//            logger.info("user was create" + user);
//            req.getRequestDispatcher("/login.jsp").forward(req, resp);
//        } else {
//            req.getRequestDispatcher("/registration.jsp").forward(req, resp);
//        }
    }
}
