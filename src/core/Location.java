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
}
