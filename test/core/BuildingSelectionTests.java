package core;

import org.junit.Test;

public class BuildingSelectionTests {

    @Test
    public void canCreateSelectBuildingAction() {
        UserAction user = new SelectBuildingAction(1);
    }
}
