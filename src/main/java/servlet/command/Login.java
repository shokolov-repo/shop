package servlet.command;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmity on 21.10.15.
 */
public class Login implements Command {
    Logger logger = Logger.getLogger(Login.class);
    UserDAO userDAO = new UserDAOImpl();

    @Override

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        User user = userDAO.findByEmail(email);

        if (user == null) {
            new Logout().execute(req, resp);
        } else if (user.getPassword().equals(req.getParameter("password"))) {
            req.getRequestDispatcher("/user.jsp").forward(req, resp);
        } else {
            new Logout().execute(req, resp);
        }

    }
}
