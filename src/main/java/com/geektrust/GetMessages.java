package com.geektrust;

import com.geektrust.dto.Kingdom;
import com.geektrust.dto.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * This class is used to get messages, parsed from input lines.
 * return type: list of messages.
 */
public class GetMessages {
  List<Message> messageList;

  public GetMessages() {
    messageList = new ArrayList<>();
  }

  public List<Message> getMessagesAsList(Map<String, Kingdom> kingdoms, List<String> inputLines) {
    for (String inputLine : inputLines) { // Processing line by line input i.e. extracting info.
      Message message = new Message();
      List<String> data = Arrays.asList(inputLine.split(" ")); // Splitting string from space.
      String kingdomName = data.get(0); // Taking first string as kingdom name.
      message.setReceiver(kingdoms.get(kingdomName));
      StringBuilder stringBuilder = new StringBuilder();
      for (int j = 1; j < data.size(); j++) { // Taking rest string as a part of secret message.
        stringBuilder.append(data.get(j));
      }
      message.setMessage(stringBuilder.toString());
      messageList.add(message);
    }
    return messageList;
  }
}
