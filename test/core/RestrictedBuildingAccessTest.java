package core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RestrictedBuildingAccessTest {
    @Test
    public void canCreateBuilding() {
        Building levelOne = new Building(true);
    }
    @Test
    public void canLimitBuildingEntrance() {
        Building levelOne = new Building(true);
        Building levelTwo = new Building(false);
        assertEquals(true, levelOne.canEnter());
        assertEquals(false, levelTwo.canEnter());
    }
}
