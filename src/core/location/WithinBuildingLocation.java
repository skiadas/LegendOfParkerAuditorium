package core.location;

import core.Building;
import core.boundary.Coordinates;

import java.util.Objects;

public class WithinBuildingLocation implements Location {
    private Building currentBuilding;
    private Coordinates coordinates;

    public WithinBuildingLocation(Building building, Coordinates coordinates) {
        currentBuilding = building;
        this.coordinates = coordinates;
    }

    public static WithinBuildingLocation atEntranceOf(Building building) {
        return new WithinBuildingLocation(building,
                                          building.getEntrance());
    }

    public Coordinates getCoords() {
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


    public boolean isOnTheEntranceCell() {
        return getCoords().equals(getCurrentBuilding().getEntrance());
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
