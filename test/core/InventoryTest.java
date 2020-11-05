package core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InventoryTest {
    @Test
    public void canCreateInventory(){
        Inventory i = new Inventory();
    }

    @Test
    public void canCreateInventoryWithKeys() {
        Inventory inventory = new Inventory(2);
        assertEquals(2, inventory.getNumberOfKeys());
    }
    @Test
    public void canAddKey() {
        Inventory i = new Inventory(0);
        i.addKey();
        assertEquals(1, i.getNumberOfKeys());
    }
}
