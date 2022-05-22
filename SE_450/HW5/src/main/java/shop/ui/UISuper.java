package shop.ui;

 abstract class UISuper implements UISuperI{
    private final String heading;
    private final Pair[] pairs;

    public UISuper(String _heading, Pair[] _menu) {
        this.heading = _heading;
        this.pairs = _menu;
    }

    public int size() {
        return this.pairs.length;
    }
    public String getHeading() {
        return this.heading;
    }
    public String getPrompt(int i) {
        return this.pairs[i].getPrompt();
    }
    public Pair[] getPairs(){
        return this.pairs;
    }
}
