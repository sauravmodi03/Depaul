package shop.ui;

import java.util.ArrayList;
import java.util.List;

public enum EnumForm {

    FORM("Enter Video");

    private final String val;

    EnumForm(String value) {
        this.val = value;
    }

    public String getVal() {
        return val;
    }

    private static List<UIForm.Pair> _menu = new ArrayList<>();

    public void add(EForm form, UIFormTest test) {
        _menu.add(new UIForm.Pair(form.getVal(), test));
    }

    public UIForm toUIForm(String heading) {
        if (null == heading)
            throw new IllegalArgumentException();
        if (_menu.size() < 1)
            throw new IllegalStateException();
        UIForm.Pair[] array = new UIForm.Pair[_menu.size()];
        for (int i = 0; i < _menu.size(); i++)
            array[i] = _menu.get(i);
        return new UIForm(heading, array);
    }

    private static void initMenu(){
        if(_menu.isEmpty()){
            _menu.add(new UIForm.Pair("Title", UITestClass.getStringTest()));
            _menu.add(new UIForm.Pair("Year", UITestClass.getYearTest()));
            _menu.add(new UIForm.Pair("Director", UITestClass.getStringTest()));
        }
    }

    public static UIForm getUIForm(){
        initMenu();
        UIForm.Pair[] array = new UIForm.Pair[_menu.size()];
        for (int i = 0; i < _menu.size(); i++)
            array[i] = _menu.get(i);
        return new UIForm(FORM.getVal(), array);
    }


}
