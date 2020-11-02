package core;

import core.action.SelectBuildingAction;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildingSelectionTests {

    private Game game = new Game();


    @Test
    public void canCreateSelectBuildingAction() {
        SelectBuildingAction playerAction = new SelectBuildingAction("Donner");
        assertEquals("Donner", playerAction.getSelectedBuildingName());
    }

    @Test
    public void canSelectBuilding() {
        SelectBuildingAction selectBuildingAction = new SelectBuildingAction("Donner");
        Building building = new Building("Donner");
        game.addBuildings(building);
        assertEquals(building, game.getBuildingBasedOnName(selectBuildingAction.getSelectedBuildingName()));
    }

    @Test
    public void canSelectBuildingNumberOutOfMoreBuildings() {
        SelectBuildingAction selectBuildingAction = new SelectBuildingAction("Outside");
        Building building = new Building("Donner");
        Building building2 = new Building("Outside");
        game.addBuildings(building2);
        game.addBuildings(building);
        assertEquals(building2, game.getBuildingBasedOnName(selectBuildingAction.getSelectedBuildingName()));
    }


    @Test
    public void canAddBuildingToList() {
        SelectBuildingAction selectBuildingAction = new SelectBuildingAction("Outside");
        Building building = new Building("Donner");
        game.addBuildings(building);
        assertFalse(game.isSelectedBuildingInBuildingList(selectBuildingAction.getSelectedBuildingName()));
    }

    @Test
    public void checkingIfSelectedBuildingIsInList() {
        SelectBuildingAction selectBuildingAction = new SelectBuildingAction("Donner");
        Building building = new Building("Donner");
        game.addBuildings(building);
        assertTrue(game.isSelectedBuildingInBuildingList(selectBuildingAction.getSelectedBuildingName()));
    }

    @Test
    public void isBuildingWithinList() {
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

    @Test
    public void checkingSelectedBuildingIsWithinAvailableBuildingsList() {
        SelectBuildingAction selectBuildingAction = new SelectBuildingAction("building1");
        Building building1 = new Building("building1", true);
        Building building2 = new Building("building2", false);
        game.addBuildings(building1);
        game.addBuildings(building2);
        assertTrue(game.isSelectedBuildingInAvailableBuildingsList((selectBuildingAction.getSelectedBuildingName())));
    }

    @Test
    public void checkingSelectedBuildingIsNotWithinAvailableBuildingsList() {
        SelectBuildingAction selectBuildingAction = new SelectBuildingAction("building2");
        Building building1 = new Building("building1", true);
        Building building2 = new Building("building2", false);
        game.addBuildings(building1);
        game.addBuildings(building2);
        assertFalse(game.isSelectedBuildingInAvailableBuildingsList((selectBuildingAction.getSelectedBuildingName())));
    }

    @Test (expected = RuntimeException.class) //// WHY DOES THIS WORK??? SINCE METHODS DO NOT EXIST NO MORE
    public void cannotSelectBuildingWithInvalidNumber() {
        Interactor user = new Interactor();
        user.perform(new SelectBuildingAction("Parker"));
    }

    @Test (expected = RuntimeException.class) //// WHY DOES THIS WORK??? SINCE METHODS DO NOT EXIST NO MORE
    public void cannotSelectBuildingWithOutOfRangeNumber() {
        Interactor user = new Interactor();
        Building building = new Building("Donner");
        Building building2 = new Building("Parker");
        game.addBuildings(building);
        game.addBuildings(building2);
        user.perform(new SelectBuildingAction("WAC"));
    }

}
