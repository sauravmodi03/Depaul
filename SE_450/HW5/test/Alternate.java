package shop.test;

public class Alternate implements Predicate<Integer>{

    boolean bool = true;

    @Override
    public boolean eval(Integer j) {
       return updateBool();
    }

    private boolean updateBool(){
        boolean old = bool;
        this.bool = !bool;
        return old;
    }
}
