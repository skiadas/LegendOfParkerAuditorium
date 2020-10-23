package core;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameTest {
    @Test
    public void canCreateGame(){
        List<Building> buildings = new ArrayList<>();
        Game game = new Game();
        assertEquals(buildings, game.getBuildings());
    }

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
}
