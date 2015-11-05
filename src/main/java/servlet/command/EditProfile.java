package servlet.command;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import org.apache.commons.lang3.StringUtils;
import servlet.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EditProfile implements Command {
    UserDAO userDAO = new UserDAOImpl();
    private final String PHONE_REGEX = "\\d{3}-\\d{3}-\\d{2}-\\d{2}";
    private final String NAME_REGEX = "[a-zA-Z]*";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> errors = validate(req);

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password1");

        User user = (User) req.getSession().getAttribute("principal");

        if (StringUtils.isNotBlank(firstName)) {
            user.setFirstName(firstName.trim());
        }
        if (StringUtils.isNotBlank(lastName)) {
            user.setLastName(lastName);
        }
        if (StringUtils.isNotBlank(address)) {
            user.setAddress(address);
        }
        if (StringUtils.isNotBlank(phone)) {
            user.setPhone(phone);
        }
        if (StringUtils.isNotBlank(password)) {
            user.setPassword(password);
        }

        if (errors.size() > 0) {
            req.setAttribute("user", user);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/editProfile.jsp").forward(req, resp);
        } else {
            userDAO.update(user);
            req.setAttribute("info", "Profile was edit.");
            req.getRequestDispatcher("dispatcher?command=customerPage").forward(req, resp);
        }
    }

    private Map<String, String> validate(HttpServletRequest req) {
        Map<String, String> errors = new HashMap<>();

        if (!req.getParameter("firstName").matches(NAME_REGEX)) {
            errors.put("firstName", "First Name can contain only letters.");
        }
        if (StringUtils.isBlank(req.getParameter("firstName"))) {
            errors.put("firstName", "First Name field is required. Please enter value.");
        }
        if (!req.getParameter("lastName").matches(NAME_REGEX)) {
            errors.put("lastName", "Last Name can contain only letters.");
        }
        if (StringUtils.isBlank(req.getParameter("password1")) & StringUtils.isNotBlank(req.getParameter("password2"))) {
            errors.put("password1", "Password Name field is required. Please enter value.");
        }
        if (StringUtils.isNotBlank(req.getParameter("password1")) & StringUtils.isBlank(req.getParameter("password2"))) {
            errors.put("password2", "Password Name field is required. Please enter value.");
        }
        if (StringUtils.isNotBlank(req.getParameter("password1")) && StringUtils.isNotBlank(req.getParameter("password2"))
                && !req.getParameter("password1").equals(req.getParameter("password2"))) {
            errors.put("password", "Passwords don't matches.");
        }
        if (StringUtils.isNotBlank(req.getParameter("phone")) && !req.getParameter("phone").matches(PHONE_REGEX)) {
            errors.put("phone", "Enter a correct phone number to format 123-456-78-90.");
        }

        return errors;
    }
}
