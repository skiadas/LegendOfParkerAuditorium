package core;

import org.junit.Test;

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
        game.addKeyToBuildingItemList(buildingWithKeyAtX0Y1, new Coordinates(0, 1));
        assertFalse(buildingWithKeyAtX0Y1.hasKeyAt(new Coordinates(0,0)));
    }

    @Test
    public void canSetKeyListInBuilding() {
        Building buildingWithKeyAtX0Y1 = addBuildingRequiringKeys("buildingWithKeyAtX0Y1", 0);
        Coordinates coords = new Coordinates(0, 1);
        game.addKeyToBuildingItemList(buildingWithKeyAtX0Y1, coords);
        assertTrue(buildingWithKeyAtX0Y1.hasKeyAt(coords));
    }
    @Test
    public void canAddKeyToInventoryByWalkingOnATileWithAKey() {

    }

    @Test
    public void canCheckIfThePlayerIsOnTheEntranceCell() {
        addBuildingAndMoveToItsEntrance("building1");
        assertTrue(game.canExitBuilding());
    }

    @Test
    public void canCheckIfThePlayerIsNotOnTheEntranceCell() {
        Building b = addBuildingRequiringKeys("b1",0);
        game.setLocation(new WithinBuildingLocation(b, new Coordinates(1,1)));
        assertFalse(game.canExitBuilding());
    }

    @Test
    public void canCheckIfThePlayerIsOnTheMap() {
        game.setLocation(new MapLocation());
        assertFalse(game.canExitBuilding());
    }
}
