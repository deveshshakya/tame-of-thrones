package com.geektrust.repositoryservice;

import com.geektrust.dto.Kingdom;
import com.geektrust.repository.KingdomData;

import java.util.HashMap;
import java.util.Map;

public class KingdomService {
  private final KingdomData kingdomData;

  public KingdomService() {
    kingdomData = new KingdomData();
  }

  /**
   * This function will give kingdoms abject, from data.
   * @return Map<String, Kingdom> kingdom name with it's object.
   */
  public Map<String, Kingdom> getRulers() {
    Map<String, String> kingdomWithEmblems = kingdomData.getKingdomWithEmblems();
    Map<String, Kingdom> rulers = new HashMap<>();

    for (String kingdomName : kingdomWithEmblems.keySet()) {
      rulers.put(kingdomName,
          new Kingdom(kingdomName, kingdomWithEmblems.get(kingdomName)));
    }

    return rulers;
  }
}
