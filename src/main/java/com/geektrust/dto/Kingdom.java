package com.geektrust.dto;

import java.util.Objects;

public class Kingdom {
  private final String kingdomName;
  private final String emblem;
  private final String encryptedEmblem;

  public Kingdom(String kingdomName, String emblem, String encryptedEmblem) {
    this.kingdomName = kingdomName;
    this.emblem = emblem;
    this.encryptedEmblem = encryptedEmblem;
  }

  public String getKingdomName() {
    return kingdomName;
  }

  public String getEncryptedEmblem() {
    return encryptedEmblem;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Kingdom kingdom = (Kingdom) o;
    return kingdomName.equals(kingdom.kingdomName) &&
        emblem.equals(kingdom.emblem) &&
        encryptedEmblem.equals(kingdom.encryptedEmblem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kingdomName, emblem, encryptedEmblem);
  }

  @Override
  public String toString() {
    return "Kingdom{" +
        "kingdomName='" + kingdomName + '\'' +
        ", emblem='" + emblem + '\'' +
        ", encryptedEmblem='" + encryptedEmblem + '\'' +
        '}';
  }
}
