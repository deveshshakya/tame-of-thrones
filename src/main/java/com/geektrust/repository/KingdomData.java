package com.geektrust.repository;

import java.util.HashMap;
import java.util.Map;

public class KingdomData {
  private final Map<String, String> kingdomWithEmblems;

  public KingdomData() {
    this.kingdomWithEmblems = new HashMap<>();
    initializeKingdomMap();
  }

  public Map<String, String> getKingdomWithEmblems() {
    return this.kingdomWithEmblems;
  }

  /**
   * This function will add initial kingdoms in the map.
   * It is hard-coded as some kingdoms are known before hand.
   */
  private void initializeKingdomMap() {
    addKingdom("SPACE", "GORILLA");
    addKingdom("LAND", "PANDA");
    addKingdom("ICE", "MAMMOTH");
    addKingdom("AIR", "OWL");
    addKingdom("WATER", "OCTOPUS");
    addKingdom("FIRE", "DRAGON");
  }

  /**
   * This function will add a kingdom in the current rulers list.
   * @param kingdomName kingdom name to be added.
   * @param emblemName corresponding emblem name.
   */
  public void addKingdom(String kingdomName, String emblemName) {
    getKingdomWithEmblems().put(kingdomName, emblemName);
  }

  /**
   * This function will remove the kingdom from current rulers list.
   * @param kingdomName kingdom name which need to be removed.
   */
  public void removeKingdom(String kingdomName) {
    getKingdomWithEmblems().remove(kingdomName);
  }
}
