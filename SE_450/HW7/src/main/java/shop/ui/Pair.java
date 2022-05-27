package shop.ui;

/**
 * Generic pair class for Menu and Form
 * @param <X> first type
 * @param <Y> second type
 */
 final class Pair<X, Y> {

    private final X _x;
    private final Y _y;

    public Pair(X x, Y y) {
        this._x = x;
        this._y = y;
    }

    public X getFirst() {
        return _x;
    }

    public Y getSecond() {
        return _y;
    }
}
