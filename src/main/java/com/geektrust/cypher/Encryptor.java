package com.geektrust.cypher;

/**
 * This class provides a function which can be used to Encrypt message.
 *
 * @author dshakya29
 * @version 1.0
 */
public class Encryptor {

  /**
   * This function encrypt a message using caesar-cypher.
   *
   * @param message Message to be encoded.
   * @param shift   Key, i.e by which char has to be shifted.
   * @return String encoded message.
   */
  public static String getEncryptedMessage(String message, int shift) {
    shift %= 26; // Getting modulo to avoid over shifting.
    StringBuilder encryptedMessage = new StringBuilder();
    char currentChar;
    for (int i = 0; i < message.length(); i++) {
      currentChar = message.charAt(i);
      // If alphabet lies between 'a' and 'z'
      if (currentChar >= 'a' && currentChar <= 'z') {
        // Shift alphabet
        currentChar = (char) (currentChar + shift);
        // If shifted alphabet greater than 'z'
        if (currentChar > 'z') {
          // Re-shift to starting position
          currentChar = (char) (currentChar + 'a' - 'z' - 1);
        }
        encryptedMessage.append(currentChar);
      } else if (currentChar >= 'A' && currentChar <= 'Z') {
        // Shift alphabet
        currentChar = (char) (currentChar + shift);
        // If shifted alphabet greater than 'Z'
        if (currentChar > 'Z') {
          // Re-shift to starting position
          currentChar = (char) (currentChar + 'A' - 'Z' - 1);
        }
        encryptedMessage.append(currentChar);
      } else { // If other chars are present
        encryptedMessage.append(currentChar);
      }
    }
    return encryptedMessage.toString();
  }
}
