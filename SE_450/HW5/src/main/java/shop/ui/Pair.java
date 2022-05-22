package shop.ui;

 final class Pair {

    private String prompt;
    private UIFormTest test;
    private UIMenuAction action;

    public Pair(String _prompt, UIFormTest _test) {
        this.prompt = _prompt;
        this.test = _test;
    }

    public Pair(String _prompt, UIMenuAction _action) {
        this.prompt = _prompt;
        this.action = _action;
    }

    public String getPrompt() {
        return prompt;
    }

    public UIFormTest getTest() {
        return test;
    }

    public UIMenuAction getAction() {
        return action;
    }
}
