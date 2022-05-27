package shop.ui;

public interface UIMenuI extends UISuperI{
    int size();
    String getPrompt(int i);
    void runAction(int i);
}
