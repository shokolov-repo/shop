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
public class Edit implements Command {
    UserDAO userDAO = new UserDAOImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        User user = new User();
        user.setId(Long.valueOf(req.getParameter("id")));

        if (!firstName.equals("")) {
            user.setFirstName(firstName);
        }
        if (!lastName.equals("")) {
            user.setLastName(lastName);
        }
        if (!address.equals("")) {
            user.setAddress(address);
        }
        if (!phone.equals("")) {
            user.setPhone(phone);
        }
        if (!email.equals("")) {
            user.setEmail(email);
        }
        if (!password.equals("")) {
            user.setPassword(password);
        }
        if (!role.equals("")) {
            user.setRole(role);
        }
        try {
            userDAO.update(user);
            req.setAttribute("error", "user was edit");
            CommandMap.getCommand("adminPage").execute(req, resp);
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", "this email used");
        }
        req.getRequestDispatcher("/editUser.jsp").forward(req, resp);
    }
}
