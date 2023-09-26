package by.it.jd2.Mk_JD2_103_23.chatApp.endpoints.html;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/ui/", loadOnStartup = 1)
public class mainPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("Login") != null) {
            String nextPage = "signIn.jsp";
            req.getRequestDispatcher(nextPage).forward(req, resp);
        } else if (req.getParameter("Registration") != null) {
            String nextPage = "signUp.jsp";
            req.getRequestDispatcher(nextPage).forward(req, resp);
        }
    }
}
