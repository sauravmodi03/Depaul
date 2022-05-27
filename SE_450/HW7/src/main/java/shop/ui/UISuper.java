package shop.ui;

/**
 * Common class for UI form and UIMenu
 */
class UISuper implements UISuperI {
    private final String heading;

    public UISuper(String _heading) {
        this.heading = _heading;
    }

    public String getHeading() {
        return this.heading;
    }
}
