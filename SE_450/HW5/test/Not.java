package shop.test;

public class Not implements Predicate<Integer>{

    Predicate _p;

    public Not(Predicate<Integer> p) {
        _p = p;
    }

    @Override
    public boolean eval(Integer j) {
        if (_p.eval(j))
            return false;
        return true;
    }
}
