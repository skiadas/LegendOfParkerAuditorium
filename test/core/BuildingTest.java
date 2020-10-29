package core;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BuildingTest {
    @Test
    public void canLimitBuildingEntrance() {
        Building levelOne = new Building("building1", true);
        Building levelTwo = new Building("building2", false);
        assertTrue(levelOne.canEnter());
        assertFalse(levelTwo.canEnter());
    }
}
