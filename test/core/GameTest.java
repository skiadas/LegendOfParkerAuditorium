package core;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {


    @Test
    public void canAddBuildings() {
        Game game = new Game();
        Building building1 = new Building("building1", 1);
        game.addBuilding(building1);
        assertEquals(building1, game.getBuildingAtIndex(0));
        Building building2 = new Building("building1", 1);
        game.addBuilding(building2);
        assertEquals(building2, game.getBuildingAtIndex(1));
    }


    @Test
    public void createAvailableBuildings(){
        Game game = new Game();
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

    // TODO: Set Inventory rather than addKeys
    // TODO: Use Random Int rather than set number

    @Test
    public void canEnterBuildingWithEnoughKeys() {
        Game game = new Game();
        Building building = new Building("building1", 3);
        game.addBuilding(building);
        game.getInventory().addKeys(3);
        assertTrue(game.hasAccessTo(building));
    }

    @Test
    public void canEnterBuildingWithMoreThanEnoughKeys() {
        Game game = new Game();
        Building building = new Building("building1", 1);
        game.addBuilding(building);
        game.getInventory().addKeys(3);
        assertTrue(game.hasAccessTo(building));
    }

    @Test
    public void cannotEnterBuildingWithoutEnoughKeys() {
        Game game = new Game();
        Building building = new Building("building1", 1);
        game.addBuilding(building);
        assertFalse(game.hasAccessTo(building));
    }
}
