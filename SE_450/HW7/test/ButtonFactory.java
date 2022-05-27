package shop.test;

public class ButtonFactory {
    public ButtonFactory() {
    }
    static public SingleButton newSingleButton(String label) {
        return new SingleButton(label);
    }

    static public RadioButtonSet newRadioButtonSet(String[] labels) {
        return new RadioButtonSet(labels);
    }
}
