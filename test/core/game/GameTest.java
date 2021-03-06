package core.game;

import core.BaseAppTest;
import core.boundary.Coordinates;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest extends BaseAppTest {

    @Test
    public void canAddBuildings() {
        Building building1 = addBuildingRequiringKeys("building1", 1);
        Building building2 = addBuildingRequiringKeys("building2", 1);
        assertEquals(building1, game.getBuildingAtIndex(0));
        assertEquals(building2, game.getBuildingAtIndex(1));
    }


    @Test
    public void createAvailableBuildings(){
        Building building1 = addBuildingRequiringKeys("building1", 0);
        addBuildingRequiringKeys("building2", 1);
        addBuildingRequiringKeys("building3", 1);
        Building building4 = addBuildingRequiringKeys("building4", 0);
        assertEquals(List.of(building1, building4),
                     game.produceAvailableBuildings());
    }

    @Test
    public void canCallHasKeyAtWhenNoLocatedItemsExist() {
        Building buildingWithNoKeys = addBuilding("hasNoKeys");
        assertFalse(buildingWithNoKeys.hasKeyAt(new Coordinates(0, 1)));
    }

    @Test
    public void doesNotHaveKeyAtSpecifiedCoords() {
        Building buildingWithKeyAtX0Y1 = addBuildingRequiringKeys("buildingWithKeyAtX0Y1", 0);
        buildingWithKeyAtX0Y1.addKey(new Coordinates(0, 1));
        assertFalse(buildingWithKeyAtX0Y1.hasKeyAt(new Coordinates(0,0)));
    }

    @Test
    public void canSetKeyListInBuilding() {
        Building buildingWithKeyAtX0Y1 = addBuildingRequiringKeys("buildingWithKeyAtX0Y1", 0);
        Coordinates coords = new Coordinates(0, 1);
        buildingWithKeyAtX0Y1.addKey(coords);
        assertTrue(buildingWithKeyAtX0Y1.hasKeyAt(coords));
    }

    @Test
    public void canCheckIfThePlayerIsOnTheEntranceCell() {
        addBuildingAndMoveToItsEntrance("building1");
        assertTrue(game.canExitBuilding());
    }

    @Test
    public void canCheckIfThePlayerIsNotOnTheEntranceCell() {
        Building b = new Building("building");
        b.setEntrance(0,0);
        game.setLocation(createBuildingLocation(b, 1, 1));
        assertFalse(game.canExitBuilding());
    }

    @Test
    public void canCheckIfThePlayerIsOnTheMap() {
        game.setLocation(createMapLocation());
        assertFalse(game.canExitBuilding());
    }

    @Test
    public void testForGetBuildingsList() {
        Building building1 = addBuildingRequiringKeys("building1", 1);
        Building building2 = addBuildingRequiringKeys("building2", 1);
        List<Building> buildings = new ArrayList<>();
        buildings.add(building1);
        buildings.add(building2);
        assertEquals(buildings.get(0), game.getBuildings().get(0));
        assertEquals(buildings.get(1), game.getBuildings().get(1));
    }
    @Test
    public void canDetermineFinalBuilding() {
        Building building1 = addBuildingRequiringKeys("building1", 1);
        Building building2 = addBuildingRequiringKeys("building2", 2);
        Building building3 = addBuildingRequiringKeys("building3", 3);
        List<Building> buildings = new ArrayList<>();
        buildings.add(building1);
        buildings.add(building2);
        buildings.add(building3);
        game.determineFinalBuilding();
        assertTrue(building3.isFinalBuilding);
        assertFalse(building1.isFinalBuilding);
        assertFalse(building2.isFinalBuilding);
    }
}
