package xyz.paradoxv5;

import org.junit.jupiter.api.*;
import java.util.TreeSet;
import java.util.Random;

public class SevenBagTest {
  
  @RepeatedTest(2) public void test_get_everyPiece() {
    SevenBag sevenBag = new SevenBag();
    TreeSet<SevenBag.Tetromino> testSet = new TreeSet<>();
    for(byte c = 0; c < 7; ++c)
      testSet.add(sevenBag.get());
    Assertions.assertEquals(SevenBag.Tetromino.SET, testSet);
  }
  
  @RepeatedTest(2) public void test_get_useGivenRandom() {
    Random random = new Random();
    long seed = random.nextLong();
    SevenBag sevenBag = new SevenBag(random);
    SevenBag.Tetromino[][] array = new SevenBag.Tetromino[2][7];
    for(int j = 0; j < 2; j++) {
      random.setSeed(seed);
      for(int i = 0; i < 7; i++)
        array[j][i] = sevenBag.get();
    }
    Assertions.assertArrayEquals(array[0], array[1]);
  }
  
}
