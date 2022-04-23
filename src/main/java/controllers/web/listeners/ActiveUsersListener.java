package controllers.web.listeners;

import controllers.web.servlets.api.LoginInServlet;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import service.api.usersStorage.UsersStorage;

@WebListener
public class ActiveUsersListener implements HttpSessionAttributeListener {

  private static int activeUsers;

  public static int getActiveUsers() {
    return activeUsers;
  }

  @Override
  public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
    Object user = httpSessionBindingEvent.getSession()
                 .getAttribute(LoginInServlet.getSESSION_ATTRIBUTE_NAME());
    if (user != null) {
      activeUsers++;
    }
  }

  @Override
  public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
  }

  @Override
  public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

  }
}
