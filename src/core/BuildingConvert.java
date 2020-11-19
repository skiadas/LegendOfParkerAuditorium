package core;

public class BuildingConvert{

    public static BuildingView getBuildingViewInfo(Building building) {
        return new BuildingView(building.getBuildingName(),
                                building.getEntrance(), building.getRequiredNumOfKeys(),
                                building.getLowerRight(), building.getUpperLeft(), building.getListOfEnemies());
    }


    public static EnemyView getEnemyViewInfo(Enemy enemy){
        return new EnemyView(enemy.getEnemyCords());
    }
}
