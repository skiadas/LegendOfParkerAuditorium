package core;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuildingSelectionTests {

    @Test
    public void canCreateGame() {
        Game game = new Game();
    }



    @Test
    public void canCreateSelectBuildingAction() {
        UserAction playerAction = new SelectBuildingAction(1);
    }

    @Ignore
    @Test
    public void canSelectBuildingNumberOne() {
        UserAction playerAction = new SelectBuildingAction(1);
        //assertEquals("Donner", playerAction.getLocation());
    }
}
