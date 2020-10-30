package core;

import core.action.SelectBuildingAction;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Building> buildings;
    private final Inventory inventory = new Inventory();
    private Location location = new MapLocation();
    private Coordinates coords = new Coordinates(0, 0);
    public Boolean gameStarted;

    public Game() {
        this.buildings = new ArrayList<>();
        this.gameStarted = true;
    }

    public Coordinates getCoords() {
        return coords;
    }

    public void addBuildings(Building building) {
        this.buildings.add(building);
    }

    public Building getBuildingAtIndex(int index) {
        return this.buildings.get(index);
    }

    public List<Building> getBuildings() {
        return this.buildings;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public List<Building> produceAvailableBuildings() {
        List<Building> availableBuildings = new ArrayList<>();
        for (Building building : buildings) {
            if (building.canEnter()) {
                availableBuildings.add(building);
            }
        }
        return availableBuildings;

    }

    public int sizeOfBuildingList() {
        return buildings.size();
    }

    public Result enterBuilding(Building building) {
        if (building.canEnter()) {
            location = WithinBuildingLocation.atEntranceOf(building);
            return new OkResult();
        } else {
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

    boolean isNotWithinABuilding() {
        return !location.isBuildingLocation();
    }

    int getYValue() {
        return getCoords().yValue;
    }

    int getXValue() {
        return getCoords().xValue;
    }

    void updatePosition(Direction direction) {
        getCoords().updatePosition(direction);
    }
}
