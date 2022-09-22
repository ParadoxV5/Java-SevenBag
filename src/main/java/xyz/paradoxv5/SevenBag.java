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
  
}
