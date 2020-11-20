package core;

import core.boundary.BuildingView;
import core.boundary.Coordinates;
import core.boundary.EnemyView;
import core.game.Building;
import core.game.Enemy;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BuildingConvertTest {

    @Test
    public void getBuildingViewInfoTest() {
        String name = "b1";
        int numOfkeys = 2;
        Coordinates upperLeft = new Coordinates(-20, 20);
        Coordinates lowerRight = new Coordinates(20,-20);
        Coordinates entrance = new Coordinates(0,0);
        Building building = new Building(name, numOfkeys);
        BuildingView bv = BuildingConvert.getBuildingViewInfo(building);
        assertEquals(name, bv.getName());
        assertEquals(entrance, bv.getEntranceCoordinates());
        assertEquals(upperLeft, bv.getUpperLeft());
        assertEquals(lowerRight, bv.getLowerRight());
        assertEquals(new ArrayList<>(), bv.getEnemyList());
    }

    @Test
    public void getEnemyViewInfotest() throws Exception {
        Building building = new Building("b1",0);
        Enemy enemy = new Enemy();
        Coordinates cords = new Coordinates(3,0);
        building.addEnemy(enemy,cords);
        EnemyView ev = BuildingConvert.getEnemyViewInfo(enemy);
        assertEquals(cords,ev.getCords());
    }
}