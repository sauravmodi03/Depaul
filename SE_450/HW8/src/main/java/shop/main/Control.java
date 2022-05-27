package shop.main;

import shop.ui.*;
import shop.data.Inventory;

class Control {
  private static final int NUMSTATES = 10;
  private UIMenu[] _menus;
  private Inventory _inventory;
  private UI _ui;
  
  Control(Inventory inventory, UI ui) {
    _inventory = inventory;
    _ui = ui;

    _menus = new UIMenu[NUMSTATES];
    addSTART(State.START);
    addEXIT(State.EXIT);

  }
  
  void run() {
    try {
      while (UIEnum.getState() != State.EXITED) {
        _ui.processMenu(_menus[UIEnum.getState().getVal()]);
      }
    } catch (UIError e) {
      _ui.displayError("UI closed");
    }
  }
  
  private void addSTART(State state) {
    _menus[state.getVal()] = UIEnum.MENU.getUIMenu(_inventory,_ui,state,"Bob's Video");
  }

  private void addEXIT(State state) {
    _menus[state.getVal()] = UIEnum.EXIT.getUIExit("Are you sure you want to exit?");
  }
}
