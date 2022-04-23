package controllers.web.filters;

import controllers.web.servlets.api.LoginInServlet;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.api.usersStorage.UsersStorage;

@WebFilter (urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminSecurityFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse resp = (HttpServletResponse) servletResponse;
    String ContextPath = req.getContextPath();
    HttpSession session = req.getSession();
    if((session != null) && (session.getAttribute(LoginInServlet.getSESSION_ATTRIBUTE_NAME()) != null)) {
      req.setCharacterEncoding("UTF-8");
      if(req.getSession().getAttribute(LoginInServlet.getSESSION_ATTRIBUTE_NAME())
              .equals(UsersStorage.getInstance().getAdminUser())) {
        filterChain.doFilter(servletRequest, servletResponse);
      } else resp.sendRedirect(ContextPath + "/ui/signIn");
    } else {
      resp.sendRedirect(ContextPath + "/ui/signIn");
    }
  }

  @Override
  public void destroy() {

  }
}
