package servlet.command;

import dao.UserDAO;
import dao.impl.UserDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmity on 25.10.15.
 */
public class ReplaceRole implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = (long) req.getAttribute("order.id");
        UserDAO userDAO = new UserDAOImpl();
        userDAO.findById(id);
    }
}
