package servlet;

import org.apache.log4j.Logger;
import servlet.command.Command;
import servlet.command.CommandMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmity on 20.10.15.
 */
public class Servlet extends HttpServlet {
    Logger logger = Logger.getLogger(Servlet.class);
    Command comm;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
//        if (command != null && command.equals("login")) {
//            String email = req.getParameter("email");
//            UserDAO customerDAO = new UserDAOImpl();
//            User customer = customerDAO.findByEmail(email);
//            if (customer != null && customer.getPassword().equals(req.getParameter("password"))) {
//                req.getRequestDispatcher("/userpage.jsp").forward(req, resp);
//            } else {
//                req.setAttribute("error", "wrong email or password");
//                req.getRequestDispatcher("/login.jsp").forward(req, resp);
//
//            }
//        }
//        req.setAttribute("email", servlet.command);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        if (command != null) {
            comm = CommandMap.getCommand(command);
            comm.execute(req, resp);
        } else {
            req.setAttribute("error", "wrong email or password");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);

        }
    }
}

