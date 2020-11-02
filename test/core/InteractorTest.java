package core;

import core.action.MovementAction;
import core.action.StartGameAction;
import mocks.PresenterStub;
import mocks.UpdateWithinBuildingLocationSpy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InteractorTest {

    private Interactor i;

    @Before
    public void setUp() throws Exception {
        i = new Interactor();
    }

    @Test
    public void canCreateGame() throws Interactor.GameAlreadyStartedException {
        PresenterStub mocks = new PresenterStub();
        i.setPresenter(mocks);
        StartGameAction start = new StartGameAction();
        i.perform(start);
        assertEquals(true , i.getGame().gameStarted);
    }

    @Test (expected = Interactor.GameAlreadyStartedException.class)
    public void cannotStartGameInProgress() throws Interactor.GameAlreadyStartedException {
        i.game = new Game();
        StartGameAction start = new StartGameAction();
        i.perform(start);
    }

    @Test
    public void canMoveUp() {
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        i.setGame(game);
        i.setPresenter(new PresenterStub());
        i.perform(MovementAction.up());
        assertEquals(1, game.getYValue());
    }

    @Test
    public void canMoveUpMultipleTimes() {
        MovementAction moveUp = MovementAction.up();
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        i.setGame(game);
        i.setPresenter(new PresenterStub());
        i.perform(moveUp);
        i.perform(moveUp);
        i.perform(moveUp);
        assertEquals(3, i.getGame().getYValue());
    }

    @Test
    public void canMoveDown() {
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        i.setGame(game);
        i.setPresenter(new PresenterStub());
        i.perform(MovementAction.down());
        assertEquals(-1, i.getGame().getYValue());
    }

    @Test
    public void canMoveDownMultipleTimes() {
        MovementAction moveDown = MovementAction.down();
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        i.setGame(game);
        i.setPresenter(new PresenterStub());
        i.perform(moveDown);
        i.perform(moveDown);
        i.perform(moveDown);
        assertEquals(-3, i.getGame().getYValue());
    }

    @Test
    public void canMoveLeft() {
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        i.setGame(game);
        i.setPresenter(new PresenterStub());
        i.perform(MovementAction.left());
        assertEquals(-1, i.getGame().getXValue());
    }

    @Test
    public void canMoveLeftMultipleTimes() {
        MovementAction moveLeft = MovementAction.left();
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        i.setGame(game);
        i.setPresenter(new PresenterStub());
        i.perform(moveLeft);
        i.perform(moveLeft);
        i.perform(moveLeft);
        assertEquals(-3, i.getGame().getXValue());
    }

    @Test
    public void canMoveRight() {
        MovementAction moveRight = MovementAction.right();
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        i.setGame(game);
        i.setPresenter(new PresenterStub());
        i.perform(moveRight);
        assertEquals(1, i.getGame().getXValue());
    }

    @Test
    public void canMoveRightMultipleTimes() {
        MovementAction moveLeft = MovementAction.left();
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        i.setGame(game);
        i.setPresenter(new PresenterStub());
        i.perform(moveLeft);
        i.perform(moveLeft);
        i.perform(moveLeft);
        assertEquals(-3, i.getGame().getXValue());
    }

    @Test
    public void whenMovementActionIsPerformed_UpdatePositionWasCalled() {
        MovementAction moveLeft = MovementAction.left();
        UpdateWithinBuildingLocationSpy mockPresenter = new UpdateWithinBuildingLocationSpy();
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        i.setGame(game);
        i.setPresenter(mockPresenter);
        i.perform(moveLeft);
        assertTrue(mockPresenter.showUpdatePositionWasCalled);
        assertNotNull(mockPresenter.providedLocation);
        Coordinates expectedInsideLocation = new Coordinates(-1, 0);
        assertEquals(expectedInsideLocation, mockPresenter.providedLocation);
    }

    @Test
    public void cannotMoveWhenNotInsideBuilding() {
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


    private Game getGameWithOneBuildingAndLocationAtItsEntrance() {
        Game game = new Game();
        Building b = new Building("building1");
        game.addBuildings(b);
        game.setLocation(WithinBuildingLocation.atEntranceOf(b));
        return game;
    }
}
