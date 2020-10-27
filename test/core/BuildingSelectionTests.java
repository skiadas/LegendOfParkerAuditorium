package core;

import core.action.SelectBuildingAction;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildingSelectionTests {

    private Game game = new Game();


    @Test
    public void canCreateSelectBuildingAction() {
        SelectBuildingAction playerAction = new SelectBuildingAction(1);
        assertEquals(1, playerAction.getBuildingNum());
    }

    @Test
    public void canCreateSelectBuildingActionWith0() {
        SelectBuildingAction selectBuildingAction = new SelectBuildingAction(0);
        Building building = new Building("Outside");
        game.addBuildings(building);
        assertEquals("Outside", game.getBuildingAtIndex(selectBuildingAction.getBuildingNum()).getBuildingName());
    }

    @Test
    public void canSelectBuildingNumberOne() {
        SelectBuildingAction selectBuildingAction = new SelectBuildingAction(1);
        Building building = new Building("Donner");
        Building building2 = new Building("Outside");
        game.addBuildings(building2);
        game.addBuildings(building);
        assertEquals("Donner", game.getBuildingAtIndex(selectBuildingAction.getBuildingNum()).getBuildingName());
    }


    @Test
    public void canAddBuildingToList() {
        Building building = new Building("Donner");
        game.addBuildings(building);
        assertEquals(1, game.sizeOfBuildingList());
    }

    @Test
    public void canAddAnotherBuildingToList() {
        Building building = new Building("Donner");
        Building building2 = new Building("Parker");
        game.addBuildings(building);
        game.addBuildings(building2);
        assertEquals(2, game.sizeOfBuildingList());
    }


    @Test (expected = RuntimeException.class)
    public void cannotSelectBuildingWithInvalidNumber() {
        Interactor user = new Interactor();
        user.perform(new SelectBuildingAction(-1));
    }

    @Test (expected = RuntimeException.class)
    public void cannotSelectBuildingWithOutOfRangeNumber() {
        Interactor user = new Interactor();
        Building building = new Building("Donner");
        Building building2 = new Building("Parker");
        game.addBuildings(building);
        game.addBuildings(building2);
        user.perform(new SelectBuildingAction(3));
    }
}
