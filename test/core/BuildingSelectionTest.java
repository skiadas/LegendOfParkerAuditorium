package core;

import core.action.ActionFactory;
import core.action.SelectBuildingAction;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildingSelectionTest extends BaseAppTest {

    @Test
    public void canCreateSelectBuildingAction() {
        SelectBuildingAction playerAction = (SelectBuildingAction) ActionFactory.selectBuildingAction("Donner");
        assertEquals("Donner", playerAction.buildingName);
    }

    @Test
    public void canGetBuildingBasedOnItsName() {
        addBuilding("Donner");
        Building building = game.getBuildingNamed("Donner");
        assertEquals("Donner", building.getBuildingName());
    }

    @Test
    public void canSelectBuildingNumberOutOfMoreBuildings() {
        addBuilding("Outside");
        addBuilding("Donner");
        assertEquals("Outside", game.getBuildingNamed("Outside").getBuildingName());
    }


    @Test
    public void cannotFindABuildingWithANameIfABuildingWithThatNameDoesNotExist() {
        addBuilding("Donner");
        assertFalse(game.hasBuildingNamed("Outside"));
    }

    @Test
    public void checkingIfSelectedBuildingIsInList() {
        SelectBuildingAction selectBuildingAction = (SelectBuildingAction) ActionFactory.selectBuildingAction("Donner");
        addBuilding("Donner");
        assertTrue(game.hasBuildingNamed(selectBuildingAction.buildingName));
    }

    @Test
    public void isBuildingWithinList() {
        addBuilding("Donner");
        assertEquals(1, game.sizeOfBuildingList());
    }

    @Test
    public void canAddAnotherBuildingToList() {
        addBuilding("Donner");
        addBuilding("Parker");
        assertEquals(2, game.sizeOfBuildingList());
    }

    @Test
    public void checkingIfBuildingIsWithinAvailableBuildingsList() {
        addBuildingRequiringKeys("building1", 0);
        addBuildingRequiringKeys("building2", 1);
        assertTrue(game.isSelectedBuildingInAvailableBuildingsList(("building1")));
    }

    @Test
    public void checkingIfBuildingIsNotWithinAvailableBuildingsList() {
        addBuildingRequiringKeys("building1", 0);
        addBuildingRequiringKeys("building2", 1);
        assertFalse(game.isSelectedBuildingInAvailableBuildingsList(("building2")));
    }

}
