package xyz.paradoxv5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.RepeatedTest;
import java.util.TreeSet;

public final class SevenBagTest {
  
  @RepeatedTest(3) public void test_get_everyPiece() {
    SevenBag sevenBag = new SevenBag();
    TreeSet<SevenBag.Tetromino> testSet = new TreeSet<>();
    for(byte c = 0; c < 7; ++c)
      testSet.add(sevenBag.get());
    assertEquals(SevenBag.Tetromino.SET, testSet);
  }
  
}
