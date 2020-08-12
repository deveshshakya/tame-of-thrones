package com.geektrust.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides two public function to get a file as String,
 * to get a file's content as list of strings.
 *
 * @author dshakya29
 * @version 1.0
 */
public class FileUtility {

  /**
   * Reads a file, return its content.
   *
   * @param filePath Path to file, can be absolute or relative.
   * @return String, Content of file. Encoded in UTF-8
   */
  public static String fileToString(String filePath) throws IOException {
    Charset encoding = Charset.defaultCharset(); // Getting default encoding.
    byte[] encoded = Files.readAllBytes(Paths.get(filePath)); // Reading all bytes.
    return new String(encoded, encoding); // Returning string.
  }

  /**
   * Reads a file, return its content as list..
   *
   * @param filePath Path to file, can be absolute or relative.
   * @return List of string.
   */
  public static List<String> getInputLinesAsList(String filePath) throws IOException {
    List<String> inputLines = new ArrayList<>();
    BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
    String line;
    while ((line = bufferedReader.readLine()) != null) { // Taking line by line data.
      inputLines.add(line);
    }
    return inputLines;
  }
}
