package core;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuildingConvertTest {

    @Test
    public void getBuildingViewInfoTest() {
        String name = "b1";
        int numOfkeys = 2;
        Coordinates upperLeft = new Coordinates(-20,20);
        Coordinates lowerRight = new Coordinates(20,-20);
        Coordinates entrance = new Coordinates(0,0);
        Building building = new Building(name, numOfkeys);
        BuildingView bv = BuildingConvert.getBuildingViewInfo(building);
        assertEquals(name, bv.getName());
        assertEquals(numOfkeys, bv.getRequiredNumOfKey());
        assertEquals(entrance, bv.getEntranceCoordinates());
        assertEquals(upperLeft, bv.getUpperLeft());
        assertEquals(lowerRight, bv.getLowerRight());
    }
}