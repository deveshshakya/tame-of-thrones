package com.geektrust.util;

import java.util.HashMap;
import java.util.Map;

/**
 * This class contains public string utility and matching functions.
 *
 * @author dshakya29
 * @version 1.0
 */
public class StringUtil {

  /**
   * This function give a map or each character with it's occurrence.
   *
   * @param text String, whose map is char count is required.
   * @return Map<Character, Integer>, character with their count.
   */
  public static Map<Character, Integer> getCharCount(String text) {
    Map<Character, Integer> charCount = new HashMap<>();
    for (char c : text.toCharArray()) {
      charCount.put(c, charCount.getOrDefault(c, 0) + 1);
    }
    return charCount;
  }

  /**
   * Check whether small string is available in large string or not.
   *
   * @param largeText String in which other string need to found.
   * @param smallText String whose occurrence need to be find.
   * @return boolean result.
   */
  public static boolean matchCharsByCount(String largeText, String smallText) {
    if (largeText.length() < smallText.length()) {
      return false;
    }
    Map<Character, Integer> largeTextCount = getCharCount(largeText);
    Map<Character, Integer> smallTextCount = getCharCount(smallText);
    for (Map.Entry<Character, Integer> entrySet : smallTextCount.entrySet()) {
      if (!(largeTextCount.containsKey(entrySet.getKey()) &&
          (largeTextCount.get(entrySet.getKey()) >= entrySet.getValue()))) {
        return false;
      }
    }
    return true;
  }
}
