package com.geektrust.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FileUtilityTest {

  private final String FIXTURES = "src/test/resources/input/input1.txt";

  @Test
  public void fileToStringShouldGiveCorrectContent() throws IOException {
    String expected = "AIR ROZO\n" +
        "LAND FAIJWJSOOFAMAU\n" +
        "ICE STHSTSTVSASOS";

    String output = FileUtility.fileToString(FIXTURES);
    assertEquals(expected, output);
  }

  @Test
  public void getInputLinesAsListShouldGiveCorrectContent() throws IOException {
    List<String> expected = new ArrayList<>();
    expected.add("AIR ROZO");
    expected.add("LAND FAIJWJSOOFAMAU");
    expected.add("ICE STHSTSTVSASOS");

    List<String> output = FileUtility.getInputLinesAsList(FIXTURES);
    assertEquals(expected.toString(), output.toString());
  }
}