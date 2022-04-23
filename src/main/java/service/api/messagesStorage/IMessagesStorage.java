package service.api.messagesStorage;

import core.dto.Message;

public interface IMessagesStorage {
  void saveUserWithHisMessages (String userTo);
  void addMessage(String userTo, Message message);
}
