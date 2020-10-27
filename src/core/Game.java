package core;

import core.action.SelectBuildingAction;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Building> buildings;
    private final Inventory inventory = new Inventory();
    private final PlayerLocation location = new PlayerLocation(true);
    //fix this later
    private final WithinBuildingLocation insideLocation = new WithinBuildingLocation(0, 0);

    public Game() {
        this.buildings = new ArrayList<>();
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

    public void setLocation(Building building){
        location.setCurrentBuilding(building);
    }

    public boolean canEnterTheBuilding(int i){
        return i <= getNumOfKeysInInventory();
    }

    private int getNumOfKeysInInventory(){
        return inventory.numberOfItems();
    }

    boolean isInvalidIndex(int index) {
        return index < 0 || index > sizeOfBuildingList();
    }
}
