package servlet.command;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import servlet.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmity on 29.10.15.
 */
public class CreateUser implements Command {
    UserDAO userDAO = new UserDAOImpl();
    private final String PHONE_REGEX = "\\d{3}-\\d{3}-\\d{2}-\\d{2}";
    private final String NAME_REGEX = "[a-zA-Z]*";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> errors = validate(req);

        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setAddress(req.getParameter("address"));
        user.setPhone(req.getParameter("phone"));
        user.setEmail(req.getParameter("email"));
        user.setRole(req.getParameter("role"));
        user.setPassword(req.getParameter("password"));

        if (errors.size() > 0) {
            req.setAttribute("user", user);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/createUser.jsp").forward(req, resp);
        } else {
            userDAO.create(user);
            req.getRequestDispatcher("dispatcher?command=adminPage").forward(req, resp);
        }
    }

    private Map<String, String> validate(HttpServletRequest req) {
        Map<String, String> errors = new HashMap<>();

        if (!req.getParameter("firstName").matches(NAME_REGEX)) {
            errors.put("firstName", "First Name can contain only letters.");
        }
        if (!req.getParameter("lastName").matches(NAME_REGEX)) {
            errors.put("lastName", "Last Name can contain only letters.");
        }
        if (StringUtils.isBlank(req.getParameter("firstName"))) {
            errors.put("firstName", "First Name field is required. Please enter value.");
        }
        if (StringUtils.isBlank(req.getParameter("password"))) {
            errors.put("password", "Password field is required. Please enter value.");
        }
        if (!EmailValidator.getInstance().isValid(req.getParameter("email"))) {
            errors.put("email", "Wrong e-mail format.");
        }
        if (StringUtils.isBlank(req.getParameter("email"))) {
            errors.put("email", "Email field is required. Please enter value.");
        } else if (userDAO.findByEmail(req.getParameter("email")) != null) {
            errors.put("email", "This email is used.");
        }
        if (StringUtils.isNotBlank(req.getParameter("phone")) && !req.getParameter("phone").matches(PHONE_REGEX)) {
            errors.put("phone", "Enter a correct phone number to format 123-456-78-90.");
        }
        return errors;
    }
}

