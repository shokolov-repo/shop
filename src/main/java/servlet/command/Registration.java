package servlet.command;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import org.apache.log4j.Logger;
import servlet.Command;
import servlet.CommandMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmity on 21.10.15.
 */
public class Registration implements Command {
    Logger logger = Logger.getLogger(Registration.class);
    UserDAO userDAO = new UserDAOImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setAddress(req.getParameter("address"));
        user.setPhone(req.getParameter("phone"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setRole("customer");

        if (userDAO.findByEmail((user.getEmail())) == null) {
            req.setAttribute("error", "Enter your email and password.");
            userDAO.create(user);
            CommandMap.getCommand("indexPage").execute(req, resp);
        }
        req.setAttribute("error", "this email used");
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }
}
