package servlet.command;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import servlet.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dmity on 25.10.15.
 */
public class AdminPage implements Command {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userDAO.findAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/adminPage.jsp").forward(req, resp);
    }
}
