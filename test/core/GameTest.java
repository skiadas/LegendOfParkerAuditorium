package core;

import core.action.StartGameAction;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

public class GameTest {
    @Test
    public void canCreateGame(){
        List<Building> buildings = new ArrayList<>();
        buildings.add(new AlphaBuilding());
        buildings.add(new BetaBuilding());
        Interactor i = new Interactor();
        i.perform(new StartGameAction());
        List<Building> currentBuilings = i.getBuildings();
        for (int j = 0; j < buildings.size(); j++) {
            assertThat(buildings.get(j), instanceOf(currentBuilings.get(j).getClass()));
        }
    }

//    @Ignore
//    @Test
//    public void canAddBuildings() {
//        Game game = new Game();
//        Building building1 = new Building(false);
//        game.addBuildings(building1);
//        assertEquals(building1, game.getBuildingAtIndex(0));
//        Building building2 = new Building(false);
//        game.addBuildings(building2);
//        assertEquals(building2, game.getBuildingAtIndex(1));
//    }

//    @Ignore
//    @Test
//    public void createAvailableBuildings(){
//        Game game = new Game();
//        Building building1 = new Building(true);
//        Building building2 = new Building(false);
//        Building building3 = new Building(false);
//        Building building4 = new Building(true);
//        game.addBuildings(building1);
//        game.addBuildings(building2);
//        game.addBuildings(building3);
//        game.addBuildings(building4);
//        List <Building> availableBuildings1 = new ArrayList<>();
//        availableBuildings1.add(building1);
//        availableBuildings1.add(building4);
//        assertEquals(availableBuildings1, game.produceAvailableBuildings());
//
//
//    }
}
