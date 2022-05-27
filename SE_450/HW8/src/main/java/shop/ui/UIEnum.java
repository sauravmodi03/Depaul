package shop.ui;

import shop.command.Command;
import shop.data.Data;
import shop.data.Inventory;
import shop.data.Video;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum UIEnum {

    DEFAULT("Default");
    public enum MENU implements UIMenuAction {
        DEFAULT("Default"){
            @Override
            public void run(){
                add(this.getName(), new UIMenuAction() {
                    @Override
                    public void run() {
                        getUI().displayError("doh!");
                    }
                });
            }
        },
        ADD_REMOVE("Add/Remove copies of a video") {
            @Override
            public void run() {
                add(this.getName(), new UIMenuAction() {
                    @Override
                    public void run() {
                        try {
                            String[] result1 = getUI().processForm(FORM.getUIForm("Enter Video "));
                            Video v = Data.newVideo(result1[0], Integer.parseInt(result1[1]), result1[2]);

                            Command c = Data.newAddCmd(getInventory(), v, Integer.parseInt(result1[3]));
                            if (!c.run()) {
                                getUI().displayError("Command failed..!!");
                            } else {
                                getUI().displayMessage("Video successfully added.");
                            }
                        } catch (Exception ex) {
                            getUI().displayError(ex.getMessage());
                        }
                    }
                });
            }
        },
        CHECKIN("Check in a video") {
            @Override
            public void run() {
                add(this.getName(), new UIMenuAction() {
                    @Override
                    public void run() {
                        try {
                            String[] result1 = getUI().processForm(EnumForm.getUIForm());
                            Video v = Data.newVideo(result1[0], Integer.parseInt(result1[1]), result1[2]);

                            Command c = Data.newInCmd(getInventory(), v);
                            if (!c.run()) {
                                getUI().displayError("Command failed..!!");
                            } else {
                                getUI().displayMessage("Video successfully checked in.");
                            }
                        } catch (Exception ex) {
                            getUI().displayError(ex.getMessage());
                        }
                    }
                });
            }
        },
        CHECKOUT("Check out a video") {
            @Override
            public void run() {
                add(this.getName(), new UIMenuAction() {
                    @Override
                    public void run() {
                        try {
                            String[] result1 = getUI().processForm(EnumForm.getUIForm());
                            Video v = Data.newVideo(result1[0], Integer.parseInt(result1[1]), result1[2]);
                            Command c = Data.newOutCmd(getInventory(), v);
                            if (!c.run()) {
                                getUI().displayError("Command failed..!!");
                            } else {
                                getUI().displayMessage("Video successfully checked out.");
                            }
                        } catch (Exception ex) {
                            getUI().displayError(ex.getMessage());
                        }
                    }
                });
            }
        },
        PRINT_INVENTORY("Print the inventory") {
            @Override
            public void run() {
                add(this.getName(), new UIMenuAction() {
                    @Override
                    public void run() {
                        getUI().displayMessage(getInventory().toString());
                    }
                });
            }
        },
        CLEAR_INVENTORY("Clear the inventory") {
            @Override
            public void run() {
                add(this.getName(), new UIMenuAction() {
                    @Override
                    public void run() {
                        if (!Data.newClearCmd(getInventory()).run()) {
                            getUI().displayError("Command failed..!!");
                        } else {
                            getUI().displayMessage("Inventory is cleared.");
                        }
                    }
                });
            }
        },
        UNDO("UNDO") {
            @Override
            public void run() {
                add(this.getName(), new UIMenuAction() {
                    @Override
                    public void run() {
                        if (!Data.newUndoCmd(getInventory()).run()) {
                            getUI().displayError("Command failed..!!");
                        } else {
                            getUI().displayMessage("Undo command successfully executed.");
                        }
                    }
                });
            }
        },
        REDO("REDO") {
            @Override
            public void run() {
                add(this.getName(), new UIMenuAction() {
                    @Override
                    public void run() {
                        if (!Data.newRedoCmd(getInventory()).run()) {
                            getUI().displayError("Command failed..!!");
                        } else {
                            getUI().displayMessage("Redo command successfully executed.");
                        }
                    }
                });
            }
        },
        TOP_RENTALS("Print top ten all time rentals") {
            @Override
            public void run() {
                add(this.getName(), new UIMenuAction() {
                    @Override
                    public void run() {
                        getUI().displayMessage(getInventory().printAllTimeRentals());
                    }
                });
            }
        },
        EXIT("Exit") {
            @Override
            public void run() {
                add(this.getName(), new UIMenuAction() {
                    @Override
                    public void run() {
                        _state = State.EXIT;
                    }
                });
            }
        },
        DUMMY_DATA("Initialize with bogus content") {
            @Override
            public void run() {
                add(this.getName(), new UIMenuAction() {
                    @Override
                    public void run() {
                        Data.newAddCmd(getInventory(), Data.newVideo("a", 2000, "m"), 1).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("b", 2000, "m"), 2).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("c", 2000, "m"), 3).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("d", 2000, "m"), 4).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("e", 2000, "m"), 5).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("f", 2000, "m"), 6).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("g", 2000, "m"), 7).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("h", 2000, "m"), 8).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("i", 2000, "m"), 9).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("j", 2000, "m"), 10).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("k", 2000, "m"), 11).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("l", 2000, "m"), 12).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("m", 2000, "m"), 13).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("n", 2000, "m"), 14).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("o", 2000, "m"), 15).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("p", 2000, "m"), 16).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("q", 2000, "m"), 17).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("r", 2000, "m"), 18).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("s", 2000, "m"), 19).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("t", 2000, "m"), 20).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("u", 2000, "m"), 21).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("v", 2000, "m"), 22).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("w", 2000, "m"), 23).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("x", 2000, "m"), 24).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("y", 2000, "m"), 25).run();
                        Data.newAddCmd(getInventory(), Data.newVideo("z", 2000, "m"), 26).run();
                        getUI().displayMessage("Data Initialized with dummy content.");
                    }
                });
            }
        };

        private final String name;
        private static Inventory _inventory;
        private static UI _ui;

        public static UI getUI(){
            return _ui;
        }
        public static void setUI(UI ui){
            _ui = ui;
        }
        MENU(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static Inventory getInventory() {
            return _inventory;
        }

        public static void setInventory(Inventory inventory) {
            _inventory = inventory;
        }

        public static UIMenu getUIMenu(Inventory inventory, UI ui, State state, String heading){
            _menu = new ArrayList<>();
            setInventory(inventory);
            setUI(ui);
            setState(state);
            Arrays.stream(values()).forEach(x-> x.run());
            return toUIMenu(heading);
        }
    };

    public enum EXIT implements UIMenuAction{
        DEFAULT("Default"){
            @Override
            public void run(){
                add(this.getName(), new UIMenuAction() {
                    @Override
                    public void run() {
                    }
                });
            }
        },
        YES("Yes"){
            @Override
            public void run() {
                add(this.getName(), new UIMenuAction() {
                            public void run() {
                                setState(State.EXITED);
                            }
                });
            }
        },
        NO("No"){
            @Override
            public void run() {
                add(this.getName(), new UIMenuAction() {
                        public void run() {
                            setState(State.START);
                        }
                });
            }
        };
        private final String name;
        EXIT(String name) {
            this.name = name;
        }
        public String getName(){
            return this.name;
        }

        public static UIMenu getUIExit(String heading){
            _menu = new ArrayList<>();
            Arrays.stream(values()).forEach(x-> x.run());
            return toUIMenu(heading);
        }
    };

    public enum FORM implements UIMenuAction{
        TITLE("Title"){
            @Override
            public void run(){
                add(this.getName(),UITestClass.getStringTest());
            }
        },
        YEAR("Year"){
            @Override
            public void run(){
                add(this.getName(),UITestClass.getYearTest());
            }
        },
        DIRECTOR("Director"){
            @Override
            public void run(){
                add(this.getName(), UITestClass.getStringTest());
            }
        },
        COPIES_ADD_REMOVE("No of copies to add/remove"){
            @Override
            public void run(){
                add(this.getName(),UITestClass.getNumberTest());
            }
        };

        FORM(String name){
            this._name = name;
        }

        private final String _name;

        public String getName(){
            return this._name;
        }

        public static UIForm getUIForm(String heading){
            Arrays.stream(values()).forEach(x->{x.run();});
            return toUIForm(heading);
        }
    }


    public static List<UIMenu.Pair> _menu = new ArrayList<>();
    public static List<UIForm.Pair> _form = new ArrayList<>();

    private static void add(String menu, UIMenuAction action) {
        if (null == action)
            throw new IllegalArgumentException();
        _menu.add(new UIMenu.Pair(menu, action));
    }

    private static void add(String menu, UIFormTest test) {
        if (null == test)
            throw new IllegalArgumentException();
        _form.add(new UIForm.Pair(menu, test));
    }
    private static UIMenu toUIMenu(String heading) {
        if (null == heading)
            throw new IllegalArgumentException();
        if (_menu.size() < 1)
            throw new IllegalStateException();
        UIMenu.Pair[] array = new UIMenu.Pair[_menu.size()];
        for (int i = 0; i < _menu.size(); i++)
            array[i] = _menu.get(i);
        _menu.clear();
        return new UIMenu(heading, array);
    }

    public static UIForm toUIForm(String heading) {
        if (null == heading)
            throw new IllegalArgumentException();
        if (_form.size() < 1)
            throw new IllegalStateException();
        UIForm.Pair[] array = new UIForm.Pair[_form.size()];
        for (int i = 0; i < _form.size(); i++)
            array[i] = _form.get(i);
        _form.clear();
        return new UIForm(heading, array);
    }

    private final String name;

    private static State _state;

    UIEnum(String aDefault) {
        this.name = aDefault;
    }

    public String getName() {
        return name;
    }

    public static State getState() {
        return _state;
    }

    public static void setState(State state) {
        _state = state;
    }
}
