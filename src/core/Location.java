package core;

public class Location {
    private Building currentBuilding;
    public Location(){
        this.currentBuilding = null;
    }

    public boolean isBuildingLocation() {
        return currentBuilding == null;
    }

    public void setCurrentBuilding(Building building){
    }
    private final boolean isBuildingEnterSquare;

    public Location(boolean isBuildingEnterSquare) {
        this.isBuildingEnterSquare = isBuildingEnterSquare;
    }

    public boolean isBuildingEntrance() {
        return isBuildingEnterSquare;
    }
}
