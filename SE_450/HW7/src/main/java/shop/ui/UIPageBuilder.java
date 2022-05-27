package shop.ui;

import java.util.ArrayList;
import java.util.List;

final class UIPageBuilder implements UIBuilder {
    private final List<Pair> _menu = new ArrayList<Pair>();

    @Override
    public void add(Object o1, Object o2) {
        if (null == o2)
            throw new IllegalArgumentException();
        _menu.add(new Pair(o1, o2));
    }

    public UIMenu toUIMenu(String heading) {
        checkConstraints(heading);
        return new UIMenu(heading, getPairs());
    }

    public UIForm toUIForm(String heading) {
        checkConstraints(heading);
        return new UIForm(heading, getPairs());
    }

    private void checkConstraints(String heading){
        if (null == heading)
            throw new IllegalArgumentException();
        if (_menu.size() < 1)
            throw new IllegalStateException();
    }

    private Pair[] getPairs(){
        Pair[] array = new Pair[_menu.size()];
        for (int i = 0; i < _menu.size(); i++)
            array[i] = _menu.get(i);
        return array;
    }
}
