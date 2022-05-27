package shop.main;

import shop.ui.PopupUI;
import shop.ui.UIFactory;
import shop.ui.UI;
import shop.data.Data;

public class Main {
  private Main() {}
  public static void main(String[] args) {
    UI ui;
//    if (Math.random() <= 0.5) {
//      ui = new shop.ui.TextUI();
//    } else {
//      ui = new shop.ui.PopupUI();
//    }

    //ui = UIFactory.getTextUI();
    ui = new PopupUI();
    //TestDoB control = new TestDoB(ui);
    //GOSTOP control = new GOSTOP(ui);
    Control control = new Control(Data.newInventory(),ui);
    control.run();
  }
}
