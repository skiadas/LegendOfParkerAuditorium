package core;

import core.exceptions.GameErrorException;
import core.boundary.Coordinates;
import core.location.Location;
import core.location.MapLocation;
import core.location.WithinBuildingLocation;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Building> buildings;
    private final Inventory inventory = new Inventory();
    public Boolean gameStarted;
    private Location location = new MapLocation();

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
            throw GameErrorException.playerCannotMove();
        }
    }

    public void setCoordinates(Coordinates coordinates) {
        if (location.isBuildingLocation()) {
            ((WithinBuildingLocation) location).setCoordinates(coordinates);
        } else {
            throw GameErrorException.playerCannotMove();//InvalidCoordinateAccessorException();
        }
    }

    public Building getCurrentBuilding() {
        if (location.isBuildingLocation()) {
            return ((WithinBuildingLocation) location).getCurrentBuilding();
        } else {
            throw GameErrorException.mapLocationHasNoCurrentBuilding();
        }
    }

    public void addBuilding(Building building) {
        for (Building buildingInList: buildings) {
            if (buildingInList.equals(building)) {
                return;
            }
        }
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

    void setInventory(int amountOfKeys) {
        inventory.addKeys(amountOfKeys);
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

    public void enterBuilding(Building building) {
        if (hasAccessTo(building)) {
            location = WithinBuildingLocation.atEntranceOf(building);
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
        if (isValidLocation(direction)) {
            setCoordinates(getRequestedMove(direction));
        } else {
            throw GameErrorException.playerCannotMove();
        }
    }

    private boolean isValidLocation(Direction direction) {
        return getCurrentBuilding().isValidMovement(getRequestedMove(direction));
    }

    private Coordinates getRequestedMove(Direction direction) {
        return getCoords().getRequestedMove(direction);
    }

    public boolean hasBuildingNamed(String name) {
        for (Building building : buildings) {
            if (building.isNamed(name))
                return true;
        }
        return false;
    }

    public Building getBuilding(String name) {
        if (!isSelectedBuildingInBuildingsList(name))
            throw GameErrorException.buildingDoesNotExist();
        for (Building building : produceAvailableBuildings()) {
            if (building.isNamed(name))
                return building;
        }
        throw GameErrorException.notInAvailableBuildingsList();
    }

    public boolean isSelectedBuildingInAvailableBuildingsList(String name) {
        for (Building chosenBuilding : produceAvailableBuildings()) {
            if (chosenBuilding.isNamed(name))
                return true;
        }
        return false;
    }

    public boolean isSelectedBuildingInBuildingsList(String name) {
        for (Building chosenBuilding : buildings) {
            if (chosenBuilding.isNamed(name))
                return true;
        }
        return false;
    }

    public boolean canExitBuilding() {
        return isWithinABuilding() && ((WithinBuildingLocation) location).isOnTheEntranceCell();
    }

    boolean hasAccessTo(Building b) {
        return inventory.getNumberOfKeys() >= b.getRequiredNumOfKeys();
    }

    public void addKeyToBuildingItemList(Building building, Coordinates coords) {
        building.addLocatedItem(coords);
    }
}
