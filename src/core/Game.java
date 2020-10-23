package core;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Building> buildings;
    private final Inventory inventory = new Inventory();
    private final Location location = new Location(true);
    //fix this later

    public Game() {
        this.buildings = new ArrayList<>();
    }

    public void addBuildings(Building building){
        this.buildings.add(building);
    }

    public Building getBuildingAtIndex(int index){
        return this.buildings.get(index);
    }

    public List<Building> getBuildings(){
        return  this.buildings;
    }

    public List<Building> produceAvailableBuildings() {
        List<Building> availableBuildings = new ArrayList<>();
        for (Building building : buildings){
            if (building.canEnter()){
                availableBuildings.add(building);
            }
        }
        return availableBuildings;

    }
}
