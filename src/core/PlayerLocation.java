package core;

public class PlayerLocation implements Location {
    private Building currentBuilding;
    private boolean isBuildingEnterSquare;

    public PlayerLocation(){
        this.currentBuilding = null;
    }

    public PlayerLocation(boolean isBuildingEnterSquare) {
        this.isBuildingEnterSquare = isBuildingEnterSquare;
    }
    @Override
    public boolean isBuildingLocation() {
        return currentBuilding == null;
    }

    @Override
    public void setCurrentBuilding(Building building){
    }

    @Override
    public boolean isBuildingEntrance() {
        return isBuildingEnterSquare;
    }
}
