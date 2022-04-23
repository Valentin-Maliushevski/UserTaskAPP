package controllers.web.servlets.api;

import core.dto.RoleType;
import core.dto.User;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.api.usersStorage.UsersStorage;

@WebServlet (name = "LoginUpServlet", urlPatterns = "/api/user")
public class LoginUpServlet extends HttpServlet {

  private static final String REQUEST_LOGIN = "login";
  private static final String REQUEST_PASSWORD = "password";
  private static final String REQUEST_FIO = "fio";
  private static final String REQUEST_BIRTHDAY = "birthday";

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    req.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset=UTF-8");

    String contextPath = req.getContextPath();

    String login = req.getParameter(REQUEST_LOGIN);
    String password = req.getParameter(REQUEST_PASSWORD);
    String fio = req.getParameter(REQUEST_FIO);
    String birthday = req.getParameter(REQUEST_BIRTHDAY);

    User user = new User(login, password, fio, LocalDate.parse(birthday), RoleType.getRole("OtherUser"));

    try {
      boolean isExist =  UsersStorage.getInstance().checkLoginAndPassword(user.getLogin(), user.getPassword());
      if(!isExist) {
        UsersStorage.getInstance().saveUser(user);
        resp.sendRedirect(  contextPath + "/ui/signIn");
      } else resp.sendRedirect(  contextPath + "/ui/signIn");

    } catch (IllegalArgumentException e) {
      resp.sendError(400, e.getMessage());
      return;
    } catch (IllegalStateException e) {
      resp.sendError(500, e.getMessage());
      return;
    }
  }
}
