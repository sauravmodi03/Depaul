package shop.data;

import org.junit.Test;

import static org.junit.Assert.*;

// TODO: complete the tests
public class DataTEST {
  public DataTEST() {
    super();
  }

  @Test
  public void testConstructorAndAttributes() {
    String title1 = "XX";
    String director1 = "XY";
    String title2 = " XX ";
    String director2 = " XY ";
    int year = 2002;

    Video v1 = Data.newVideo(title1, year, director1);
    assertSame(title1, v1.title());
    assertEquals(year, v1.year());
    assertSame(director1, v1.director());

    Video v2 = Data.newVideo(title2, year, director2);
    assertEquals(title1, v2.title());
    assertEquals(director1, v2.director());

    Video vid1 = Data.newVideo(title1, year, director1);
    Video vid2 = Data.newVideo(title1, year, director1);

    assertTrue(vid1==vid2);

  }

  @Test
  public void testConstructorExceptionYear() {
    try {
      Data.newVideo("X", 1800, "Y");
      fail();
    } catch (IllegalArgumentException e) { }
    try {
      Data.newVideo("X", 5000, "Y");
      fail();
    } catch (IllegalArgumentException e) { }
    try {
      Data.newVideo("X", 1801, "Y");
      Data.newVideo("X", 4999, "Y");
    } catch (IllegalArgumentException e) {
      fail();
    }
  }

  @Test
  public void testConstructorExceptionTitle() {
    try {
      Data.newVideo(null, 2002, "Y");
      fail();
    } catch (IllegalArgumentException e) { }
    try {
      Data.newVideo("", 2002, "Y");
      fail();
    } catch (IllegalArgumentException e) { }
    try {
      Data.newVideo(" ", 2002, "Y");
      fail();
    } catch (IllegalArgumentException e) { }
  }

  @Test
  public void testConstructorExceptionDirector() {
    try {
      Data.newVideo("T1", 2002, null);
      fail();
    } catch (IllegalArgumentException e) { }
    try {
      Data.newVideo("T1", 2002, "");
      fail();
    } catch (IllegalArgumentException e) { }
    try {
      Data.newVideo("T1", 2002, " ");
      fail();
    } catch (IllegalArgumentException e) { }
  }

}
