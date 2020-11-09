package core;

public class BuildingConvert{

    public static BuildingView getBuildingViewInfo(Building building) {
        return new BuildingView(building.getBuildingName(),
                building.getEntranceCoordinates(), building.getRequiredNumOfKeys(),
                building.getLowerRight(), building.getUpperLeft());
    }

}
