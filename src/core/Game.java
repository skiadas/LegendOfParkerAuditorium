package core;

import core.exceptions.InvalidCoordinateAccessorException;
import core.exceptions.InvalidMovementException;

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
            throw new InvalidCoordinateAccessorException();
        }
    }

    public void setCoordinates(Coordinates coordinates) {
        if (location.isBuildingLocation()) {
            ((WithinBuildingLocation) location).setCoordinates(coordinates);
        } else {
            throw new InvalidCoordinateAccessorException();
        }
    }

    public Building getCurrentBuilding() {
        if (location.isBuildingLocation()) {
            return ((WithinBuildingLocation) location).getCurrentBuilding();
        } else {
            throw new GameErrorException(MessageFactory.getInstance().mapLocationHasNoCurrentBuilding());
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
        if (isValidLocation(direction)) {
            setCoordinates(getRequestedMove(direction));
        }
        else {
            throw new InvalidMovementException();
        }
    }

    private boolean isValidLocation(Direction direction) {
        return getCurrentBuilding().isValidMovement(getRequestedMove(direction));
    }

    private Coordinates getRequestedMove(Direction direction) {
        return getCoords().getRequestedMove(direction);
    }

    public boolean hasBuildingNamed(String name) {
        for (Building building: buildings) {
            if(building.isNamed(name))
                return true;
        }
        return false;
    }

    public Building getBuildingNamed(String name) {
        if (isWithinABuilding()) {
            throw new GameErrorException(MessageFactory.getInstance().mustExistBuilding());
        }
        for (Building building: produceAvailableBuildings()) {
            if(building.isNamed(name))
                return building;
        }
        throw new NonExistingBuildingError();
    }

    public boolean isSelectedBuildingInAvailableBuildingsList(String name) {
        for (Building chosenBuilding: produceAvailableBuildings()) {
            if(chosenBuilding.isNamed(name))
                return true;
        }
        return false;
    }

    public boolean canExitBuilding(){
        return isWithinABuilding() && getCoords().equals(getCurrentBuilding().getEntranceCoordinates());
    }

    boolean hasAccessTo(Building b){
        return inventory.getNumberOfKeys() >= b.getRequiredNumOfKeys();
    }

    void setInventory(int amountOfKeys) { inventory.addKeys(amountOfKeys);}

    public void addKeyToBuildingItemList(Building building, Coordinates coords) {
        building.addLocatedItem(coords);
    }

    public class ExistingBuildingError extends GameErrorException {
        public ExistingBuildingError(String message) {
            super(message);
        }
    }


}
