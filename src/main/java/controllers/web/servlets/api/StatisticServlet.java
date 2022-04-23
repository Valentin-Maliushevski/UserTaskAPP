package controllers.web.servlets.api;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.api.Statistic;

@WebServlet (name = "StatisticServlet", urlPatterns = "/api/admin/statistics")
public class StatisticServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setAttribute("ActiveUsers", Statistic.getActiveUsers());
    req.setAttribute("UsersCount", Statistic.getAllUsersCount());
    req.setAttribute("MessagesCount", Statistic.getAllMessagesCount());
    req.getRequestDispatcher("/jsp/AdminStatistics.jsp").forward(req, resp);
  }
}
