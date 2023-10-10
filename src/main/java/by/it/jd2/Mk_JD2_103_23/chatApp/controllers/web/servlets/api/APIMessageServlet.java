package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.servlets.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.MessageCreateDTO;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.MessageService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IMessageService;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;
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

    private final IMessageService messageSendService;

    public APIMessageServlet(){
        this.messageSendService = MessageService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();

        User user = (User) session.getAttribute(SESSION_PARAM_ATTRIBUTE_NAME);

        String toUser = req.getParameter(MESSAGE_PARAM_TO);
        String messageText = req.getParameter(MESSAGE_PARAM_TEXT);

        MessageCreateDTO message = new MessageCreateDTO();
        message.setFrom(user.getLogin());
        message.setTo(toUser);
        message.setText(messageText);

        try {
            this.messageSendService.send(message);
            req.setAttribute("success", true);
        }
        catch (IllegalArgumentException e){
            req.setAttribute("error", true);
            req.setAttribute("message", e.getMessage());
        }
        req.getRequestDispatcher("/ui/user/message.jsp").forward(req, resp);
    }
}
