package core;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WithinBuildingLocationTest {

    private Building building;
    private Coordinates coordinates;
    private WithinBuildingLocation wbl;

    @Before
    public void setUp() {
        building = new Building("A", 0);
        coordinates = new Coordinates(1, 1);
        wbl = new WithinBuildingLocation(building, coordinates);
    }

    @Test
    public void CreatingWithinBuilidingLocationWith_atEntranceOf() {
        WithinBuildingLocation wbl = WithinBuildingLocation.atEntranceOf(building);
        assertEquals(building, wbl.getCurrentBuilding());
        assertEquals(building.getEntranceCoordinates(), wbl.getCoords());
    }

    @Test
    public void gettingPlayerLocationInsideTheBuilding() {
        assertEquals(coordinates, wbl.getCoords());
    }

    @Test
    public void canSetCoorinates () {
        Coordinates coord2 = new Coordinates(2, 2);
        assertNotEquals(coord2, wbl.getCoords());
        wbl.setCoordinates(coord2);
        assertEquals(coord2, wbl.getCoords());
    }

    @Test
    public void canGetCurrentBuilding() {
        assertEquals(building, wbl.getCurrentBuilding());
    }

    @Test
    public void CanCheckIfPlayerIsBuildingLocation() {
        assertTrue(wbl.isBuildingLocation());
    }

    @Test
    public void canGetRequestedMove() {
       WithinBuildingLocation wbl2 = new WithinBuildingLocation(building,
               new Coordinates(0,1));
       wbl2.getRequestedMove(Direction.right);
       assertEquals(wbl, wbl2);
    }
}