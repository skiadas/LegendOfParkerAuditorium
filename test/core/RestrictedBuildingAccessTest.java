package core;

import org.junit.Test;

import static org.junit.Assert.*;

public class RestrictedBuildingAccessTest {
    @Test
    public void canCreateBuilding() {
        Building levelOne = new Building(true);
    }
    @Test
    public void canLimitBuildingEntrance() {
        Building levelOne = new Building(true);
        Building levelTwo = new Building(false);
        assertTrue(levelOne.canEnter());
        assertFalse(levelTwo.canEnter());
    }
    @Test
    public void canEnterBuildingFromCurrentLocation() {
        Location currentLocation = new Location(true);
        assertEquals(true, currentLocation.isBuildingEntrance());
    }
    @Test
    public void canCreateInventory() {
        Inventory inventory = new Inventory(0);
        assertEquals(0, Inventory.numberOfItems());
    }
//    @Test
//    public void canLimitBuildingEntry() {
//        Building levelOne = new Building(true);
//        Building levelTwo = new Building(false);
//        Inventory inventory = new Inventory(0);
//        Location currentLocation = new Location(true);
//        inventory.addKey();
//        assertEquals(true, levelTwo.canEnter());
//    }
    // Started but need Building list
}
