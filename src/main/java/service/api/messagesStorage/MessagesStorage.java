package service.api.messagesStorage;

import core.dto.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessagesStorage implements IMessagesStorage{
  private static class MessagesStorageHolder {
    private static final MessagesStorage MESSAGES_STORAGE_INSTANCE = new MessagesStorage();
  }

  public static MessagesStorage getInstance() {
    return MessagesStorageHolder.MESSAGES_STORAGE_INSTANCE;
  }

  public MessagesStorage() {
  }

  private static long allMessagesCount = 0;
  private static final Map<String, List<Message>> messageMap = new HashMap<>();

  public static long getAllMessagesCount() {
    return allMessagesCount;
  }

  @Override
  public synchronized void saveUserWithHisMessages (String userTo) {
    messageMap.put(userTo, new ArrayList<>());
  }

  @Override
  public synchronized void addMessage(String userTo, Message message) {
    messageMap.get(userTo).add(message);
    allMessagesCount++;

  }

  public static List<Message> getMessages(String userLogin) {
    return messageMap.get(userLogin);
  }

}
