package shop.data;

import shop.command.Command;

/**
 * Implementation of command to add or remove inventory.
 * @see Data
 */
final class CmdAdd implements Command {
  private InventorySet _inventory;
  private Video _video;
  private int _change;
  CmdAdd(InventorySet inventory, Video video, int change) {
    _inventory = inventory;
    _video = video;
    _change = change;
  }
  public boolean run() {
    try {
      _inventory.addNumOwned(this._video,this._change);
      return true;
    } catch (UnsupportedOperationException ex) {
      System.out.println("Error : " + ex.getMessage());
      return false;
    }
  }
}
