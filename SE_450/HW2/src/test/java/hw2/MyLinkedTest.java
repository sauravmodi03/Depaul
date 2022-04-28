package hw2;

import junit.framework.Assert;
import junit.framework.TestCase;

import static hw2.MyLinked.print;

/**
 * Test file for MyLinked class
 */
public class MyLinkedTest extends TestCase {

    /**
     * Junit to Test Add function
     */
    public void testAdd() {
        MyLinked b = new MyLinked ();
        for (double i = 1; i <= 11; i++) {
            b.add (i);
        }
        print("Singleton : ", b);
        Assert.assertEquals(11,b.size());
        for (double i = 1; i <= 5; i++) {
            b.add (i);
            b.add(i + 5);
        }
        print("Singleton : ", b);
        Assert.assertEquals(21, b.size());
    }

    /**
     * Junit to Test Delete function
     */
    public void testDelete() {
        MyLinked b = new MyLinked ();
        for (double i = 1; i <= 10; i++) {
            b.add (i);
        }
        print ("Singleton", b);
        b.delete( 6);
        print("Delete at middle : ", b);
        Assert.assertEquals(9, b.size());
        b.delete(9);
        print("Delete at end : ", b);
        Assert.assertEquals(8,b.size());
        b.delete(1);
        print("Delete at beginning : ",b);
        Assert.assertEquals(7,b.size());
    }

    /**
     * Junit to Test remove function
     */
    public void testRemove(){
        MyLinked b = new MyLinked ();
        for (double i = 1; i <= 5; i++) {
            b.add(i);
        }
        print("Singleton ",b);
        b.remove (4);
        Assert.assertEquals(4,b.size());
        print("Removed 4 ", b);
        b.remove (11);
        print("Removed 11 ", b); //Does nothing as 11 is not present in the list
        Assert.assertEquals(4,b.size());
        for (double i = 1; i <= 5; i++) {
            b.add(i);
            b.add(i);
        }
        print("Singleton ",b);
        b.remove(1);
        print("Remove all 1 ",b);
        b.remove(4);
        print("Remove all 4 ", b);
        b.remove(5);
        b.remove(3);
        b.remove(2);

        print("Remove all items ",b);
        Assert.assertEquals(0,b.size());
    }

    /**
     * Junit to Test reverse function
     */
    public void testReverse()
    {
        MyLinked b = new MyLinked ();
        b.reverse();
        print ("Reverse empty ", b);
        b.add(1);
        b.add(2);
        b.reverse();
        print ("Reverse two ", b);
        Assert.assertEquals(2,b.size());
        for (double i = 1; i <= 10; i++) {
            b.add (i);
        }
        print("Singleton : ", b);
        b.reverse();
        print("reversed List : ", b);
        Assert.assertEquals(12,b.size());
        for (double i = 1; i <= 7; i++) {
            b.add (i);
            b.add (i);
        }
        print("bigger list", b);
        b.reverse ();
        print("reversed", b);
        Assert.assertEquals(26,b.size());
    }
}
