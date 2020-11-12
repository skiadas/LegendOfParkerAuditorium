package core;

import java.util.Objects;

public class WithinBuildingLocation implements Location {
    private Building currentBuilding;
    private Coordinates coordinates;

    public WithinBuildingLocation(Building building, Coordinates coordinates) {
        currentBuilding = building;
        this.coordinates = coordinates;
    }

    static WithinBuildingLocation atEntranceOf(Building building) {
        return new WithinBuildingLocation(building,
                                          building.getEntranceCoordinates());
    }

    Coordinates getCoords() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Building getCurrentBuilding() {
        return currentBuilding;
    }

    @Override
    public boolean isBuildingLocation() {
        return true;
    }


    public Location getRequestedMove(Direction direction) {
        this.coordinates = coordinates.getRequestedMove(direction);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WithinBuildingLocation that = (WithinBuildingLocation) o;
        return Objects.equals(currentBuilding, that.currentBuilding) &&
                Objects.equals(coordinates, that.coordinates);
    }

}
