package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.servlets.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.CredentialsDTO;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.core.exceptions.ValidationException;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserLoginService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.factory.UserLoginServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/api/login")
public class APILoginServlet extends HttpServlet {
    private static final String USER_PARAM_LOGIN = "login";
    private static final String USER_PARAM_PASSWORD = "password";

    private IUserLoginService userLoginService = UserLoginServiceFactory.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter(USER_PARAM_LOGIN);
        String password = req.getParameter(USER_PARAM_PASSWORD);

        CredentialsDTO credentialsDTO = new CredentialsDTO();

        credentialsDTO.setLogin(login);
        credentialsDTO.setPassword(password);

        try {
            User user = userLoginService.login(credentialsDTO);
            HttpSession session = req.getSession();
            session.setAttribute("user", user.getLogin());

            resp.sendRedirect(req.getContextPath() + "/api/message");
        }
        catch (IllegalArgumentException e){
            resp.setStatus(500);
            resp.getWriter().write(e.getMessage());
        }
        catch (ValidationException e){
            resp.setStatus(400);
            resp.getWriter().write(e.getMessage());
        }
    }
/*
    public static void saveSession(HttpServletRequest req, String key, String val) {
        HttpSession session = req.getSession();
        session.setAttribute(key, val);
    }*/
}

