package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.servlets.ui;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Сервлет, на который отправляются данные при регистрации при помощи POST запроса
 */
@WebServlet(urlPatterns = "/ui/signUp")
public class UIRegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/ui/signUp.jsp").forward(req, resp);
    }
}
