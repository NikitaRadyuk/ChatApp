package by.it.jd2.Mk_JD2_103_23.chatApp.endpoints.html;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.Credentials;
import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.core.exceptions.ValidationException;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.UserLoginService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserLoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Сервлет, на который отправляются данные для входа при помощи POST запроса
 */
@WebServlet(urlPatterns = "/api/login")
public class loginServlet extends HttpServlet {

    private static final String USER_PARAM_LOGIN = "login";
    private static final String USER_PARAM_PASSWORD = "password";
    private static final String SESSION_PARAM_ATTRIBUTE_NAME = "user";

    private IUserLoginService userLoginService = new UserLoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*req.setAttribute("loggedUser", user);*/
        req.getRequestDispatcher("/ui/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter(USER_PARAM_LOGIN);
        String password = req.getParameter(USER_PARAM_PASSWORD);

        Credentials credentials = new Credentials();

        credentials.setLogin(login);
        credentials.setPassword(password);

        try {

            User user = userLoginService.login(credentials);
            saveSession(req, SESSION_PARAM_ATTRIBUTE_NAME, user.getUserName());
            req.getRequestDispatcher("/ui/user/chats.jsp").forward(req,resp);




            /*userLoginService.login(credentials);*/
            /*for (User user: userLoginService.getAllUsers()){
                if (user.getLogin().equals(login) && user.getPassword().equals(password)){

                    HttpSession session = req.getSession();
                    session.setAttribute("loggedInUser", user);
                    req.getRequestDispatcher(req.getContextPath() + "/api/message").forward(req,resp);
                    return;
                }
            }*/
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

    public static void saveSession(HttpServletRequest req, String key, String val) {
        HttpSession session = req.getSession();
        session.setAttribute(key, val);
    }
}
