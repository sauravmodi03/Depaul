
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
}
