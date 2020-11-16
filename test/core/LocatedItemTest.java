package core;

import core.action.ActionFactory;
import mocks.AvailableBuildingsPresenterSpy;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocatedItemTest extends BaseAppTest{
    @Test
    public void canCreateLocatedItem() {
        LocatedItem locatedItem = new LocatedItem(new Coordinates(0,0));
    }

    @Test
    public void canAddLocatedItemToInventory() {
        game.getInventory().addKey();
        assertEquals(1, game.getInventory().getNumberOfKeys());
    }

    @Test
    public void canAddLocatedItem_AtCertainLocation() {
        Building building = new Building("One");
        Coordinates coords = new Coordinates(0, 0);
        building.addLocatedItem(coords);
        assertTrue(building.hasKeyAt(coords));
    }

    @Test /// Still needs work
    public void canAddLocatedItemToInventory_ByWalkingOnItem() {
        Building b = addBuildingRequiringKeys("B1", 0);
        b.setEntranceCoordinates(1, 1);
        WithinBuildingLocation wbl = new WithinBuildingLocation(b, new Coordinates(1, 0));
        game.setLocation(wbl);
        Coordinates coords = new Coordinates(0, 0);
        b.addLocatedItem(coords);
        game.setLocation(wbl.getRequestedMove(Direction.left));
    }

}
