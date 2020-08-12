package com.geektrust.alliance;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * This class contains alliances of "SPACE" kingdom.
 * */
public class Alliance {
  private int minimumRequiredAllies = 3;
  // Using LinkedHashSet to keep order and to contain unique kingdom.
  Set<String> allies;
  private int currentAlliesCount;

  public Alliance() {
    this.currentAlliesCount = 0;
    this.allies = new LinkedHashSet<>();
    getAllies().add("SPACE");
  }

  public void setMinimumRequiredAllies(int minimumRequiredAllies) {
    this.minimumRequiredAllies = minimumRequiredAllies;
  }

  public int getMinimumRequiredAllies() {
    return minimumRequiredAllies;
  }

  public Set<String> getAllies() {
    return allies;
  }

  public void addAlly(String kingdomName) {
    if (getAllies().add(kingdomName)) {
      this.currentAlliesCount++;
    }
  }

  /**
   * This function will return ruler with it's allies.
   * @return String, it will be formatted, e.g. RULER ALLY1 ALLY2 ALLY3
   */
  public String getRulerAllies() {
    if (this.currentAlliesCount >= getMinimumRequiredAllies()) {
      return String.join(" ", getAllies());
    }
    return "NONE";
  }
}
