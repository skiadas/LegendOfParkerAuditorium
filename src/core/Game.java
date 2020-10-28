package core;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Building> buildings;
    private final Inventory inventory = new Inventory();
    private final PlayerLocation location = new PlayerLocation(true);
    public Boolean gameStarted = false;
    //fix this later
    private final WithinBuildingLocation insideLocation = new WithinBuildingLocation(0, 0);

    public Game() {
        this.buildings = new ArrayList<>();
        this.gameStarted = false;
    }

    public WithinBuildingLocation getInsideLocation() {
        return insideLocation;
    }

    public void updateY(int amount) {
        int current = insideLocation.getyValue();
        System.out.println("\nbefore " + current);
        current += amount;
        System.out.println("\nafter " + current);
        insideLocation.setyValue(current);
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

    public Inventory getInventory(){
        return inventory;
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

    public int sizeOfBuildingList() {
        return buildings.size();
    }

    public Result setLocation(Building building){
        if(building.canEnter()) {
            location.setCurrentBuilding(building);
            return new OkResult();
        }else{
            return new NegativeResult();
        }
    }


    boolean isInvalidIndex(int index) {
        return index < 0 || index > sizeOfBuildingList();
    }

    public void unlockBuildingsByCurrentKeysInInventory() {
        int numOfKeys = inventory.numberOfItems();
        for (int i = 0; i < numOfKeys; i++) {
            buildings.get(i).setPermissionToEnter(true);
        }
    }

}
