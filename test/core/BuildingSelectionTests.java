package core;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildingSelectionTests {

    @Test
    public void canCreateGame() {
        Game game = new Game();
        //assertEquals("Outside", game.getbuilding());
    }

    @Test
    public void canCreateInteractor() {
        Interactor user = new Interactor();
    }

    @Test
    public void canCreateLocationOnMap() {
        Location square = new Location();
    }

    @Test
    public void canCreateSelectBuildingAction() {
        SelectBuildingAction playerAction = new SelectBuildingAction(1);
        assertEquals(1, playerAction.getNum());
    }

    @Test
    public void canCreateSelectBuildingActionWith0() {
        SelectBuildingAction playerAction = new SelectBuildingAction(0);
        assertEquals(0, playerAction.getNum());
    }

    @Test
    public void canSelectBuildingNumberOne() {
        SelectBuildingAction selectBuildingAction = new SelectBuildingAction(1);
    }

    @Test
    @Ignore
    public void cannotSelectBuildingWithInvalidNumber() {
        UserAction playerAction = new SelectBuildingAction(-1);
        Location location = new Location();
        assertFalse(location.isBuildingLocation());
    }
}
