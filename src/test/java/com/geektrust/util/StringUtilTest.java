package com.geektrust.util;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringUtilTest {

  @Test
  public void checkGetCharCount() {
    final String text1 = "HelloWorld";
    final String text2 = "WorldHello";
    final int COUNT = 7; // 7 is count of unique char in text.

    Map<Character, Integer> characterIntegerMap = StringUtil.getCharCount(text1);

    assertEquals(COUNT, characterIntegerMap.size());
    assertEquals(characterIntegerMap, StringUtil.getCharCount(text2));
  }

  @Test
  public void matchCharsByCountShouldReturnFalse() {
    String largeText = "FAIJWJSOOFAMAU";
    String smallText = "ROZO";

    assertFalse(StringUtil.matchCharsByCount(largeText, smallText));
  }

  @Test
  public void matchCharsByCountShouldReturnTrue() {
    String largeText = "FAIJJSOOFURZ";
    String smallText = "ROZO";

    assertTrue(StringUtil.matchCharsByCount(largeText, smallText));
  }
}