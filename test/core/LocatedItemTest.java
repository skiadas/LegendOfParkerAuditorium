package core;

import core.action.ActionFactory;
import core.action.MovementAction;
import core.action.SelectBuildingAction;
import mocks.AvailableBuildingsPresenterSpy;
import mocks.UpdateWithinBuildingLocationSpy;
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
    public void canAddLocatedItemToInventory_AtCertainLocation() {
        Building building = new Building("One");
        Coordinates coords = new Coordinates(0, 0);
        building.addLocatedItem(coords);
        assertTrue(building.hasKeyAt(coords));
    }

   //@Ignore
    @Test
    public void canAddLocatedItemToInventory_ByWalkingOnItem() {
        UpdateWithinBuildingLocationSpy presenterSpy = new UpdateWithinBuildingLocationSpy();
        interactor.setPresenter(presenterSpy);
        Building b = addBuildingRequiringKeys("B1", 0);
        b.setEntranceCoordinates(1, 1);
        game.addBuilding(b);
        b.addLocatedItem(new Coordinates(1, 0));
        interactor.perform(ActionFactory.selectBuildingAction("B1"));
        interactor.perform(ActionFactory.moveDown());
        assertEquals(new Coordinates(1,0), game.getCoords());
        assertTrue(game.getCurrentBuilding().hasKeyAt(game.getCoords()));
        assertEquals(1, game.getInventory().getNumberOfKeys());
    }

}
