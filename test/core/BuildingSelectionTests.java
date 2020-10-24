package core;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildingSelectionTests {

    private Game game = new Game();

    @Test
    public void canCreateInteractor() {
        Interactor user = new Interactor();
    }


    @Test
    public void canCreateSelectBuildingAction() {
        SelectBuildingAction playerAction = new SelectBuildingAction(1);
        assertEquals(1, playerAction.getNum());
    }

    @Test
    public void canCreateSelectBuildingActionWith0() {
        SelectBuildingAction selectBuildingAction = new SelectBuildingAction(0);
        Building building = new Building("Outside");
        game.addBuildings(building);
        assertEquals("Outside", game.getBuildingAtIndex(selectBuildingAction.getNum()).getBuildingName());
    }

    @Test
    public void canSelectBuildingNumberOne() {
        SelectBuildingAction selectBuildingAction = new SelectBuildingAction(1);
        Building building = new Building("Donner");
        Building building2 = new Building("Outside");
        game.addBuildings(building2);
        game.addBuildings(building);
        assertEquals("Donner", game.getBuildingAtIndex(selectBuildingAction.getNum()).getBuildingName());
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

    @Test
    @Ignore
    public void cannotSelectBuildingWithInvalidNumber() {
        UserAction playerAction = new SelectBuildingAction(-1);
        PlayerLocation location = new PlayerLocation();
        assertFalse(location.isBuildingLocation());
    }
}
