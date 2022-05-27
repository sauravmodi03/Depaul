package shop.test;

public class IsEven implements Predicate<Integer>{

    @Override
    public boolean eval(Integer i) {
            return i%2 == 0;
    }

    public static void main(String[] args){
//        Predicate<Integer> p = new IsEven();
//        Predicate<Integer> n = new Not(p);
//        Predicate<Integer> i = new Not(n);
//
//        if ( p.eval(2)) { System.out.println("2 is even"); }
//        if ( !n.eval(2)) { System.out.println("2 is even"); }
//        if ( n.eval(3)) { System.out.println("3 is not even");}
//        if ( !p.eval(3)) { System.out.println("3 is not even");}
//        if ( i.eval(2)) { System.out.println("2 is  even");}
//        if ( !i.eval(3)) { System.out.println("3 is not even");}

        Predicate<Integer> p
                = new Alternate();
        System.out.println( p.eval(0));
        System.out.println( p.eval(0));
        System.out.println( p.eval(0));
        System.out.println( p.eval(0));

        SingleButton singleButton = ButtonFactory.newSingleButton("");
        RadioButtonSet radioButtonSet = ButtonFactory.newRadioButtonSet(new String[]{"1","2"});

    }
}
