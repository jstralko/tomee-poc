package local.gerb;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class HelloServlet extends HttpServlet {

    @EJB
    Hello hello;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            hello.sendJMS("Ground control to Major Tom?");
            hello.sendMessageToTopic("Ground control to Major Tom? (Topic)");
            hello.storeValue();
        } catch (Exception e) {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw, true);
                e.printStackTrace(pw);
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, sw.toString());
            }
        }
}
