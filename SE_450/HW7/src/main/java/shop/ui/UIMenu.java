package shop.ui;

/**
 * @see UIMenu
 */
final class UIMenu extends UISuper implements UIMenuI {
  private final Pair<String, UIMenuAction>[] pairs;

  UIMenu(String heading, Pair[] menu) {
    super(heading);
    pairs = menu;
  }

  public int size() {
    return this.pairs.length;
  }

  public String getPrompt(int i) {
    return this.pairs[i].getFirst();
  }

  public void runAction(int i) {
    pairs[i].getSecond().run();
  }
}
