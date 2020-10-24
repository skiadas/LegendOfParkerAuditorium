package core;

public interface Location {
    boolean isBuildingLocation();
    void setCurrentBuilding(Building building);
    boolean isBuildingEntrance();
}
