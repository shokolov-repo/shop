package servlet.command;


import dao.UserDao;
import dao.impl.jdbc.UserDaoImpl;
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
    UserDao userDAO = new UserDaoImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userDAO.findAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/adminPage.jsp").forward(req, resp);
    }
}
