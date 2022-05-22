package shop.ui;

/**
 * @see UIMenuBuilder
 */
final class UIMenu extends UISuper implements UIMenuI {

  UIMenu(String heading, Pair[] pairs) {
    super(heading,pairs);
  }

  public void runAction(int i) {
    this.getPairs()[i].getAction().run();
  }
}
