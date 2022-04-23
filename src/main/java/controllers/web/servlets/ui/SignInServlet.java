package controllers.web.servlets.ui;

import controllers.web.servlets.api.LoginInServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SignInServlet", urlPatterns = "/ui/signIn")
public class SignInServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getRequestDispatcher("/jsp/SignIn.jsp").forward(req,resp);
  }
}
