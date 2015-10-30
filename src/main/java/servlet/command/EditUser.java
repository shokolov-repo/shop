package servlet.command;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import servlet.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmity on 29.10.15.
 */
public class EditUser implements Command {
    UserDAO userDAO = new UserDAOImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userDAO.findById(Long.valueOf(req.getParameter("id")));
        req.setAttribute("user", user);
        req.getRequestDispatcher("/editUser.jsp").forward(req, resp);
    }
}
