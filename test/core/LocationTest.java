package core;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class LocationTest {
    @Test
    public void canCreateLocation(){
        Location l = new Location();
    }

    @Test
    public void notInBuilding(){
        Location location = new Location();
        assertFalse(location.isBuildingLocation());
    }

}
