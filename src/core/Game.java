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

    private Building getCurrentBuilding() {
        if (location.isBuildingLocation()) {
            return ((WithinBuildingLocation) location).getCurrentBuilding();
        } else {
            throw new RuntimeException("Should not access the current building for non-building");
        }
    }

    public void addBuilding(Building building) {
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
            if (hasAccessTo(building)) {
                availableBuildings.add(building);
            }
        }
        return availableBuildings;

    }

    public int sizeOfBuildingList() {
        return buildings.size();
    }

    public Result enterBuilding(Building building) {
        if (hasAccessTo(building)) {
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
        if (isValidMovement(direction)) {
            getCoords().updatePosition(direction);
        }
        else {
            throw new RuntimeException("invalid movement tile");
        }
    }

    private boolean isValidMovement(Direction direction) {
        return getCurrentBuilding().isValidMovement(getCoords().getRequestedMove(direction));
    }

    public boolean hasBuildingNamed(String name) {
        for (Building chosenBuilding: buildings) {
            if(chosenBuilding.getBuildingName().equals(name))
                return true;
        }
        return false;
    }

    public Building getBuildingNamed(String name) {
        for (Building chosenBuilding: buildings) {
            if(isSelectedBuildingInAvailableBuildingsList(name))
                return chosenBuilding;
        }
        throw new RuntimeException("Building does not exist!");
    }

    public boolean isSelectedBuildingInAvailableBuildingsList(String name) {
        for (Building chosenBuilding: buildings) {
            if(chosenBuilding.getBuildingName().equals(name) && hasAccessTo(chosenBuilding))
                return true;
        }
        return false;
    }

    boolean hasAccessTo(Building b){
        return inventory.getNumberOfKeys() >= b.getRequiredNumOfKeys();
    }

    void setInventory(int amountOfKeys) { inventory.addKeys(amountOfKeys);}

    public void addKeyToBuildingItemList(Building building, Coordinates coords) {
        building.addLocatedItem(coords);
    }
}
