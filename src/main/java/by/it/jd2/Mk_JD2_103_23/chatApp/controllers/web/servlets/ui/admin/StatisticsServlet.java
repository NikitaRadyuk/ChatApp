package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.servlets.ui.admin;

import by.it.jd2.Mk_JD2_103_23.chatApp.service.StatisticsService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IStatisticsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Класс-сервлет для просмотра статистики(для Админа)
 */
@WebServlet(urlPatterns = "/ui/admin/statistics")
public class StatisticsServlet extends HttpServlet {
    private final IStatisticsService statisticsService;

    public StatisticsServlet() {
        this.statisticsService = StatisticsService.getInstance();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        resp.setContentType("text/html; charset=utf-8");

        req.setAttribute("stats", statisticsService.getStats());

        req.getRequestDispatcher("/ui/admin/statistics.jsp").forward(req, resp);
    }
}
