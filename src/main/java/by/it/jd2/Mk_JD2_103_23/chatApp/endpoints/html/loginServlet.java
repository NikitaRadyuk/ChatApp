package by.it.jd2.Mk_JD2_103_23.chatApp.endpoints.html;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.Credentials;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Сервлет, на который отправляются данные для входа при помощи POST запроса
 */
@WebServlet(urlPatterns = "/api/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Credentials credentials = new Credentials();
        credentials.setLogin(login);
        credentials.setPassword(password);
    }
}
