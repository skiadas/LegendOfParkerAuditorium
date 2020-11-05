package core;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {


    private Game game = new Game();

    @Test
    public void canAddBuildings() {
        Building building1 = new Building("building1", 1);
        game.addBuilding(building1);
        assertEquals(building1, game.getBuildingAtIndex(0));
        Building building2 = new Building("building1", 1);
        game.addBuilding(building2);
        assertEquals(building2, game.getBuildingAtIndex(1));
    }


    @Test
    public void createAvailableBuildings(){
        Building building1 = new Building("building1", 0);
        Building building2 = new Building("building2", 1);
        Building building3 = new Building("building3", 1);
        Building building4 = new Building("building4", 0);
        game.addBuilding(building1);
        game.addBuilding(building2);
        game.addBuilding(building3);
        game.addBuilding(building4);
        List <Building> availableBuildings1 = new ArrayList<>();
        availableBuildings1.add(building1);
        availableBuildings1.add(building4);
        assertEquals(availableBuildings1, game.produceAvailableBuildings());


    }

    @Test
    public void canCallHasKeyAtWhenNoLocatedItemsExist() {
        Building buildingWithNoKeys = new Building("hasNoKeys");
        assertFalse(buildingWithNoKeys.hasKeyAt(new Coordinates(0, 1)));
    }

    @Test
    public void doesNotHaveKeyAtSpecifiedCoords() {
        Building buildingWithKeyAtX0Y1 = new Building("buildingWithKeyAtX0Y1", 0);
        game.addKeyToBuildingItemList(buildingWithKeyAtX0Y1, new Coordinates(0, 1));
        assertFalse(buildingWithKeyAtX0Y1.hasKeyAt(new Coordinates(0,0)));
    }

    @Test
    public void canSetKeyListInBuilding() {
        Building buildingWithKeyAtX0Y1 = new Building("buildingWithKeyAtX0Y1", 0);
        Coordinates coords = new Coordinates(0, 1);
        game.addKeyToBuildingItemList(buildingWithKeyAtX0Y1, coords);
        assertTrue(buildingWithKeyAtX0Y1.hasKeyAt(coords));
    }
    @Ignore
    @Test
    public void canAddKeyToInventoryByWalkingOnATileWithAKey() {

    }
}
