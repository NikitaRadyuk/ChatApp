package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Класс-фильтр для проверки, авторизирован ли пользователь
 */
@WebFilter(urlPatterns = {"/ui/users/*", "/api/message"})
public class UserSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if (session == null) {
            res.sendRedirect(contextPath + "/api/reg");
        }
        if ((session != null) && (session.getAttribute("user") != null)) {
            filterChain.doFilter(request, response);
        } else {
            res.sendRedirect(contextPath + "/api/");
        }

    }
}
