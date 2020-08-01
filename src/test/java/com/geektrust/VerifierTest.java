package com.geektrust;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VerifierTest {

  @Test
  public void checkGetCharCount() {
    final String text1 = "HelloWorld";
    final String text2 = "WorldHello";

    Map<Character, Integer> characterIntegerMap = Verifier.getCharCount(text1);

    // 7 is count of unique char in text.
    assertEquals(7, characterIntegerMap.size());
    assertEquals(characterIntegerMap, Verifier.getCharCount(text2));
  }

  @Test
  public void matchCharsByCountShouldReturnFalse() {
    String largeText = "FAIJWJSOOFAMAU";
    String smallText = "ROZO";

    assertFalse(Verifier.matchCharsByCount(largeText, smallText));
  }

  @Test
  public void matchCharsByCountShouldReturnTrue() {
    String largeText = "FAIJJSOOFURZ";
    String smallText = "ROZO";

    assertTrue(Verifier.matchCharsByCount(largeText, smallText));
  }
}