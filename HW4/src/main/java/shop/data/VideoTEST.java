package shop.data;

import org.junit.Test;

import static org.junit.Assert.*;

public class VideoTEST {

    public VideoTEST() {
        super();
    }


    final VideoObj vObj1 = new VideoObj("Title1", 1999, "Director1");
    final VideoObj vObj2 = new VideoObj("Title2", 2000, "Director2");

    /**
     * Function testConstructorAndAttributes
     */
    @Test
    public void testConstructorAndAttributes() {
        String title1 = "XX";
        String director1 = "XY";
        String title2 = "XX";
        String director2 = "XY";
        int year = 2002;

        VideoObj v1 = new VideoObj(title1, year, director1);
        assertSame(title1, v1.title());
        assertEquals(year, v1.year());
        assertSame(director1, v1.director());

        VideoObj v2 = new VideoObj(title2, year, director2);
        assertEquals(title1, v2.title());
        assertEquals(director1, v2.director());

        VideoObj v1test = new VideoObj("a", 1900, "b");
        VideoObj v2test = new VideoObj("a", 1900, "b");

        assertTrue(!v1test.equals(v2test));

    }

    /**
     * Function testConstructorExceptionYear
     */
    @Test
    public void testConstructorExceptionYear() {
        try {
            new VideoObj("X", 1800, "Y");
            fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            new VideoObj("X", 5000, "Y");
            fail();
        } catch (IllegalArgumentException e) {
        }
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
    @Test
    public void testConstructorExceptionTitle() {
        try {
            new VideoObj(null, 2002, "Y");
            fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            new VideoObj("", 2002, "Y");
            fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            new VideoObj(" ", 2002, "Y");
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Function testConstructorExceptionDirector
     */
    @Test
    public void testConstructorExceptionDirector() {
        try {
            new VideoObj("Title", 2002, null);
            fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            new VideoObj("Title", 2002, "");
            fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            new VideoObj("Title", 2002, " ");
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Function testHashCode
     */
    @Test
    public void testHashCode() {
        assertEquals
                (-819023634,
                        new VideoObj("None", 2009, "Zebra").hashCode());
        assertEquals
                (-1335049862,
                        new VideoObj("Blah", 1954, "Cante").hashCode());
    }

    /**
     * Function testEquals
     */
    @Test
    public void testEquals() {
        assertFalse(vObj1.equals(vObj2));
        assertTrue(vObj1.equals(vObj1));
    }

    /**
     * Function testCompareTo
     */
    @Test
    public void testCompareTo() {
        assertEquals(-3, vObj1.compareTo(vObj2));
    }

    /**
     * Function testToString
     */
    @Test
    public void testToString() {
        String res = vObj2.title() + " (" + vObj2.year() + ") : " + vObj2.director();
        assertEquals(res, vObj2.toString());
    }
}
