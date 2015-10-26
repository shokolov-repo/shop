package servlet.command;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmity on 25.10.15.
 */
public class DeleteUser implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getAttribute("user");
        UserDAO userDAO = new UserDAOImpl();
        userDAO.delete(user.getId());
    }
}
