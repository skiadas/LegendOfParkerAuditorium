package core;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LocatedItemTest {
    @Test
    public void canCreateLocatedItem() {
        LocatedItem locatedItem = new LocatedItem(new Coordinates(0,0));
    }

    @Test
    public void canAddLocatedItem() {
        Building building = new Building("One");
        Coordinates coords = new Coordinates(0, 0);
        building.addLocatedItem(coords);
        assertTrue(building.hasKeyAt(coords));
    }

    @Test
    public void canAddLocatedItemToInventoryAfterWalkingOver() {
        Game game = new Game();
        game.getInventory().addKey();
    }
}
