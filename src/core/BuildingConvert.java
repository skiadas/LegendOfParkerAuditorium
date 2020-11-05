package core;

public class BuildingConvert{

    public static BuildingView getBuildingViewInfo(Building building) {
        building.getBuildingName();
        building.getEntranceCoordinates();
        building.getRequiredNumOfKeys();
        return new BuildingView();
    }
}
