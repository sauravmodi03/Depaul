package shop.ui;

public interface UI {
  public void processMenu(UIMenuI menu);
  public String[] processForm(UIFormI form);
  public void displayMessage(String message);
  public void displayError(String message);
}
