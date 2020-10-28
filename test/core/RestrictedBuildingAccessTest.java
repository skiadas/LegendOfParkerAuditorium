package core;

import org.junit.Test;

import static org.junit.Assert.*;

public class RestrictedBuildingAccessTest {

    @Test
    public void canCreateBuilding() {
        Building levelOne = new Building("building1", true);
    }

    @Test
    public void canLimitBuildingEntrance() {
        Building levelOne = new Building("building1", true);
        Building levelTwo = new Building("building2", false);
        assertTrue(levelOne.canEnter());
        assertFalse(levelTwo.canEnter());
    }

    @Test
    public void canEnterBuildingFromCurrentLocation() {
        PlayerLocation currentLocation = new PlayerLocation(true);
        assertTrue(currentLocation.isBuildingEntrance());
    }
    // Will Not Need^

    @Test
    public void canCreateInventory() {
        Inventory inventory = new Inventory(0);
        assertEquals(0, inventory.numberOfItems());
    }

    @Test
    public void canLimitBuildingEntry() {
        Game game = new Game();
        Building levelOne = new Building("building1", true);
        Building levelTwo = new Building("building2", false);
        Inventory inventory = new Inventory();
        game.addBuildings(levelOne);
        game.addBuildings(levelTwo);
        assertTrue(levelOne.canEnter());
        assertFalse(levelTwo.canEnter());
        inventory.addKey();
    }
}
