package core.dto;

import java.time.LocalDateTime;

public class Message {

  private LocalDateTime sendTime;
  private final String messageFrom;
  private final String messageTo;
  private final String text;

  public Message(String messageFrom, String messageTo, String text) {
    this.messageFrom = messageFrom;
    this.messageTo = messageTo;
    this.text = text;
    this.sendTime = LocalDateTime.now();
  }

  public String getText() {
    return text;
  }

  @Override
  public String toString() {
    return "sendTime = " + sendTime + '\'' +
        ", messageFrom = " + messageFrom + '\'' +
        ", text='" + text + '\'';
  }
}
