package servlet.command;

import org.apache.log4j.Logger;
import servlet.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmity on 21.10.15.
 */
public class Logout implements Command {
    Logger logger = Logger.getLogger(Logout.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("principal");
        req.getSession().removeAttribute("cart");
        req.getRequestDispatcher("dispatcher?command=indexPage").forward(req, resp);
    }
}

