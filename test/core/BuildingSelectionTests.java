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
