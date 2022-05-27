package shop.ui;

public interface UIBuilder {

    void add(String prompt, UIMenuAction action);

    void add(String prompt, UIFormTest test);

    UIMenu toUIMenu(String heading);

    UIForm toUIForm(String heading);
}
