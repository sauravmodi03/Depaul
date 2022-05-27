package shop.main;

import org.junit.Test;
import shop.command.RerunnableCommand;
import shop.command.UndoableCommand;
import shop.data.Data;
import shop.data.Inventory;
import shop.data.Video;

import static org.junit.Assert.*;

public class TEST {

    @Test
    public void test1() {
        final Inventory inventory = Data.newInventory();
        final Video video1 = Data.newVideo("Title1", 2000, "Director1");
        final Video video2 = Data.newVideo("Title2", 2001, "Director2");
        final Video video3 = Data.newVideo("Title3", 2002, "Director3");
        final RerunnableCommand UNDO = Data.newUndoCmd(inventory);
        final RerunnableCommand REDO = Data.newRedoCmd(inventory);

        UndoableCommand c = Data.newAddCmd(inventory, video1, 2);
        assertTrue  ( c.run() );
        assertEquals( 1, inventory.size() );
        assertTrue  (!c.run() );     // cannot run an undoable command twice
        assertTrue(UNDO.run());
        assertFalse(UNDO.run());    // Return false as Undo stack is empty

        assertTrue(REDO.run());
        assertFalse(REDO.run());    // Return false as Redo stack is empty

        assertTrue(Data.newAddCmd(inventory,video2,1).run());
        assertTrue(Data.newAddCmd(inventory,video3,1).run());
        assertEquals( 3, inventory.size() );

        assertTrue(UNDO.run());
        assertTrue(UNDO.run());
        assertTrue(UNDO.run());

        assertEquals( 0, inventory.size() ); //Should be empty

        assertTrue(Data.newAddCmd(inventory,video1,1).run());

        assertFalse(REDO.run()); // As last command cleared REDO stack

        assertTrue(Data.newClearCmd(inventory).run());

        assertEquals(0,inventory.size());

        assertTrue(UNDO.run());

        assertTrue(REDO.run());

        assertTrue(Data.newAddCmd(inventory,video3,1).run());

        assertEquals(1, inventory.size());

        assertTrue(Data.newClearCmd(inventory).run());

        assertEquals(0,inventory.size());

    }

}
