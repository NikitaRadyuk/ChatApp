package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.servlets.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.UserCreateDTO;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.core.exceptions.ValidationException;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserRegService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.factory.UserRegServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/api/reg")
public class APIUserServlet extends HttpServlet {
    private static final String LOGIN_PARAM_NAME = "login";
    private static final String PASSWORD_PARAM_NAME = "password";
    private static final String FULL_USER_PARAM_NAME = "username";
    private static final String BIRTHDAY_PARAM_NAME = "birthday";

    private IUserRegService userRegService = UserRegServiceFactory.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter(LOGIN_PARAM_NAME);
        String password = req.getParameter(PASSWORD_PARAM_NAME);
        String username = req.getParameter(FULL_USER_PARAM_NAME);
        String birthday = req.getParameter(BIRTHDAY_PARAM_NAME);

        UserCreateDTO user = new UserCreateDTO();
        user.setLogin(login);
        user.setPassword(password);
        user.setFullname(username);
        user.setBirthday(LocalDate.parse(birthday));

        try{
            User signedUpUser = this.userRegService.sighUp(user);
            req.getSession().setAttribute("user", signedUpUser);
            req.getRequestDispatcher("/ui/sighIn.jsp").forward(req, resp);
        } catch (IllegalArgumentException e){
            resp.setStatus(500);
            resp.getWriter().write(e.getMessage());
        }
        catch (ValidationException e){
            resp.setStatus(400);
            resp.getWriter().write(e.getMessage());
        }
    }
}
