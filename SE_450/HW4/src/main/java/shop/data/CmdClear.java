package shop.data;

import shop.command.Command;

import java.io.Console;

/**
 * Implementation of command to clear the inventory.
 * @see Data
 */
final class CmdClear implements Command {
  private InventorySet _inventory;
  CmdClear(InventorySet inventory) {
    _inventory = inventory;
  }
  public boolean run() {
    try {
      _inventory.clear();
      return true;
    } catch (UnsupportedOperationException ex) {
      System.out.println("Error : " + ex.getMessage());
      return false;
    }
  }
}
