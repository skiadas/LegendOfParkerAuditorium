package core;

import core.boundary.BuildingView;
import core.boundary.EnemyView;
import core.game.Building;
import core.game.Enemy;

public class BuildingConvert{

    public static BuildingView getBuildingViewInfo(Building building) {
        return new BuildingView(building.getBuildingName(),
                                building.getEntrance(),
                                building.getLowerRight(), building.getUpperLeft(), building.getListOfEnemies());
    }


    public static EnemyView getEnemyViewInfo(Enemy enemy){
        return new EnemyView(enemy.getEnemyCords());
    }
}
