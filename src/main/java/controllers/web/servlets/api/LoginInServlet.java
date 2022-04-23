package controllers.web.servlets.api;

import core.dto.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.api.usersStorage.UsersStorage;

@WebServlet (name = "LoginInServlet", urlPatterns = "/api/login")
public class LoginInServlet extends HttpServlet {

  private static final String REQUEST_LOGIN = "login";
  private static final String REQUEST_PASSWORD = "password";
  static final String SESSION_ATTRIBUTE_NAME = "user";

  private boolean isExist;

  public static String getSESSION_ATTRIBUTE_NAME() {
    return SESSION_ATTRIBUTE_NAME;
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset=UTF-8");

    String contextPath = req.getContextPath();

    String login = req.getParameter(REQUEST_LOGIN);
    String password = req.getParameter(REQUEST_PASSWORD);

    isExist = UsersStorage.getInstance().checkLoginAndPassword(login, password);

      if(isExist) {
        User activeUser = UsersStorage.getInstance().getUser(login);
        HttpSession session = req.getSession();
        session.setAttribute(SESSION_ATTRIBUTE_NAME, activeUser);
        resp.sendRedirect(contextPath + "/ui/user/choice");
      } else
        resp.sendRedirect(  contextPath + "/ui/signIn");
  }
}

