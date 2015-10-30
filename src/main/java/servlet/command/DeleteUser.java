package servlet.command;

import dao.CommentDAO;
import dao.UserDAO;
import dao.impl.CommentDAOImpl;
import dao.impl.UserDAOImpl;
import entity.User;
import servlet.Command;
import servlet.CommandMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmity on 25.10.15.
 */
public class DeleteUser implements Command {
    UserDAO userDAO = new UserDAOImpl();
    CommentDAO commentDAO = new CommentDAOImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String id = req.getParameter("id");
        long userId = Long.valueOf(id);

        if (user.getId() != userId) {
            commentDAO.delete(userId);
            userDAO.delete(userId);
        } else {
            req.setAttribute("error","admin can not be deleted");
        }
        CommandMap.getCommand("adminPage").execute(req, resp);
    }
}
