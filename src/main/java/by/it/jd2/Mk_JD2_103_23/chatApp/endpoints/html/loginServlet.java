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
    private IUserLoginService userLoginService = new UserLoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("username", userLoginService);

        req.getRequestDispatcher("/ui/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        /*Credentials credentials = new Credentials();

        credentials.setLogin(login);
        credentials.setPassword(password);*/

        try {
            /*userLoginService.login(credentials);*/
            for (User user: userLoginService.getAllUsers()){
                if (user.getLogin().equals(login) && user.getPassword().equals(password)){

                    HttpSession session = req.getSession();
                    session.setAttribute("loggedInUser", user);

                    resp.sendRedirect("");
                    return;
                }
            }

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
