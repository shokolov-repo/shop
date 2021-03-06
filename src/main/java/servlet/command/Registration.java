package servlet.command;

import dao.UserDao;
import dao.impl.jdbc.UserDaoImpl;
import entity.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.log4j.Logger;
import servlet.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmity on 21.10.15.
 */
public class Registration implements Command {
    private final String PHONE_REGEX = "\\d{3}-\\d{3}-\\d{2}-\\d{2}";
    private final String NAME_REGEX = "[a-zA-Z]*";
    Logger logger = Logger.getLogger(Registration.class);
    private UserDao userDao = new UserDaoImpl();

    @Override

    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> errors = validate(req);
        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setAddress(req.getParameter("address"));
        user.setPhone(req.getParameter("phone"));
        user.setEmail(req.getParameter("email"));

        if (errors.size() > 0) {
            req.setAttribute("user", user);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);
        } else {
            user.setPassword(req.getParameter("password1"));
            user.setRole("customer");
            userDao.create(user);
            req.getRequestDispatcher("dispatcher?command=indexPage").forward(req, resp);
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
        if (StringUtils.isBlank(req.getParameter("password1"))) {
            errors.put("password1", "Password field is required. Please enter value.");
        }
        if (StringUtils.isBlank(req.getParameter("password2"))) {
            errors.put("password2", "Password field is required. Please enter value.");
        }
        if (!req.getParameter("password1").equals(req.getParameter("password2"))) {
            errors.put("password", "Passwords don't matches.");
        }
        if (!EmailValidator.getInstance().isValid(req.getParameter("email"))) {
            errors.put("email", "Wrong e-mail format.");
        }
        if (StringUtils.isBlank(req.getParameter("email"))) {
            errors.put("email", "Email field is required. Please enter value.");
        } else if (userDao.findByEmail(req.getParameter("email")) != null) {
            errors.put("email", "This email is used.");
        }
        if (StringUtils.isNotBlank(req.getParameter("phone")) && !req.getParameter("phone").matches(PHONE_REGEX)) {
            errors.put("phone", "Enter a correct phone number to format 123-456-78-90.");
        }
        return errors;
    }

}
