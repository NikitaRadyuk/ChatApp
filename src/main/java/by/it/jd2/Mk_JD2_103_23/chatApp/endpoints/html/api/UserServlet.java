package by.it.jd2.Mk_JD2_103_23.chatApp.endpoints.html.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Сервлет, на который отправляются данные для регистрации при помощи POST запроса
 */
@WebServlet(urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String birthday = req.getParameter("birthday");


    }
}
