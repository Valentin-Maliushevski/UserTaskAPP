package controllers.web.servlets.api;

import static service.api.messagesStorage.MessagesStorage.getMessages;

import core.dto.Message;
import core.dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.api.messagesStorage.MessagesStorage;

@WebServlet(name = "MessageServlet", urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {

  private static final String TO_USER = "toUser";
  private static final String TEXT = "text";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    User user = (User)req.getSession().getAttribute("user");

    resp.setContentType("text/html; charset=UTF-8");

    List<Message> messageList = getMessages(user.getLogin());
    List<String> chats = new ArrayList<>();

    for( Message message : messageList) {
      chats.add(message.toString());
    }

    req.setAttribute("chats", chats);
    req.getRequestDispatcher("/jsp/UserChats.jsp").forward(req, resp);

}

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    String toUserLogin = req.getParameter(TO_USER);
    String text = req.getParameter(TEXT);
    String contextPath = req.getContextPath();

    User fromUser = (User)req.getSession().getAttribute(LoginInServlet.getSESSION_ATTRIBUTE_NAME());

    Message message = new Message(fromUser.getLogin(), toUserLogin, text);

    try{
      MessagesStorage.getInstance().addMessage(toUserLogin, message);
      resp.sendRedirect(contextPath + "/ui/user/choice");
    }catch (IllegalArgumentException e) {
      resp.sendError(400, e.getMessage());
      return;
    } catch (IllegalStateException e) {
      resp.sendError(500, e.getMessage());
      return;
    }
  }
}
