package shop.ui;

public class UITestClass {

    private static UIFormTest numberTest;
    private static UIFormTest yearTest;
    private static UIFormTest stringTest;

    public static UIFormTest getNumberTest(){
        return numberTest = new UIFormTest() {
            public boolean run(String input) {
                try {
                    Integer.parseInt(input);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        };
    }

    public static UIFormTest getYearTest(){
        return yearTest = new UIFormTest() {
            public boolean run(String input) {
                try {
                    int i = Integer.parseInt(input);
                    return i > 1800 && i < 5000;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        };
    }

    public static UIFormTest getStringTest(){
        return stringTest = new UIFormTest() {
            public boolean run(String input) {
                return ! "".equals(input.trim());
            }
        };
    }
}
