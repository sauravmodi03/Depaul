package hw1;

import junit.framework.Assert;
import junit.framework.TestCase;

// TODO: complete the tests
public class VideoTest extends TestCase {

    public VideoTest(String name) {

        super(name);
    }


    final VideoObj vObj1 = new VideoObj( "Title1", 1999, "Director1" );
    final VideoObj vObj2 = new VideoObj( "Title2", 1999, "Director2" );

    /**
     * Function testConstructorAndAttributes
     */
    public void testConstructorAndAttributes() {
        String title1 = "XX";
        String director1 = "XY";
        String title2 = "XX";
        String director2 = "XY";
        int year = 2002;

        VideoObj v1 = new VideoObj(title1, year, director1);
        Assert.assertSame(title1, v1.title());
        Assert.assertEquals(year, v1.year());
        Assert.assertSame(director1, v1.director());

        VideoObj v2 = new VideoObj(title2, year, director2);
        Assert.assertEquals(title1, v2.title());
        Assert.assertEquals(director1, v2.director());

        VideoObj v1test = new VideoObj("a",1900,"b");
        VideoObj v2test = new VideoObj("a",1900,"b");

        assertTrue(!v1test.equals(v2test));

    }

    /**
     * Function testConstructorExceptionYear
     */
    public void testConstructorExceptionYear() {
        try {
            new VideoObj("X", 1800, "Y");
            fail();
        } catch (IllegalArgumentException e) { }
        try {
            new VideoObj("X", 5000, "Y");
            fail();
        } catch (IllegalArgumentException e) { }
        try {
            new VideoObj("X", 1801, "Y");
            new VideoObj("X", 4999, "Y");
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    /**
     * Function testConstructorExceptionTitle
     */
    public void testConstructorExceptionTitle() {
        try {
            new VideoObj(null, 2002, "Y");
            fail();
        } catch (IllegalArgumentException e) { }
        try {
            new VideoObj("", 2002, "Y");
            fail();
        } catch (IllegalArgumentException e) { }
        try {
            new VideoObj(" ", 2002, "Y");
            fail();
        } catch (IllegalArgumentException e) { }
    }

    /**
     * Function testConstructorExceptionDirector
     */
    public void testConstructorExceptionDirector() {
        try {
            new VideoObj("Title", 2002, null);
            fail();
        } catch (IllegalArgumentException e) { }
        try {
            new VideoObj("Title", 2002, "");
            fail();
        } catch (IllegalArgumentException e) { }
        try {
            new VideoObj("Title", 2002, " ");
            fail();
        } catch (IllegalArgumentException e) { }
    }

    /**
     * Function testHashCode
     */
    public void testHashCode() {
        Assert.assertEquals
                (-819023634,
                        new VideoObj("None", 2009, "Zebra").hashCode());
        Assert.assertEquals
                (-1335049862,
                        new VideoObj("Blah", 1954, "Cante").hashCode());
    }

    /**
     * Function testEquals
     */
    public void testEquals() {

        Assert.assertFalse(vObj1.equals(vObj2));
        Assert.assertTrue(vObj1.equals(vObj1));
    }

    /**
     * Function testCompareTo
     */
    public void testCompareTo() {

        Assert.assertEquals( -2, vObj1.compareTo(vObj2));
    }

    /**
     * Function testToString
     */
    public void testToString() {

        String res =  vObj2.title() + " (" + vObj2.year() + ") : " + vObj2.director();
        Assert.assertEquals(res,vObj2.toString());
    }
}
