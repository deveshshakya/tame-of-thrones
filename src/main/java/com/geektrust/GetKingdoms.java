package com.geektrust;

import com.geektrust.cypher.Encryptor;
import com.geektrust.dto.Kingdom;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to get Kingdoms, it is hard-coded i.e king-name and it's emblem is known before hand.
 */
public class GetKingdoms {
  private final HashMap<String, String> kingdomWithEmblems;
  private final Encryptor encryptor;
  Map<String, Kingdom> kingdoms;

  /**
   * Change this constructor to add more kingdoms and their emblems.
   */
  public GetKingdoms() {
    kingdomWithEmblems = new HashMap<>();

    kingdomWithEmblems.put("SPACE", "GORILLA");
    kingdomWithEmblems.put("LAND", "PANDA");
    kingdomWithEmblems.put("ICE", "MAMMOTH");
    kingdomWithEmblems.put("AIR", "OWL");
    kingdomWithEmblems.put("WATER", "OCTOPUS");
    kingdomWithEmblems.put("FIRE", "DRAGON");

    kingdoms = new HashMap<>();
    encryptor = new Encryptor();
  }

  public Map<String, Kingdom> getKingdomMapWithName() {
    for (Map.Entry<String, String> entrySet : kingdomWithEmblems.entrySet()) {
      String kingdomName = entrySet.getKey();
      String emblem = entrySet.getValue();
      int emblemLength = emblem.length();
      String encryptedMessage = encryptor.getEncryptedMessage(emblem, emblemLength);
      Kingdom kingdom = new Kingdom(kingdomName, emblem, encryptedMessage);
      kingdoms.putIfAbsent(kingdomName, kingdom);
    }
    return kingdoms;
  }
}
