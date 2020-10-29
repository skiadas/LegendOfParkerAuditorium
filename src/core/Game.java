package core;

import core.action.MovementAction;

import core.action.SelectBuildingAction;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Building> buildings;
    private final Inventory inventory = new Inventory();
    private final PlayerLocation location = new PlayerLocation(true);
    private final WithinBuildingLocation insideLocation = new WithinBuildingLocation(0, 0);
    public Boolean gameStarted;
    //fix this later

    public Game() {
        this.buildings = new ArrayList<>();
        this.gameStarted = true;
    }

    public WithinBuildingLocation getInsideLocation() {
        return insideLocation;
    }

    public void updateY(int amount) {
        int current = insideLocation.getyValue();
        current += amount;
        insideLocation.setyValue(current);
    }

    public void updateX(int amount) {
        int current = insideLocation.getxValue();
        current += amount;
        insideLocation.setxValue(current);
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

    boolean isValidIndex(SelectBuildingAction action, Interactor interactor) {
        return getBuildingAtIndex(action.getSelectedBuildingNum()).canEnter();
    }
    public void updatePosition(MovementAction action) {
        switch (action.direction) {
            case up:
                updateY(MovementAction.SPEED);
                break;
            case down:
                updateY(-MovementAction.SPEED);
                break;
            case left:
                updateX(-MovementAction.SPEED);
                break;
            case right:
                updateX(MovementAction.SPEED);
                break;
            default:
                break;
        }
    }
}
