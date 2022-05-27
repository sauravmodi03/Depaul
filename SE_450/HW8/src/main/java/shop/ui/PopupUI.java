package shop.ui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
//import java.io.IOException;

public final class PopupUI implements UI {
  public void displayMessage(String message) {
    JOptionPane.showMessageDialog(null,message);
  }

  public void displayError(String message) {
    JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.ERROR_MESSAGE);
  }

  public void processMenu(UIMenu menu) {
    StringBuilder b = new StringBuilder();
    b.append(menu.getHeading());
    b.append("\n");
    b.append("Enter choice by number:");
    b.append("\n");

    for (int i = 1; i < menu.size(); i++) {
      b.append("  " + i + ". " + menu.getPrompt(i));
      b.append("\n");
    }

    String response = JOptionPane.showInputDialog(b.toString());
    if (response == null) {
      response = "";
    }
    int selection;
    try {
      selection = Integer.parseInt(response, 10);
      if ((selection < 0) || (selection >= menu.size()))
        selection = 0;
    } catch (NumberFormatException e) {
      selection = 0;
    }
    menu.runAction(selection);
  }

  public String[] processForm(UIForm form) {
    String[] result = new String[4];
    StringBuilder b = new StringBuilder();
    b.append(form.getHeading());
    b.append("\n");
    b.append("Enter choice by number:");
    b.append("\n");

    for (int i = 1; i <= form.size(); i++) {
      b.append("  " + i + ". " + form.getPrompt(i-1));
      b.append("\n");
      result[i-1] = JOptionPane.showInputDialog(b.toString());
      if(!form.checkInput(i-1,result[i-1])){
        throw new RuntimeException("Invalid input. Please insert valid data.");
      }
    }
    return result;
  }
}
