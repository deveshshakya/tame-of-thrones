package com.geektrust.dto;

import com.geektrust.cypher.Encryptor;
import com.geektrust.util.StringUtil;

/**
 * Kingdom class i.e contains all information about a kingdom.
 * Properties: Name, emblem, encrypted emblem, messageReceived.
 */
public class Kingdom {
  private final String kingdomName;
  private final String emblem;
  private String encryptedEmblem;
  private String messageReceived;

  public Kingdom(String kingdomName, String emblem) {
    this.kingdomName = kingdomName;
    this.emblem = emblem;
    encryptEmblem();
  }

  public String getKingdomName() {
    return kingdomName;
  }

  public String getEmblem() {
    return emblem;
  }

  public String getEncryptedEmblem() {
    return encryptedEmblem;
  }

  public void setEncryptedEmblem(String encryptedEmblem) {
    this.encryptedEmblem = encryptedEmblem;
  }

  public String getMessageReceived() {
    return messageReceived;
  }

  public void setMessageReceived(String messageReceived) {
    this.messageReceived = messageReceived;
  }

  /**
   * This function encrypt the emblem for further checking using Encryptor class.
   */
  private void encryptEmblem() {
    setEncryptedEmblem(Encryptor.getEncryptedMessage(getEmblem(),
        getEmblem().length()));
  }

  /**
   * This function checks the message if it contains emblem or not.
   */
  public boolean canBeAllied() {
    return StringUtil.matchCharsByCount(getMessageReceived(),
        getEncryptedEmblem());
  }
}
