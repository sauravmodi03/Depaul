package shop.data;

import shop.command.UndoableCommand;

/**
 * Implementation of command to check out a video.
 * @see Data
 */
final class CmdOut implements UndoableCommand {
  private InventorySet _inventory;
  private Record _oldvalue;
  private Video _video;
  CmdOut(InventorySet inventory, Video video) {
    _inventory = inventory;
    _video = video;
  }
  public boolean run() {
    try {
      _oldvalue = _inventory.checkOut(_video);
      _inventory.getHistory().add(this);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    } catch (ClassCastException e) {
      return false;
    }
  }

  /**
   * Undo the command.
   */
  public void undo() {
    _inventory.replaceEntry(_video,_oldvalue);
  }

  /**
   * Redo the command.
   */
  public void redo() {
    _inventory.checkOut(_video);
  }
}
