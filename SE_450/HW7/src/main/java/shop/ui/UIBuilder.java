package shop.ui;

/**
 * Common interface for UI builder
 * @param <X>
 * @param <Y>
 */
public interface UIBuilder<X,Y> {

    void add(X x, Y y);

    UIMenu toUIMenu(String heading);

    UIForm toUIForm(String heading);
}
