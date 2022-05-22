package shop.main;

import org.junit.Test;
import shop.command.Command;
import shop.data.Data;
import shop.data.Inventory;
import shop.data.Record;
import shop.data.Video;

import static org.junit.Assert.*;

// TODO:
// write an integration test that tests the data classes.
// add in some videos, check out, check in, delete videos, etc.
// check that errors are reported when necessary.
// check that things are going as expected.
public class TEST1 {
  private Inventory _inventory = Data.newInventory();
  public TEST1() {
    super();
  }

  private void expect(Video v, String s) {
    assertEquals(s,_inventory.get(v).toString());
  }

  private void check(Video v, int numOwned, int numOut, int numRentals) {
    Record r = _inventory.get(v);
    assertEquals(numOwned, r.numOwned());
    assertEquals(numOut, r.numOut());
    assertEquals(numRentals, r.numRentals());
  }
  
  @Test
  public void test1() {
    Command clearCmd = Data.newClearCmd(_inventory);
    clearCmd.run();
    
    Video v1 = Data.newVideo("Title1", 2000, "Director1");
    assertEquals(0, _inventory.size());
    assertTrue(Data.newAddCmd(_inventory, v1, 5).run());
    assertEquals(1, _inventory.size());
    assertTrue(Data.newAddCmd(_inventory, v1, 5).run());
    assertEquals(1, _inventory.size());
    check(v1,10,0,0);
    
    // TODO
  }

  @Test
  public void test13() {
    Command clearCmd = Data.newClearCmd(_inventory);
    clearCmd.run();
    Video v1 = Data.newVideo("Title1", 2000, "Director1");
    Data.newAddCmd(_inventory, v1, 5).run();
    Data.newAddCmd(_inventory, v1, 5).run();
    Video v2 = Data.newVideo("Title2", 2001, "Director2");
    Data.newAddCmd(_inventory, v2, 1).run();
    assertFalse(Data.newAddCmd(_inventory, null, 5).run());
    assertEquals(2, _inventory.size());

    assertTrue(Data.newOutCmd(_inventory, v2).run());
    expect(v2,"Title2 (2001) : Director2 [1,1,1]");

    assertTrue(Data.newInCmd(_inventory, v2).run());
    expect(v2,"Title2 (2001) : Director2 [1,0,1]");
  }

  @Test
  public void test14(){
    Command clearCmd = Data.newClearCmd(_inventory);
    clearCmd.run();
    Video v1 = Data.newVideo("Title1", 2000, "Director1");
    Data.newAddCmd(_inventory, v1, 5).run();
    Data.newAddCmd(_inventory, v1, 5).run();
    Video v2 = Data.newVideo("Title2", 2001, "Director2");
    Data.newAddCmd(_inventory, v2, 1).run();
    Data.newAddCmd(_inventory, null, 5).run();
    Data.newOutCmd(_inventory, v2).run();
    Data.newInCmd(_inventory, v2).run();

    assertTrue(Data.newAddCmd(_inventory, v2, -1).run());
    assertEquals(1, _inventory.size());
    expect(v1,"Title1 (2000) : Director1 [10,0,0]");
  }

  @Test
  public void test15(){
    Command clearCmd = Data.newClearCmd(_inventory);
    clearCmd.run();
    Video v1 = Data.newVideo("Title1", 2000, "Director1");
    Data.newAddCmd(_inventory, v1, 5).run();
    Data.newAddCmd(_inventory, v1, 5).run();
    Video v2 = Data.newVideo("Title2", 2001, "Director2");
    Data.newAddCmd(_inventory, v2, 1).run();
    Data.newAddCmd(_inventory, null, 5).run();
    Data.newOutCmd(_inventory, v2).run();
    Data.newInCmd(_inventory, v2).run();

    Data.newAddCmd(_inventory, v2, -1).run();

    Command outCmd = Data.newOutCmd(_inventory, v1);
    assertTrue(outCmd.run());
    assertTrue(outCmd.run());
    assertTrue(outCmd.run());
    assertTrue(outCmd.run());

    expect(v1,"Title1 (2000) : Director1 [10,4,4]");

    assertTrue(Data.newInCmd(_inventory, v1).run());
    expect(v1,"Title1 (2000) : Director1 [10,3,4]");

    assertTrue(Data.newAddCmd(_inventory, v2, 5).run());
    assertEquals(2, _inventory.size());
    expect(v2,"Title2 (2001) : Director2 [5,0,0]");
    expect(v1,"Title1 (2000) : Director1 [10,3,4]");
  }
}
