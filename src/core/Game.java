package core;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static List<Building> buildings = new ArrayList<>();
    private final Inventory inventory = new Inventory();
    private final Location location = new Location(true);
    //fix this later

    public Game() {
        buildings = new ArrayList<>();
    }

    public void addBuildings(Building building){
        buildings.add(building);
    }
}
