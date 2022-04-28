package shop.data;

import shop.command.Command;

/**
 * Implementation of command to check out a video.
 * @see Data
 */
final class CmdOut implements Command {
  private InventorySet _inventory;
  private Video _video;
  CmdOut(InventorySet inventory, Video video) {
    _inventory = inventory;
    _video = video;
  }
  public boolean run() {
    try {
      _inventory.checkOut(this._video);
      return true;
    } catch (UnsupportedOperationException ex) {
      System.out.println("Error : " + ex.getMessage());
      return false;
    }
  }
}
