package core;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameEndingConditionsTest extends BaseAppTest {

    @Test
    public void canSetFinalBuilding() {
        Building building = new Building("building");
        game.addBuilding(building);
        game.getBuildingNamed("building").setFinalBuilding();
        assertTrue(game.getBuildingNamed("building").getIsFinalBuilding());

    }


}
