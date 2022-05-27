package shop.ui;

/**
 * @see UIForm
 */
final class UIForm extends UISuper implements UIFormI {

  private final Pair<String, UIFormTest>[] pairs;

  UIForm(String heading, Pair[] test) {
    super(heading);
    pairs = test;
  }

  public int size() {
    return this.pairs.length;
  }

  public String getPrompt(int i) {
    return this.pairs[i].getFirst();
  }

  public boolean checkInput(int i, String input) {
    if (null == pairs[i]){
      return false;
    }else{
      return pairs[i].getSecond().run(input);
    }
  }
}
