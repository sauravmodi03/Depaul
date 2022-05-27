//package shop.main;
//
//import shop.ui.*;
//
//class GOSTOP {
//    private static final int EXITED = 0;
//    private static final int EXIT = 1;
//    private static final int START = 2;
//    private static final int GOSTOP = 3;
//    private static final int NUMSTATES = 11;
//    private UIMenu[] _menus;
//    private int _state;
//
//    private UI _ui;
//
//    GOSTOP(UI ui) {
//        _ui = ui;
//        _menus = new UIMenu[NUMSTATES];
//        _state = START;
//        addSTART(START);
//        testGoStop(GOSTOP);
//        addEXIT(EXIT);
//    }
//
//    void run() {
//        try {
//            while (_state != EXITED) {
//                _ui.processMenu(_menus[_state]);
//            }
//        } catch (UIError e) {
//            _ui.displayError("UI closed");
//        }
//    }
//    private void addSTART(int stateNum) {
//        UIMenuBuilder m = new UIMenuBuilder();
//
//        m.add("Default",
//                new UIMenuAction() {
//                    public void run() {
//                        _ui.displayError("doh!");
//                    }
//                });
//        m.add("Test GoStop",
//                new UIMenuAction() {
//                    public void run() {
//                        _state = GOSTOP;
//                    }
//                });
//        m.add("Exit",
//                new UIMenuAction() {
//                    public void run() {
//                        _state = EXIT;
//                    }
//                });
//        _menus[stateNum] = m.toUIMenu("Enter your choice : ");
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
//    private void testGoStop(int stateNum) {
//        UIMenuBuilder m = new UIMenuBuilder();
//
//        m.add("Default", new UIMenuAction() { public void run() {
//        } });
//        m.add("GO",
//                new UIMenuAction() {
//                    int n = 0;
//                    public void run() {
//                        n++;
//                        _ui.displayMessage("I've done it " + n  +  " times.");
//                    }
//                });
//        m.add("Stop",
//                new UIMenuAction() {
//                    public void run() {
//                        _state = EXITED;
//                        _ui.displayMessage("Bye");
//                    }
//                });
//        _menus[stateNum] = m.toUIMenu("Go STOP Test");
//    }
//}
