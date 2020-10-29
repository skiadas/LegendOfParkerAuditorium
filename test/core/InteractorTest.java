package core;

import core.action.MovementAction;
import core.action.StartGameAction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InteractorTest {

    @Test
    public void canCreateGame(){
        Interactor i = new Interactor();
        StartGameAction start = new StartGameAction();
        i.perform(start);
        assertEquals(true ,i.getGame().gameStarted);
    }

    @Test
    public void canMoveUp() {
        Interactor i = new Interactor();
        MovementAction moveUp = MovementAction.up();
        i.setGame(new Game());
        i.perform(moveUp);
        assertEquals(1, getyValue(i));
    }

    @Test
    public void canMoveUpMultipleTimes() {
        Interactor i = new Interactor();
        MovementAction moveUp = MovementAction.up();
        i.setGame(new Game());
        i.perform(moveUp);
        i.perform(moveUp);
        i.perform(moveUp);
        assertEquals(3, getyValue(i));
    }

    @Test
    public void canMoveDown() {
        Interactor i = new Interactor();
        MovementAction moveDown = MovementAction.down();
        i.setGame(new Game());
        i.perform(moveDown);
        assertEquals(-1, getyValue(i));
    }

    @Test
    public void canMoveDownMultipleTimes() {
        Interactor i = new Interactor();
        MovementAction moveDown = MovementAction.down();
        i.setGame(new Game());
        i.perform(moveDown);
        i.perform(moveDown);
        i.perform(moveDown);
        assertEquals(-3, getyValue(i));
    }

    @Test
    public void canMoveLeft() {
        Interactor i = new Interactor();
        MovementAction moveLeft = MovementAction.left();
        i.setGame(new Game());
        i.perform(moveLeft);
        assertEquals(-1, getxValue(i));
    }

    @Test
    public void canMoveLeftMultipleTimes() {
        Interactor i = new Interactor();
        MovementAction moveLeft = MovementAction.left();
        i.setGame(new Game());
        i.perform(moveLeft);
        i.perform(moveLeft);
        i.perform(moveLeft);
        assertEquals(-3, getxValue(i));
    }

    @Test
    public void canMoveRight() {
        Interactor i = new Interactor();
        MovementAction moveRight = MovementAction.right();
        i.setGame(new Game());
        i.perform(moveRight);
        assertEquals(1, getxValue(i));
    }

    @Test
    public void canMoveRightMultipleTimes() {
        Interactor i = new Interactor();
        MovementAction moveLeft = MovementAction.left();
        i.setGame(new Game());
        i.perform(moveLeft);
        i.perform(moveLeft);
        i.perform(moveLeft);
        assertEquals(-3, getxValue(i));
    }

    private int getxValue(Interactor i) {
        return i.getGame().getInsideLocation().xValue;
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
