package com.geektrust;

import java.util.HashMap;
import java.util.Map;

/**
 * Class contains string matching and char count logic.
 */
public class Verifier {

  // Create a map of each char count.
  public static Map<Character, Integer> getCharCount(String text) {
    Map<Character, Integer> charCount = new HashMap<>();
    for (char c : text.toCharArray()) {
      charCount.put(c, charCount.getOrDefault(c, 0) + 1);
    }
    return charCount;
  }

  // Check whether small string is available in large string or not.
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
