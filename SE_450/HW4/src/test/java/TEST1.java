
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import shop.command.Command;
import shop.data.Data;
import shop.data.Record;
import shop.data.Video;
import shop.data.Inventory;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
  private void expect(Record r, String s) {
    assertEquals(s,r.toString());
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
    // System.out.println(_inventory.get(v1));
    expect(v1,"Title1 (2000) : Director1 [10,0,0]");
    
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
    Assert.assertFalse(Data.newAddCmd(_inventory, null, 5).run());
    Assert.assertEquals(2, _inventory.size());

    Assert.assertTrue(Data.newOutCmd(_inventory, v2).run());
    expect(v2,"Title2 (2001) : Director2 [1,1,1]");

    Assert.assertTrue(Data.newInCmd(_inventory, v2).run());
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

    Assert.assertTrue(Data.newAddCmd(_inventory, v2, -1).run());
    Assert.assertEquals(1, _inventory.size());
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
    Assert.assertTrue(outCmd.run());
    Assert.assertTrue(outCmd.run());
    Assert.assertTrue(outCmd.run());
    Assert.assertTrue(outCmd.run());
    expect(v1,"Title1 (2000) : Director1 [10,4,4]");

    Assert.assertTrue(Data.newInCmd(_inventory, v1).run());
    expect(v1,"Title1 (2000) : Director1 [10,3,4]");

    Assert.assertTrue(Data.newAddCmd(_inventory, v2, 5).run());
    Assert.assertEquals(2, _inventory.size());
    expect(v2,"Title2 (2001) : Director2 [5,0,0]");
    expect(v1,"Title1 (2000) : Director1 [10,3,4]");
  }
}
