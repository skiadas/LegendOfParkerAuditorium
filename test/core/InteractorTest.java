package core;

import core.action.MovementAction;
import core.action.StartGameAction;
import mocks.PresenterStub;
import mocks.UpdateWithinBuildingLocationSpy;
import org.junit.Test;

import static org.junit.Assert.*;

public class InteractorTest {

    @Test
    public void canCreateGame() throws Interactor.GameAlreadyStartedException {
        Interactor i = new Interactor();
        PresenterStub mocks = new PresenterStub();
        i.setPresenter(mocks);
        StartGameAction start = new StartGameAction();
        i.perform(start);
        assertEquals(true ,i.getGame().gameStarted);
    }

    @Test (expected = Interactor.GameAlreadyStartedException.class)
    public void cannotStartGameInProgress() throws Interactor.GameAlreadyStartedException {
        Interactor i = new Interactor();
        i.game = new Game();
        StartGameAction start = new StartGameAction();
        i.perform(start);
    }

    @Test
    public void canMoveUp() {
        Interactor i = new Interactor();
        MovementAction moveUp = MovementAction.up();
        Game game = new Game();
        i.setGame(game);
        Building building = new Building("building1");
        game.enterBuilding(building);
        i.setPresenter(new PresenterStub());
        i.perform(moveUp);
        assertEquals(1, game.getYValue());
    }

    @Test
    public void canMoveUpMultipleTimes() {
        Interactor i = new Interactor();
        MovementAction moveUp = MovementAction.up();
        i.setGame(new Game());
        i.setPresenter(new PresenterStub());
        i.perform(moveUp);
        i.perform(moveUp);
        i.perform(moveUp);
        assertEquals(3, i.getGame().getYValue());
    }

    @Test
    public void canMoveDown() {
        Interactor i = new Interactor();
        MovementAction moveDown = MovementAction.down();
        i.setGame(new Game());
        i.setPresenter(new PresenterStub());
        i.perform(moveDown);
        assertEquals(-1, i.getGame().getYValue());
    }

    @Test
    public void canMoveDownMultipleTimes() {
        Interactor i = new Interactor();
        MovementAction moveDown = MovementAction.down();
        i.setGame(new Game());
        i.setPresenter(new PresenterStub());
        i.perform(moveDown);
        i.perform(moveDown);
        i.perform(moveDown);
        assertEquals(-3, i.getGame().getYValue());
    }

    @Test
    public void canMoveLeft() {
        Interactor i = new Interactor();
        MovementAction moveLeft = MovementAction.left();
        i.setGame(new Game());
        i.setPresenter(new PresenterStub());
        i.perform(moveLeft);
        assertEquals(-1, i.getGame().getXValue());
    }

    @Test
    public void canMoveLeftMultipleTimes() {
        Interactor i = new Interactor();
        MovementAction moveLeft = MovementAction.left();
        i.setGame(new Game());
        i.setPresenter(new PresenterStub());
        i.perform(moveLeft);
        i.perform(moveLeft);
        i.perform(moveLeft);
        assertEquals(-3, i.getGame().getXValue());
    }

    @Test
    public void canMoveRight() {
        Interactor i = new Interactor();
        MovementAction moveRight = MovementAction.right();
        i.setGame(new Game());
        i.setPresenter(new PresenterStub());
        i.perform(moveRight);
        assertEquals(1, i.getGame().getXValue());
    }

    @Test
    public void canMoveRightMultipleTimes() {
        Interactor i = new Interactor();
        MovementAction moveLeft = MovementAction.left();
        i.setGame(new Game());
        i.setPresenter(new PresenterStub());
        i.perform(moveLeft);
        i.perform(moveLeft);
        i.perform(moveLeft);
        assertEquals(-3, i.getGame().getXValue());
    }

    @Test
    public void whenMovementActionIsPerformed_UpdatePositionWasCalled() {
        Interactor i = new Interactor();
        MovementAction moveLeft = MovementAction.left();
        UpdateWithinBuildingLocationSpy mockPresenter = new UpdateWithinBuildingLocationSpy();
        i.setGame(new Game());
        i.setPresenter(mockPresenter);
        i.perform(moveLeft);
        assertTrue(mockPresenter.showUpdatePositionWasCalled);
        assertNotNull(mockPresenter.providedLocation);
        Coordinates expectedInsideLocation = new Coordinates(-1, 0);
        assertEquals(expectedInsideLocation, mockPresenter.providedLocation);
    }

    @Test
    public void cannotMoveWhenNotInsideBuilding() {
        Interactor i = new Interactor();
        MovementAction moveLeft = MovementAction.left();
        i.setGame(new Game());
        // TODO: set location to MapLocation
        i.setPresenter(new PresenterStub());
        // TODO: Take the action
        // TODO: Should test something
    }

    @Test
    public void cannotMoveWhenNoGameIsStarted() {
        // TODO: Implement
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
