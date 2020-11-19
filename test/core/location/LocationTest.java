package core.location;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class LocationTest {

    @Test
    public void whenOnMapLocation_youAreNotInBuilding(){
        Location location = new MapLocation();
        assertFalse(location.isBuildingLocation());
    }

}
