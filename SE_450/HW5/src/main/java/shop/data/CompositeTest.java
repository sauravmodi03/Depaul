package shop.data;

import org.junit.Assert;
import org.junit.Test;
import shop.command.UndoableCommand;

public class CompositeTest {

    final Video v1 = Data.newVideo("K", 2003, "S");
    final Video v2 = Data.newVideo("S", 2002, "K");


    @Test
    public void test1(){
        final Inventory inventory = Data.newInventory();
        UndoableCommand c1 = Data.newAddCmd(inventory, v1, 2);
        UndoableCommand c2 = Data.newAddCmd(inventory, v2, 3);
        Composite c = new Composite();
        c.add(c1); c.add(c2);

        Assert.assertEquals( 0, inventory.size() );
        c.run();
        Assert.assertEquals( 2, inventory.size() );
        c.undo();
        Assert.assertEquals( 0, inventory.size() );
        c.redo();
        Assert.assertEquals( 2, inventory.size() );
    }

    @Test
    public void test2(){
        final Inventory inventory = Data.newInventory();
        UndoableCommand c1 = Data.newAddCmd(inventory, v1, 2);
        UndoableCommand c2 = Data.newAddCmd(inventory, v2, 3);
        UndoableCommand c3 = Data.newOutCmd(inventory, v1);
        Composite d = new Composite();
        d.add(c3); d.add(c2);

        Assert.assertEquals( 0, inventory.size() );
        c1.run();
        Assert.assertEquals( 1, inventory.size() );
        d.run();
        Assert.assertEquals( 2, inventory.size() );
        Assert.assertEquals( "K (2003) : S [2,1,1]", inventory.get(v1).toString() );

        d.undo();
        Assert.assertEquals( 1, inventory.size() );
        Assert.assertEquals( "K (2003) : S [2,0,0]", inventory.get(v1).toString() );

    }
}
