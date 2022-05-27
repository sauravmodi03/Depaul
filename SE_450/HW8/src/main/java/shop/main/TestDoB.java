package shop.main;

import shop.ui.*;

public class TestDoB {

    private static final int EXITED = 0;
    private static final int EXIT = 1;
    private static final int START = 2;
    private static final int NUMSTATES = 11;
    private UIMenu[] _menus;
    private int _state;

    private UIForm _dobForm;

    private UI _ui;

    TestDoB(UI ui) {
        _ui = ui;

        _menus = new UIMenu[NUMSTATES];
        _state = START;
        //addSTART(START);
        //addEXIT(EXIT);

        UIFormTest testYear = new UIFormTest() {
            public boolean run(String input) {
                try {
                    int i = Integer.parseInt(input);
                    return i >= 1900 && i <= 2100;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        };

        UIFormTest testMonth = new UIFormTest() {
            public boolean run(String input) {
                try {
                    int i = Integer.parseInt(input);
                    return i >= 1 && i <= 12;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        };

        UIFormTest testDate = new UIFormTest() {
            public boolean run(String input) {
                try {
                    int i = Integer.parseInt(input);
                    return i >= 1 && i <= 31;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        };

        UIFormBuilder f = new UIFormBuilder();
//        f.add("Month : ", testMonth);
//        f.add("Date : ", testDate);
//        f.add("Year : ", testYear);
        _dobForm = f.toUIForm("Enter Date of Birth : ");
    }
    void run() {
        try {
            while (_state != EXITED) {
                _ui.processMenu(_menus[_state]);
            }
        } catch (UIError e) {
            _ui.displayError("UI closed.");
        }
    }
//    private void addSTART(int stateNum) {
//        UIMenuBuilder m = new UIMenuBuilder();
//
//        m.add("Default",
//                new UIMenuAction() {
//                    public void run() {
//                        _ui.displayError("doh!");
//                    }
//                });
//        m.add("Date of Birth",
//                new UIMenuAction() {
//                    public void run() {
//                        try{
//                            String[] result1 = _ui.processForm(_dobForm);
//                            _ui.displayMessage("Date of Birth successfully verified.");
//                            _state = START;
//
//                        } catch (Exception ex){
//                            _ui.displayError(ex.getMessage());
//                        }
//                    }
//                });
//        m.add("Exit",
//                new UIMenuAction() {
//                    public void run() {
//                        _state = EXIT;
//                    }
//                });
//        _menus[stateNum] = m.toUIMenu("Date of Birth ");
//    }
//    private void addEXIT(int stateNum) {
//        UIMenuBuilder m = new UIMenuBuilder();
//
//        m.add("Default", new UIMenuAction() { public void run() {} });
//        m.add("Yes",
//                new UIMenuAction() {
//                    public void run() {
//                        _state = EXITED;
//                    }
//                });
//        m.add("No",
//                new UIMenuAction() {
//                    public void run() {
//                        _state = START;
//                    }
//                });
//        _menus[stateNum] = m.toUIMenu("Are you sure you want to exit?");
//    }
}
