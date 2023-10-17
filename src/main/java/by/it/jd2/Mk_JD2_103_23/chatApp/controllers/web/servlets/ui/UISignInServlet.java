package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.servlets.ui;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Класс-сервлет, который отображает страницу авторизации пользователя
 */
@WebServlet(urlPatterns = "/ui/signIn")
public class UISignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/ui/signIn.jsp").forward(req, resp);
    }
}
