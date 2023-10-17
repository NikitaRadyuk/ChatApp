package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.servlets.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.CredentialsDTO;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserLoginService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.factory.UserLoginServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Класс-сервлет для авторизации пользователя
 */
@WebServlet(name="ApiLoginServlet", urlPatterns = "/api/login")
public class APILoginServlet extends HttpServlet {
    private static final String USER_PARAM_LOGIN = "login";
    private static final String USER_PARAM_PASSWORD = "password";

    private final IUserLoginService userLoginService = UserLoginServiceFactory.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter(USER_PARAM_LOGIN);
        String password = req.getParameter(USER_PARAM_PASSWORD);

        try{
            User user = this.userLoginService.login(new CredentialsDTO(login, password));
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/");
        }catch(IllegalArgumentException e){
            req.setAttribute("error", true);
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("/ui/signIn.jsp").forward(req,resp);
        }
    }
}

