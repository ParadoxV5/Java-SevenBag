package xyz.paradoxv5;
import java.util.HashSet;
import java.util.random.RandomGenerator;

public class SevenBag implements java.util.function.Supplier<SevenBag.Tetromino> {
  public static enum Tetromino {
    T, I, O, J, L, S, Z;
    protected static final HashSet<Tetromino> SET = new HashSet<>(java.util.Arrays.asList(values()));
  }
  
  protected final RandomGenerator random;
  public SevenBag(RandomGenerator random) { this.random = random; }
  public SevenBag() { this(new java.util.Random()); }
  
  protected java.util.LinkedList<Tetromino> tetrominoBag = new java.util.LinkedList<>();
  @Override public Tetromino get() {
    if(tetrominoBag.isEmpty()) tetrominoBag.addAll(Tetromino.SET);
    return tetrominoBag.remove(random.nextInt(tetrominoBag.size()));
  }
  
  public static final class Test {
    SevenBag sevenBag;
    @org.junit.jupiter.api.BeforeEach public void init() { sevenBag = new SevenBag(); }
    
    @org.junit.jupiter.api.Test public void testGet() {
      HashSet<Tetromino> testSet = new java.util.HashSet<>();
    
      for(byte test_count = 0; test_count < 5; ++test_count) {
        testSet.clear();
        for(byte piece_count = 0; piece_count < Tetromino.SET.size(); ++piece_count)
          testSet.add(sevenBag.get());
        org.junit.jupiter.api.Assertions.assertEquals(Tetromino.SET, testSet);
      }
    }
  }
}