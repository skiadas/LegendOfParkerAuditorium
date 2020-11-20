package core.game;

import core.BaseAppTest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameEndingConditionsTest extends BaseAppTest {

    @Test
    public void canSetFinalBuilding() {
        addBuilding("building");
        game.getBuilding("building").setFinalBuilding();
        assertTrue(game.getBuilding("building").getIsFinalBuilding());

    }


}
