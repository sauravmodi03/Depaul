package shop.ui;

public interface UIFormI extends UISuperI {
    int size();
    String getPrompt(int i);
    boolean checkInput(int i, String input);
}
