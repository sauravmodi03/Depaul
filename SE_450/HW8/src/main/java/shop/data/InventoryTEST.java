package shop.data;

import org.junit.Test;
import shop.command.Command;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// TODO: complete the tests
public class InventoryTEST {

  public InventoryTEST() {
    super();
  }

  private Inventory _inventory = Data.newInventory();

  final Video vid1 = Data.newVideo("Title1", 2000, "Director1");
  final Video vid2 = Data.newVideo("Title2", 2001, "Director2");
  final Video vid3 = Data.newVideo("Title3", 2002, "Director3");

  @Test
  public void testSize() {
    assert _inventory.size() == 0 : "Inventory not Empty";

    Command command;

    command = Data.newAddCmd(_inventory, vid1, 1);
    assertTrue(command.run());
    assertEquals(1, _inventory.size());

    command = Data.newAddCmd(_inventory, vid2, 2);
    assertTrue(command.run());
    assertEquals(2, _inventory.size());

    command = Data.newAddCmd(_inventory, vid3, 3);
    assertTrue(command.run());
    assertEquals(3, _inventory.size());

    command = Data.newAddCmd(_inventory, vid3, -1);
    assertTrue(command.run());
    assertEquals(3, _inventory.size());

    command = Data.newAddCmd(_inventory, vid3, -2);
    assertTrue(command.run());
    assertEquals(2, _inventory.size());

    command = Data.newAddCmd(_inventory, vid2, -2);
    assertTrue(command.run());
    assertEquals(1, _inventory.size());

    command = Data.newAddCmd(_inventory, vid1, -1);
    assertTrue(command.run());
    assertEquals(0, _inventory.size());
  }

  @Test
  public void testAddNumOwned() {
    assert _inventory.size() == 0 : "Inventory not Empty";

    Command command;

    command = Data.newAddCmd(_inventory, vid3, 2);
    assertTrue(command.run());
    assertEquals(2, _inventory.get(vid3).numOwned());

    command = Data.newAddCmd(_inventory, vid3, 2);
    assertTrue(command.run());
    assertEquals(4, _inventory.get(vid3).numOwned());

    command = Data.newAddCmd(_inventory, vid3, -1);
    assertTrue(command.run());
    assertEquals(3, _inventory.get(vid3).numOwned());

    command = Data.newClearCmd(_inventory);
    assertTrue(command.run());
    assertEquals(0, _inventory.size());
  }

  @Test
  public void testCheckOutCheckIn() {
    assert _inventory.size() == 0 : "Inventory not Empty";

    Command command;

    command = Data.newAddCmd(_inventory, vid3, 2);
    assertTrue(command.run());
    assertEquals(2, _inventory.get(vid3).numOwned());

    command = Data.newOutCmd(_inventory, vid3);
    assertTrue(command.run());
    assertEquals(1, _inventory.get(vid3).numOut());
    assertEquals(1, _inventory.get(vid3).numRentals());

    command = Data.newInCmd(_inventory, vid3);
    assertTrue(command.run());
    assertEquals(0, _inventory.get(vid3).numOut());
    assertEquals(1, _inventory.get(vid3).numRentals());

    command = Data.newClearCmd(_inventory);
    assertTrue(command.run());
  }

  @Test
  public void testClear() {
    assert _inventory.size() == 0 : "Inventory not Empty";

    Command command;

    command = Data.newAddCmd(_inventory, vid2, 1);
    assertTrue(command.run());
    command = Data.newAddCmd(_inventory, vid3, 1);
    assertTrue(command.run());

    assertEquals(2, _inventory.size());

    command = Data.newClearCmd(_inventory);
    assertTrue(command.run());
  }

  @Test
  public void testGet() {
    assert _inventory.size() == 0 : "Inventory not Empty";

    Command command;

    command = Data.newAddCmd(_inventory, vid1, 1);
    assertTrue(command.run());
    command = Data.newAddCmd(_inventory, vid2, 1);
    assertTrue(command.run());
    assertEquals(2, _inventory.size());

    assertEquals("Title1 (2000) : Director1 [1,0,0]", _inventory.get(vid1).toString());
    assertEquals("Title2 (2001) : Director2 [1,0,0]", _inventory.get(vid2).toString());

    command = Data.newClearCmd(_inventory);
    assertTrue(command.run());
  }

  @Test
  public void testIterator1() {
    assert _inventory.size() == 0 : "Inventory not Empty";

    Command command;

    HashSet<Video> hashSet = new HashSet<>();
    hashSet.add(vid1);
    hashSet.add(vid2);
    hashSet.add(vid3);

    command = Data.newAddCmd(_inventory, vid1, 1);
    assertTrue(command.run());
    command = Data.newAddCmd(_inventory, vid2, 1);
    assertTrue(command.run());
    command = Data.newAddCmd(_inventory, vid3, 1);
    assertTrue(command.run());

    Iterator<Record> recIterator = _inventory.iterator();

    while (recIterator.hasNext()) {
      Record rec = recIterator.next();
      if (hashSet.contains(rec.video())) {
        hashSet.remove(rec.video());
      }
    }
    assertEquals(0, hashSet.size());
  }

  @Test
  public void testIterator2() {
    assert _inventory.size() == 0 : "Inventory not Empty";

    Command command;

    List<Video> list = new ArrayList<>();
    list.add(vid1);
    list.add(vid2);
    list.add(vid3);

    command = Data.newAddCmd(_inventory, vid1, 1);
    assertTrue(command.run());
    command = Data.newAddCmd(_inventory, vid2, 1);
    assertTrue(command.run());
    command = Data.newAddCmd(_inventory, vid3, 1);
    assertTrue(command.run());

    Iterator<Record> recIterator = _inventory.iterator(new RecordComparator());

    while (recIterator.hasNext()) {
      Video video = recIterator.next().video();
      assertEquals(0,list.get(0).compareTo(video));
      list.remove(video);
    }
    assertEquals(0,list.size());
  }
}
