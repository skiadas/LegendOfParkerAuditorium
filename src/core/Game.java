package core;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static List<Building> availableBuildings = new ArrayList<>();
    private final Inventory inventory = new Inventory();
    private final Location location = new Location(true);
    //fix this later

    public Game() {
    }
}
