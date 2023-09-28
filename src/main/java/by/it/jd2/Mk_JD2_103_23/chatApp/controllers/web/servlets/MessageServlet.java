package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.servlets;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.Message;
import by.it.jd2.Mk_JD2_103_23.chatApp.core.exceptions.ValidationException;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.MessageViewChatService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IMessageSendService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IMessageViewChatService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.factory.MessageSendServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

<<<<<<< HEAD:src/main/java/by/it/jd2/Mk_JD2_103_23/chatApp/controllers/web/servlets/MessageServlet.java
@WebServlet(urlPatterns = "api/message")
public class MessageServlet extends HttpServlet {
=======
@WebServlet(urlPatterns = "/api/message")
public class messageServlet extends HttpServlet {
>>>>>>> 067a2e7befcb178c6f3478d08a38b5973a45d849:src/main/java/by/it/jd2/Mk_JD2_103_23/chatApp/endpoints/html/messageServlet.java
    private static final String MESSAGE_PARAM_TO = "to";
    private static final String MESSAGE_PARAM_TEXT = "text";
    private static final String SESSION_PARAM_ATTRIBUTE_NAME = "user";

    private IMessageSendService messageSendService = MessageSendServiceFactory.getInstance();
    private IMessageViewChatService messageViewChatService = new MessageViewChatService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userFromSession = getValueFromSession(req, SESSION_PARAM_ATTRIBUTE_NAME);

        req.setAttribute("chat", this.messageViewChatService.viewChat(userFromSession));
        req.getRequestDispatcher("/ui/user/chats.jsp").forward(req, resp);
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
            messageSendService.send(message);
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
