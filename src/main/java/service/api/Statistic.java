package service.api;

import controllers.web.listeners.ActiveUsersListener;
import service.api.messagesStorage.MessagesStorage;
import service.api.usersStorage.UsersStorage;

public class Statistic {

  public static int getActiveUsers() {
    return ActiveUsersListener.getActiveUsers();
  }

  public static int getAllUsersCount() {
    return UsersStorage.getAllUsersCount();
  }

  public static long getAllMessagesCount() {
    return MessagesStorage.getAllMessagesCount();
  }

}
