package com.geektrust.dto;

import java.util.Objects;

public class Message {
  Kingdom receiver;
  String message;

  public Message() {
  }

  public Kingdom getReceiver() {
    return receiver;
  }

  public void setReceiver(Kingdom receiver) {
    this.receiver = receiver;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Message message1 = (Message) o;
    return Objects.equals(receiver, message1.receiver) &&
        Objects.equals(message, message1.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(receiver, message);
  }

  @Override
  public String toString() {
    return "Message{" +
        "receiver=" + receiver +
        ", message='" + message + '\'' +
        '}';
  }
}
