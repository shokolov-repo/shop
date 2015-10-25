package servlet.command;

import entity.User;
import servlet.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmity on 22.10.15.
 */
public class UpdAcc implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

//        User user = CUSTOMER_DAO.findByEmail(email);
//
//        if (firstName != null) {
//            user.setFirstName(firstName);
//        }
//        if (lastName != null) {
//            user.setFirstName(lastName);
//        }
//        if (address != null) {
//            user.setFirstName(address);
//        }
//        if (phone != null) {
//            user.setFirstName(phone);
//        }
//        if (email != null) {
//            user.setFirstName(email);
//        }
//        if (password != null) {
//            user.setFirstName(password);
//        }
//        CUSTOMER_DAO.update(user);
//        req.getRequestDispatcher("/user.jsp").forward(req, resp);
    }
}
