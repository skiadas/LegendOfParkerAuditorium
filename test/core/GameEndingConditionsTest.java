package core;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameEndingConditionsTest {
    private final Game game = new Game();
    @Test
    public void checkPlayerDeathState() {
        //TODO : Use implementation of player 'death' from issue #10 to write a Game-over state and test for it

    }

    @Test
    public void canSetFinalBuilding() {
        Building building = new Building("building");
        game.addBuilding(building);
        game.getBuildingNamed("building").setFinalBuilding();
        assertTrue(game.getBuildingNamed("building").getIsFinalBuilding());

    }

    @Test
    public void canGetWinCondition() {
        Building building = new Building("building");
        game.addBuilding(building);
        game.getBuildingNamed("building").setFinalBuilding();
        //TODO: Throw 'win' state when the player has exited the FinalBuilding through an 'exit cell' which is separate from the 'entrance cell'
    }
}
