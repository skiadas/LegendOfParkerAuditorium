package core;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class LocationTest {
    @Test
    public void canCreateLocation(){
        PlayerLocation l = new PlayerLocation();
    }

    @Test
    @Ignore
    public void notInBuilding(){
        PlayerLocation location = new PlayerLocation();
        assertFalse(location.isBuildingLocation());
    }

}
