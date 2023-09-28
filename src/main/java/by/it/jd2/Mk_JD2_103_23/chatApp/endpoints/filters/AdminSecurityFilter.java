package by.it.jd2.Mk_JD2_103_23.chatApp.endpoints.filters;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.Role;
import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpRequest;

@WebServlet(urlPatterns = {"/api/admin/*", "/ui/admin/*"})
public class AdminSecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if ((session != null) && (session.getAttribute("user") != null)){
            User user = (User) session.getAttribute("user");
            if (user.getRole().equals(Role.ADMIN)){
                chain.doFilter(request, response);
            }
        }
        else{
            res.sendRedirect(contextPath + "/");
        }
    }
}
