package core;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameTest {
    @Test
    public void canCreateGame(){
        List<Building> buildings = new ArrayList<>();
        assertEquals(buildings, Game.availableBuildings);
    }


}
