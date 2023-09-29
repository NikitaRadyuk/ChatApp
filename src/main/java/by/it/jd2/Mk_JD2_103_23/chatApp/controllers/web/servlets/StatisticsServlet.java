package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.servlets;

import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IAdminService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.factory.AdminServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {
    private IAdminService adminService = AdminServiceFactory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("messages", this.adminService.getMessageCount());
        req.setAttribute("activeUsers", this.adminService.getActiveUsers());

        req.getRequestDispatcher("/ui/admin/statistics.jsp").forward(req, resp);
    }
}
