package servlet.command;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import servlet.Command;
import servlet.CommandMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmity on 29.10.15.
 */
public class CreateUser implements Command {
    UserDAO userDAO = new UserDAOImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setAddress(req.getParameter("address"));
        user.setPhone(req.getParameter("phone"));
        user.setEmail(req.getParameter("email"));
        user.setRole(req.getParameter("role"));
        user.setPassword(req.getParameter("password"));

        if (user.getEmail() != null && user.getPassword() != null && userDAO.findByEmail((user.getEmail())) == null) {
            userDAO.create(user);
        } else {
            req.setAttribute("error", "this email used");
            req.getRequestDispatcher("/createUser.jsp").forward(req, resp);
        }
        CommandMap.getCommand("adminPage").execute(req, resp);
    }

}

