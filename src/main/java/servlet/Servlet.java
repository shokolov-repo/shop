package servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
    Logger logger = Logger.getLogger(Servlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        if (command != null) {
            CommandMap.getCommand(command).execute(req, resp);
        } else {
            req.getRequestDispatcher("dispatcher?command=indexPage").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        if (command != null) {
            CommandMap.getCommand(command).execute(req, resp);
        } else {
            req.getRequestDispatcher("dispatcher?command=indexPage").forward(req, resp);
        }
    }
}

