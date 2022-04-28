package hw1;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 *
 */
public class InventoryTest extends TestCase {

    /**
     *
     * @param name inventory name
     */
    public InventoryTest(String name) {
        super(name);
    }

    /**
     * Initializing inventory Object
     */
    InventorySet _inv = new InventorySet();
    final VideoObj vObj1 = new VideoObj( "Title1", 1999, "Director1" );
    final VideoObj vObj2 = new VideoObj( "Title2", 1999, "Director2" );

    /**
     * Function testSize
     */
    public void testSize() {

        _inv.addNumOwned(vObj1,  2);
        Assert.assertEquals( 1, _inv.size());

        _inv.addNumOwned(vObj2,  3);
        Assert.assertEquals( 2, _inv.size());

        _inv.addNumOwned(vObj2, -3);
        Assert.assertEquals( 1, _inv.size());

        _inv.addNumOwned(vObj1, -2);
        Assert.assertEquals( 0, _inv.size() );

    }

    /**
     * Function testAddNumOwned
     */
    public void testAddNumOwned() {

        _inv.addNumOwned(vObj1, 4);
        Assert.assertEquals(4, _inv.get(vObj1).numOwned);
        _inv.addNumOwned(vObj1, 2);
        Assert.assertEquals(6, _inv.get(vObj1).numOwned);
        _inv.addNumOwned(vObj1, -6);
        Assert.assertEquals(0, _inv.size());

    }

    /**
     * Function testCheckOutCheckIn
     */
    public void testCheckOutCheckIn() {

        _inv.addNumOwned(vObj1, 2);
        _inv.checkOut(vObj1);
        Assert.assertEquals(1, _inv.get(vObj1).numOut );
        _inv.checkIn(vObj1);
        Assert.assertEquals( 0, _inv.get(vObj1).numOut );
        _inv.addNumOwned(vObj1, -2);
        Assert.assertEquals(0, _inv.size());

    }

    /**
     * Function testClear
     */
    public void testClear() {

        _inv.addNumOwned(vObj1, 5);
        Assert.assertEquals(1, _inv.size());
        _inv.clear();
        Assert.assertEquals(0, _inv.size());
    }

    /**
     * Function testGet
     */
    public void testGet() {

        _inv.addNumOwned(vObj1, 2);
        Assert.assertEquals(vObj1, _inv.get(vObj1).video );
        _inv.addNumOwned(vObj1, -2);
        Assert.assertEquals(0, _inv.size());
    }

    /**
     * Function testToCollection
     */
    public void testToCollection() {
        // Be sure to test that changing records in the returned
        // collection does not change the original records in the
        // inventory.  ToCollection should return a COPY of the records,
        // not the records themselves.
        // TODO
    }
}
