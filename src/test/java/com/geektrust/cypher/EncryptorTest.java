package com.geektrust.cypher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EncryptorTest {

  @Test
  public void shouldGetEncryptedMessage() {
    final String message = "olwl";
    final String encryptedMessage = Encryptor.getEncryptedMessage(message, 3);

    assertEquals("rozo", encryptedMessage);
  }

  @Test
  public void shouldGetSameMessage() {
    final String message = "HelloWorld";
    final String encryptedMessage1 = Encryptor.getEncryptedMessage(message, 0);
    final String encryptedMessage2 = Encryptor.getEncryptedMessage(message, 26);
    final String encryptedMessage3 = Encryptor.getEncryptedMessage(message, 52);

    assertEquals(message, encryptedMessage1);
    assertEquals(message, encryptedMessage2);
    assertEquals(message, encryptedMessage3);
  }
}