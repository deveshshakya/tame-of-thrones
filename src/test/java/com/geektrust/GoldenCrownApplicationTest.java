package com.geektrust;

import com.geektrust.util.FileUtility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GoldenCrownApplicationTest {
  private final String FIXTURES = "src/test/resources";

  private final ByteArrayOutputStream temporaryOutputStream = new ByteArrayOutputStream();
  private final PrintStream originalOutputStream = System.out;

  @BeforeEach
  public void changingStreamForTesting() {
    System.setOut(new PrintStream(temporaryOutputStream));
  }

  @AfterEach
  public void restoringStreamAfterTest() {
    System.setOut(new PrintStream(originalOutputStream));
  }

  @Test
  public void shouldGiveAllies() throws IOException {
    String expected = FileUtility.fileToString(FIXTURES + "/output/output1.txt");

    GoldenCrownApplication.main(new String[] {FIXTURES + "/input/input1.txt"});
    assertEquals(expected, temporaryOutputStream.toString());
  }

  @Test
  public void shouldGiveNone() throws IOException {
    String expected = FileUtility.fileToString(FIXTURES + "/output/output2.txt");

    GoldenCrownApplication.main(new String[] {FIXTURES + "/input/input2.txt"});
    assertEquals(expected, temporaryOutputStream.toString());
  }
}