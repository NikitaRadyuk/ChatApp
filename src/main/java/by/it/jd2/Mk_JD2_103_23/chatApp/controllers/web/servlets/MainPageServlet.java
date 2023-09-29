package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.servlets;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.exceptions.ValidationException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(urlPatterns = "/ui/", loadOnStartup = 1)
public class MainPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        

        req.getRequestDispatcher("/ui/index.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        try {
            if (req.getParameter("Login") != null) {
                resp.sendRedirect(req.getContextPath() + "/api/login");
            } else if (req.getParameter("Registration") != null) {
                resp.sendRedirect(req.getContextPath() + "/api/reg");
            }
        }catch (IllegalArgumentException e){
            resp.setStatus(500);
            resp.getWriter().write(e.getMessage());
        } catch (ValidationException e){
            resp.setStatus(400);
            resp.getWriter().write(e.getMessage());
        }
    }
}
