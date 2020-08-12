package com.geektrust;

import com.geektrust.alliance.Alliance;
import com.geektrust.dto.Kingdom;
import com.geektrust.repositoryservice.KingdomService;
import com.geektrust.util.FileUtility;

import java.io.IOException;
import java.util.Map;

public class GoldenCrownApplication {
  public static void main(String[] args) throws IOException {
    String pathToInput = args[0];

    KingdomService kingdomService = new KingdomService();
    Map<String, Kingdom> nameKingdomMap = kingdomService.getRulers();

    // This class contains alliances.
    Alliance alliance = new Alliance();
    alliance.setMinimumRequiredAllies(3); // Setting minimum allies to 3.

    // Getting input line by line to process.
    for (String line : FileUtility.getInputLinesAsList(pathToInput)) {
      String[] content = line.split(" ");
      String kingdomName = content[0];
      String message = getMessage(content);

      Kingdom kingdom = nameKingdomMap.get(kingdomName);
      kingdom.setMessageReceived(message);

      if (kingdom.canBeAllied()) { // Checking if current kingdom can be allied by sent message.
        alliance.addAlly(kingdom.getKingdomName()); // If true, add it to allied kingdoms.
      }
    }

    System.out.print(alliance.getRulerAllies()); // Printing final answer.
  }

  /**
   * Utility function which gets all remaining part of string as message.
   */
  private static String getMessage(String[] content) {
    StringBuilder message = new StringBuilder();
    for (int i = 1; i < content.length; i++) {
      if (i != content.length - 1) {
        message.append(content[i]);
        message.append(' ');
      } else {
        message.append(content[i]);
      }
    }
    return message.toString();
  }
}