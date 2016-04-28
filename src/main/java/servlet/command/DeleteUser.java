package servlet.command;

import dao.UserDao;
import dao.impl.jdbc.UserDaoImpl;
import entity.User;
import servlet.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmity on 25.10.15.
 */
public class DeleteUser implements Command {
    private UserDao userDAO = new UserDaoImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("principal");
        long userId = Long.valueOf(req.getParameter("id"));

        if (user.getId() != userId) {
            userDAO.delete(userId);
        } else {
            req.setAttribute("error", "admin can not be deleted");
        }
        req.getRequestDispatcher("dispatcher?command=adminPage").forward(req, resp);
    }
}
