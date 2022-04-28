package hw1;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Test class for Record object
 */
public class RecordTest extends TestCase {
    public RecordTest(String name) {
        super(name);
    }

    /**
     * Function testCopy
     */
    public void testCopy() {
        // be sure to test that copy returns a NEW reference!
        VideoObj video = new VideoObj( "Title1", 1999, "Director1" );
        Record rec1 = new Record( video, 10, 5, 50 );
        Record rec2 = rec1.copy();
        Assert.assertTrue( rec1.toString().equals(rec2.toString()) );
        Assert.assertTrue( rec1 != rec2 );

        VideoObj v1test = new VideoObj("a",1900,"b");
        Record r1 = new Record(v1test,4,0,0);
        Record r2 = r1.copy();
        assertTrue(!r1.equals(r2));
    }
}
