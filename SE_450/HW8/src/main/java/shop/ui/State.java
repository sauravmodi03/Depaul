package shop.ui;

public enum State {
    EXITED(0),
    EXIT(1),
    START(2);

    private final int state;
    State(int i) {
        this.state = i;
    }

    public int getVal(){
        return state;
    }
}
