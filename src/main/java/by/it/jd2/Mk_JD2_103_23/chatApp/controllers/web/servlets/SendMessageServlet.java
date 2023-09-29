package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.servlets.MessageServlet.getValueFromSession;

@WebServlet(urlPatterns = "/api/sendMessage")
public class SendMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/ui/user/message.jsp").forward(req, resp);
    }
}
