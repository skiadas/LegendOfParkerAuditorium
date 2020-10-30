package core;

public class WithinBuildingLocation implements Location {
    private Building currentBuilding;
    private Coordinates coordinates;
    private boolean isBuildingEnterSquare;

    public WithinBuildingLocation(Building building, Coordinates coordinates) {
        currentBuilding = building;
        this.coordinates = coordinates;
    }

    static WithinBuildingLocation atEntranceOf(Building building) {
        return new WithinBuildingLocation(building,
                                          building.getEntranceCoordinates());
    }

    @Override
    public boolean isBuildingLocation() {
        return currentBuilding == null;
    }

}
