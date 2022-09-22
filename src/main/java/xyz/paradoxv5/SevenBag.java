package xyz.paradoxv5;
import java.util.*;
import org.jetbrains.annotations.*;

public class SevenBag implements java.util.function.Supplier<SevenBag.Tetromino> {
  public enum Tetromino {
    T, I, O, J, L, S, Z;
    public static final @Unmodifiable @NotNull Set<Tetromino> SET = Set.of(values());
  }
  
  /* Note:
    The next Tetromino is the **last** element of the ArrayList.
    Removing the last element of a List is O(1) whereas it’s O(n) for the first.
    This design optimizes for both shuffling (as a RandomAccess) and single-end de-queuing
  */
  protected @NotNull ArrayList<Tetromino> bag = new ArrayList<>(7);
  
  protected final @Nullable Random random;
  public SevenBag(@Nullable Random random) {
    this.random = random;
  }
  public SevenBag() { this(null); }
  
  @Override public @NotNull Tetromino get() {
    if(bag.isEmpty()) {
      bag.addAll(Tetromino.SET);
      if(random == null)
        Collections.shuffle(bag);
      else
        Collections.shuffle(bag, random);
    }
    return bag.remove(bag.size() - 1);
  }
}
