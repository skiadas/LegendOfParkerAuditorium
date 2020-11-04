package core;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Building> buildings;
    private final Inventory inventory = new Inventory();
    private Location location = new MapLocation();
    public Boolean gameStarted;

    public Game() {
        this.buildings = new ArrayList<>();
        this.gameStarted = true;
    }

    void setLocation(Location location) {
        this.location = location;
    }

    public Coordinates getCoords() {
        if (location.isBuildingLocation()) {
            return ((WithinBuildingLocation) location).getCoords();
        } else {
            throw new RuntimeException("Should not access coords for non-building");
        }
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
            if (hasEnoughKeysToEnterTheBuilding(building)) {
                availableBuildings.add(building);
            }
        }
        return availableBuildings;

    }

    public int sizeOfBuildingList() {
        return buildings.size();
    }

    public Result enterBuilding(Building building) {
        if (hasEnoughKeysToEnterTheBuilding(building)) {
            location = WithinBuildingLocation.atEntranceOf(building);
            return new OkResult();
        } else {
            return new NegativeResult();
        }
    }

    boolean isNotWithinABuilding() {
        return !location.isBuildingLocation();
    }

    boolean isWithinABuilding() {
        return location.isBuildingLocation();
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

    public boolean isSelectedBuildingInBuildingList(String SelectBuildingName) {
        for (Building chosenBuilding: buildings) {
            if(chosenBuilding.getBuildingName().equals(SelectBuildingName))
                return true;
        }
        return false;
    }

    public Building getBuildingBasedOnName(String selectedBuildingName) {
        for (Building chosenBuilding: buildings) {
            if(chosenBuilding.getBuildingName().equals(selectedBuildingName))
                return chosenBuilding;
        }
        throw new RuntimeException("Sorry Building is not Listed");
    }

    public boolean isSelectedBuildingInAvailableBuildingsList(String selectedBuildingName) {
        for (Building chosenBuilding: buildings) {
            if(chosenBuilding.getBuildingName().equals(selectedBuildingName) && hasEnoughKeysToEnterTheBuilding(chosenBuilding))
                return true;
        }
        return false;
    }

    private boolean hasEnoughKeysToEnterTheBuilding(Building b){
        return inventory.numberOfItems() >= b.getRequiredNumOfKeys();
    }
}
