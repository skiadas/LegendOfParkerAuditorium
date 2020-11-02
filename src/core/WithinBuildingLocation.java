package core;

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

    @Override
    public boolean isBuildingLocation() {
        return true;
    }
}
