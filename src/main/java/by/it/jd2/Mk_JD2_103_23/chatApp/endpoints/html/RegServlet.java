package by.it.jd2.Mk_JD2_103_23.chatApp.endpoints.html;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.core.exceptions.ValidationException;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.UserRegService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserRegService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Сервлет, на который отправляются данные при регистрации при помощи POST запроса
 */
@WebServlet(urlPatterns = "/api/registration")
public class RegServlet extends HttpServlet {

    private static final String USER_PARAM_NAME = "username";
    private static final String USER_PARAM_LOGIN = "login";
    private static final String USER_PARAM_PASSWORD = "password";
    private static final String USER_PARAM_BIRTHDAY = "birthday";

    private IUserRegService userRegService = new UserRegService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        req.setCharacterEncoding("UTF-8");


        String username = req.getParameter(USER_PARAM_NAME);
        String login = req.getParameter(USER_PARAM_LOGIN);
        String password = req.getParameter(USER_PARAM_PASSWORD);
        String birthday = req.getParameter(USER_PARAM_BIRTHDAY);

        User user = new User(login, password, username, LocalDate.parse(birthday));

        try {
            userRegService.save(user);


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
}

//дополнить блок try{}
