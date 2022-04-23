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

@WebFilter (urlPatterns = {"/ui/user/*", "/api/message"})
public class UserSecurityFilter implements Filter {


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
      filterChain.doFilter(servletRequest, servletResponse);
    } else {
      resp.sendRedirect(ContextPath + "/ui/signIn");
    }
  }

  @Override
  public void destroy() {
  }
}
