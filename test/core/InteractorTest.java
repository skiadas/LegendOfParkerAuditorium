package core;

import core.action.EnterTheBuilding;
import core.action.StartGameAction;
import core.action.MovementAction;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class InteractorTest {

    @Ignore
    @Test
    public void canCreateGame(){
        Interactor i = new Interactor();
        StartGameAction start = new StartGameAction();
        i.perform(start);
        assertEquals(true ,i.getGame().gameStarted);
    }

    @Ignore
    @Test
    public void canMoveUp() {
        Interactor i = new Interactor();
        MovementAction moveUp = MovementAction.up();
        i.perform(moveUp);
        assertEquals(1, getyValue(i));
    }

    @Ignore
    @Test
    public void canMoveUpMultipleTimes() {
        Interactor i = new Interactor();
        MovementAction moveUp = MovementAction.up();
        i.perform(moveUp);
        i.perform(moveUp);
        i.perform(moveUp);
        assertEquals(3, getyValue(i));
    }

    private int getyValue(Interactor i) {
        return i.getGame().getInsideLocation().yValue;
    }

    @Test
    public void canEnterTheBuilding() {
        // delegation.
        // See canSetLocationWithPermission() and canSetLocationWithoutPermission() test in GameTest
    }

    @Test
    public void unlockBuildingTest() {
        // delegation.
        // See canUnlockBuildingsByCurrentKeysInInventory() test in GameTest
    }
}
