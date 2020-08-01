package com.geektrust;

import com.geektrust.dto.Kingdom;
import com.geektrust.dto.Message;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This file contains main logic to solve the problem.
 * This file will create objects of other class to get relevant data.
 */
public class Solver {
  final String messageSender = "SPACE";

  GetKingdoms getKingdoms;
  GetMessages getMessages;

  Map<String, Kingdom> kingdomMap;
  List<Message> messageList;

  public Solver() {
    getKingdoms = new GetKingdoms();
    getMessages = new GetMessages();
  }

  public void init(List<String> inputLines) {
    kingdomMap = getKingdoms.getKingdomMapWithName();
    messageList = getMessages.getMessagesAsList(this.kingdomMap, inputLines);
  }

  /*
   * Singleton logic to find alliance.
   */
  private boolean checkCanBeAlliedOrNot(Message message) {
    String sentMessage = message.getMessage();
    Kingdom kingdom = message.getReceiver();
    return Verifier.matchCharsByCount(sentMessage, kingdom.getEncryptedEmblem());
  }

  private List<String> getAlliance() {
    Set<Kingdom> allies = new LinkedHashSet<>();
    allies.add(kingdomMap.get(this.messageSender));

    for (Message message : messageList) {
      if (checkCanBeAlliedOrNot(message)) {
        allies.add(message.getReceiver());
      }
    }
    // Getting kingdom names.
    return allies.stream().map(Kingdom::getKingdomName).collect(Collectors.toList());
  }

  public String printAlliances() {
    List<String> allies = getAlliance();
    StringBuilder output = new StringBuilder();

    // If allies are found, i.e count is >= 4.
    if (allies.size() >= 4) {
      for (int i = 0; i < 4; i++) {
        if (i == 3) {
          output.append(allies.get(i));
        } else {
          output.append(allies.get(i));
          output.append(" ");
        }
      }
    } else { // Else print None.
      output.append("NONE");
    }

    return output.toString();
  }
}
