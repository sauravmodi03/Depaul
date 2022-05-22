package shop.ui;

/**
 * @see UIFormBuilder
 */
final class UIForm extends UISuper implements UIFormI {

  UIForm(String heading, Pair[] menu) {
    super(heading,menu);
  }

  public boolean checkInput(int i, String input) {
    if (null == this.getPairs()[i])
      return true;
    return this.getPairs()[i].getTest().run(input);
  }
}
