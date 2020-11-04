package core;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class GameTest {


    @Test
    public void canAddBuildings() {
        Game game = new Game();
        Building building1 = new Building("building1", 1);
        game.addBuildings(building1);
        assertEquals(building1, game.getBuildingAtIndex(0));
        Building building2 = new Building("building1", 1);
        game.addBuildings(building2);
        assertEquals(building2, game.getBuildingAtIndex(1));
    }


    @Test
    public void createAvailableBuildings(){
        Game game = new Game();
        Building building1 = new Building("building1", 0);
        Building building2 = new Building("building2", 1);
        Building building3 = new Building("building3", 1);
        Building building4 = new Building("building4", 0);
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
    public void canSetLocationWithEnoughKeys() {
        Game game = new Game();
        Building building = new Building("building1", 3);
        game.addBuildings(building);
        game.getInventory().addKeys(3);
        assertThat(new OkResult(), instanceOf(game.enterBuilding(building).getClass()));
    }

    @Test
    public void cannotSetLocationWithoutKeys() {
        Game game = new Game();
        Building building = new Building("building1", 1);
        game.addBuildings(building);
        assertThat(new NegativeResult(), instanceOf(game.enterBuilding(building).getClass()));
    }
}
