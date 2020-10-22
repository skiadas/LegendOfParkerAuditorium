package core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovementInsideBuildingTest {

    @Test
    public void playerStartsAtCorrectCoordinates() {
        WithinBuildingLocation withinBuildingLocation = new WithinBuildingLocation(1, 1);
        assertEquals(1, withinBuildingLocation.xValue);
        assertEquals(1, withinBuildingLocation.yValue);
    }

    @Test
    public void playerCanMovePositiveX() {
        WithinBuildingLocation withinBuildingLocation = new WithinBuildingLocation(1, 1);
        withinBuildingLocation.moveX(2);
        assertEquals(3, withinBuildingLocation.xValue);
    }

    @Test
    public void playerCanMoveNegativeX() {
        WithinBuildingLocation withinBuildingLocation = new WithinBuildingLocation(3, 1);
        withinBuildingLocation.moveX(-2);
        assertEquals(1, withinBuildingLocation.xValue);
    }

    @Test
    public void playerCanMovePositiveY() {
        WithinBuildingLocation withinBuildingLocation = new WithinBuildingLocation(1, 1);
        withinBuildingLocation.moveY(2);
        assertEquals(3, withinBuildingLocation.yValue);
    }

    @Test
    public void playerCanMoveNegativeY() {
        WithinBuildingLocation withinBuildingLocation = new WithinBuildingLocation(1, 3);
        withinBuildingLocation.moveY(-2);
        assertEquals(1, withinBuildingLocation.yValue);
    }
}
