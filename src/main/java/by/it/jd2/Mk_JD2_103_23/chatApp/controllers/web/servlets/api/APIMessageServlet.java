package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.servlets.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.Message;
import by.it.jd2.Mk_JD2_103_23.chatApp.core.exceptions.ValidationException;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IMessageService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.factory.MessageServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(urlPatterns = "/api/message")
public class APIMessageServlet extends HttpServlet {

    private static final String MESSAGE_PARAM_TO = "to";
    private static final String MESSAGE_PARAM_TEXT = "text";
    private static final String SESSION_PARAM_ATTRIBUTE_NAME = "user";

    private IMessageService messageSendService;

    public APIMessageServlet(){
        this.messageSendService = MessageServiceFactory.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        req.setCharacterEncoding("UTF-8");

        String toUser = req.getParameter(MESSAGE_PARAM_TO);
        String messageText = req.getParameter(MESSAGE_PARAM_TEXT);
        String userFromSession = getValueFromSession(req, SESSION_PARAM_ATTRIBUTE_NAME);

        Message message = new Message();
        message.setFromUser(userFromSession);
        message.setToUser(toUser);
        message.setText(messageText);

        try {
            this.messageSendService.send(message);
        }
        catch (IllegalArgumentException e){
            resp.setStatus(500);
            resp.getWriter().write(e.getMessage());
        }
        catch (ValidationException e){
            resp.setStatus(400);
            resp.getWriter().write(e.getMessage());
        }
        req.getRequestDispatcher("/ui/user/message.jsp").forward(req, resp);
    }

    public static String getValueFromSession(HttpServletRequest req, String key) {
        String val = req.getParameter(key);

        if (val == null) {
            HttpSession session = req.getSession();
            if (!session.isNew()) {
                val = (String) session.getAttribute(key);
            }
        }
        return val;
    }
}