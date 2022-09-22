package xyz.paradoxv5;
import java.util.*;

public class SevenBag implements java.util.function.Supplier<SevenBag.Tetromino> {
  public enum Tetromino {
    T, I, O, J, L, S, Z;
    static final HashSet<Tetromino> SET = new HashSet<>(Arrays.asList(values()));
  }
  
  /* Note:
    The next Tetromino is the **last** element of the ArrayList.
    Removing the last element of a List is O(1) whereas it’s O(n) for the first.
    This design optimizes the bag for shuffling (as a RandomAccess) and single-end de-queuing
  */
  protected ArrayList<Tetromino> bag = new ArrayList<>(7);
  
  protected final Random random;
  public SevenBag(Random random) {
    this.random = random;
  }
  public SevenBag() { this(null); }
      
  @Override public Tetromino get() {
    if(bag.isEmpty()) {
      bag.addAll(Tetromino.SET);
      Collections.shuffle(bag, random);
    }
    return bag.remove(bag.size() - 1);
  }
}
