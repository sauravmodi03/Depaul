package shop.command;

/**
 * An UndoableCommand may be run at most once.
 */
public interface UndoableCommand extends Command {
  /**
   * Do the command.
   * @return true if command succeeds, false otherwise
   */
  boolean run ();
  /**
   * Undo the command.
   */
  void undo ();
  /**
   * Redo the command.
   */
  void redo ();
}
