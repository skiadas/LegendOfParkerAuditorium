package core;

import core.action.StartGameAction;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class GameTest {

    @Ignore
    @Test
    public void canAddBuildings() {
        Game game = new Game();
        Building building1 = new Building(false);
        game.addBuildings(building1);
        assertEquals(building1, game.getBuildingAtIndex(0));
        Building building2 = new Building(false);
        game.addBuildings(building2);
        assertEquals(building2, game.getBuildingAtIndex(1));
    }

    @Ignore
    @Test
    public void createAvailableBuildings(){
        Game game = new Game();
        Building building1 = new Building(true);
        Building building2 = new Building(false);
        Building building3 = new Building(false);
        Building building4 = new Building(true);
        game.addBuildings(building1);
        game.addBuildings(building2);
        game.addBuildings(building3);
        game.addBuildings(building4);
        List <Building> availableBuildings1 = new ArrayList<>();
        availableBuildings1.add(building1);
        availableBuildings1.add(building4);
        assertEquals(availableBuildings1, game.produceAvailableBuildings());


    }

    @Test
    public void canSetLocationWithPermission() {
        Game game = new Game();
        Building building = new Building(true);
        game.addBuildings(building);
        assertThat(new OkResult(), instanceOf(game.setLocation(building).getClass()));
    }

    @Test
    public void canSetLocationWithoutPermission() {
        Game game = new Game();
        Building building = new Building(false);
        game.addBuildings(building);
        assertThat(new NegativeResult(), instanceOf(game.setLocation(building).getClass()));
    }

    @Test
    public void canUnlockBuildingsByCurrentKeysInInventory() {
        Game game = new Game();
        Building building1 = new Building(true);
        Building building2 = new Building(false);
        game.addBuildings(building1);
        game.addBuildings(building2);
        game.getInventory().addKey();
        game.getInventory().addKey();
        game.unlockBuildingsByCurrentKeysInInventory();
        assertTrue(game.getBuildingAtIndex(0).canEnter());
        assertTrue(game.getBuildingAtIndex(1).canEnter());
    }
}
