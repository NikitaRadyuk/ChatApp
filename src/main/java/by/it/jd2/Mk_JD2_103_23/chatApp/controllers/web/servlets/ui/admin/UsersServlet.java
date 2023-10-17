package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.servlets.ui.admin;

import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserRegService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.factory.UserRegServiceFactory;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * Класс-сервлет для отображения всех зарегистрированных пользователей(для Админа)
 */
@WebServlet(urlPatterns = "/admin/users")
public class UsersServlet extends HttpServlet {
    private final IUserRegService userRegService;

    public UsersServlet() {
        this.userRegService = UserRegServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        Collection<User> users = userRegService.getAllUsers();
        for (User user: users) {
            writer.println(user.toString());
        }
    }
}
