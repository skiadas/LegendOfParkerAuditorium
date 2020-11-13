package core;

import core.action.ActionFactory;
import core.action.SelectBuildingAction;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildingSelectionTest {

    private Game game = new Game();


    @Test
    public void canCreateSelectBuildingAction() {
        SelectBuildingAction playerAction = (SelectBuildingAction) ActionFactory.selectBuildingAction("Donner");
        assertEquals("Donner", playerAction.buildingName);
    }

    @Test
    public void canGetBuildingBasedOnItsName() {
        game.addBuilding(new Building("Donner"));
        Building building = game.getBuildingNamed("Donner");
        assertEquals("Donner", building.getBuildingName());
    }

    @Test
    public void canSelectBuildingNumberOutOfMoreBuildings() {
        game.addBuilding(new Building("Outside"));
        game.addBuilding(new Building("Donner"));
        assertEquals("Outside", game.getBuildingNamed("Outside").getBuildingName());
    }


    @Test
    public void cannotFindABuildingWithANameIfABuildingWithThatNameDoesNotExist() {
        game.addBuilding(new Building("Donner"));
        assertFalse(game.hasBuildingNamed("Outside"));
    }

    @Test
    public void checkingIfSelectedBuildingIsInList() {
        SelectBuildingAction selectBuildingAction = (SelectBuildingAction) ActionFactory.selectBuildingAction("Donner");
        game.addBuilding(new Building("Donner"));
        assertTrue(game.hasBuildingNamed(selectBuildingAction.buildingName));
    }

    @Test
    public void isBuildingWithinList() {
        game.addBuilding(new Building("Donner"));
        assertEquals(1, game.sizeOfBuildingList());
    }

    @Test
    public void canAddAnotherBuildingToList() {
        game.addBuilding(new Building("Donner"));
        game.addBuilding(new Building("Parker"));
        assertEquals(2, game.sizeOfBuildingList());
    }

    @Test
    public void checkingIfBuildingIsWithinAvailableBuildingsList() {
        game.addBuilding(new Building("building1", 0));
        game.addBuilding(new Building("building2", 1));
        assertTrue(game.isSelectedBuildingInAvailableBuildingsList(("building1")));
    }

    @Test
    public void checkingIfBuildingIsNotWithinAvailableBuildingsList() {
        game.addBuilding(new Building("building1", 0));
        game.addBuilding(new Building("building2", 1));
        assertFalse(game.isSelectedBuildingInAvailableBuildingsList(("building2")));
    }

}
