package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmity on 21.10.15.
 */
public interface Command {

    void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
