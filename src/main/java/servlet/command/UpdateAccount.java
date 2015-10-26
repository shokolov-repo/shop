package servlet.command;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmity on 22.10.15.
 */
public class UpdateAccount implements Command {
    UserDAO userDAO = new UserDAOImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = userDAO.findByEmail(email);

        if (firstName != null) {
            user.setFirstName(firstName);
        }
        if (lastName != null) {
            user.setFirstName(lastName);
        }
        if (address != null) {
            user.setFirstName(address);
        }
        if (phone != null) {
            user.setFirstName(phone);
        }
        if (email != null) {
            user.setFirstName(email);
        }
        if (password != null) {
            user.setFirstName(password);
        }
        userDAO.update(user);
        req.getRequestDispatcher("/customerPage.jsp").forward(req, resp);
    }
}
