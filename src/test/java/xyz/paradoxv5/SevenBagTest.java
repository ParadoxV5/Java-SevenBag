package xyz.paradoxv5;
import org.junit.jupiter.api.*;

import java.util.HashSet;
public final class SevenBagTest {
  SevenBag sevenBag;
  @org.junit.jupiter.api.BeforeEach public void init() { sevenBag = new SevenBag(); }
  
  @Test public void testGet() {
    HashSet<SevenBag.Tetromino> testSet = new HashSet<>();
    
    for(byte test_count = 0; test_count < 5; ++test_count) {
      testSet.clear();
      for(byte piece_count = 0; piece_count < SevenBag.Tetromino.SET.size(); ++piece_count)
        testSet.add(sevenBag.get());
      org.junit.jupiter.api.Assertions.assertEquals(SevenBag.Tetromino.SET, testSet);
    }
  }
}
