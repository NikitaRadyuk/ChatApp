package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.servlets.ui;

import by.it.jd2.Mk_JD2_103_23.chatApp.service.MessageService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IMessageService;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.entity.Message;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

/**
 * Класс-сервлет для отображения сообщений, отправленных авторизированному пользователю
 */
@WebServlet(urlPatterns = "/ui/user/chats")
public class UIChatsServlet extends HttpServlet {
    private final IMessageService messageService;

    public UIChatsServlet(){
        this.messageService = MessageService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if(user == null){
            throw new SecurityException("Ошибка безопасности");
        }

        List<Message> messages = this.messageService.getAllMessages(user);

        req.setAttribute("chat", messages);
        req.getRequestDispatcher("/ui/user/chats.jsp").forward(req, resp);
    }
}
