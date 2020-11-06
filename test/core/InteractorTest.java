package core;

import core.action.MovementAction;
import core.action.SeeAvailableBuildingsAction;
import core.action.SelectBuildingAction;
import core.action.StartGameAction;
import mocks.AvailableBuildingsPresenterSpy;
import mocks.PresenterStub;
import mocks.StartGameActionSpy;
import mocks.UpdateWithinBuildingLocationSpy;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class InteractorTest {

    private Interactor i;

    @Before
    public void setUp(){
        i = new Interactor();
    }

    @Test
    public void canCreateGame() throws IOException {
        PresenterStub mocks = new PresenterStub();
        i.setPresenter(mocks);
        StartGameAction start = new StartGameAction();
        i.perform(start);
        assertEquals(true , i.getGame().gameStarted);
    }

    @Test
    public void cannotStartGameInProgress() throws IOException {
        StartGameActionSpy presenterSpy = new StartGameActionSpy();
        i.setPresenter(presenterSpy);
        StartGameAction start = new StartGameAction();
        i.perform(start);
        assertFalse(presenterSpy.showErrorIsCalled);
    }

    @Test
    public void canReadFile() throws IOException {
        assertEquals("Test Message", AssetReader.fileToString("TestMessage.txt"));
    }

    @Test
    public void transitionScreenIsCalled() throws IOException {
        StartGameActionSpy presenterSpy = new StartGameActionSpy();
        StartGameAction start = new StartGameAction();
        i.setPresenter(presenterSpy);
        i.perform(start);
        assertTrue(presenterSpy.transitionScreenIsCalled);
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
        i.setGame(new Game());
        UpdateWithinBuildingLocationSpy presenterSpy = new UpdateWithinBuildingLocationSpy();
        i.setPresenter(presenterSpy);
        i.perform(MovementAction.up());
        assertEquals(false, presenterSpy.showUpdatePositionWasCalled);
    }

    @Test
    public void PresenterIsCalledWithCorrectArgsWhenPlayerMoved() {
        i.setGame(getGameWithOneBuildingAndLocationAtItsEntrance());
        UpdateWithinBuildingLocationSpy presenterSpy = new UpdateWithinBuildingLocationSpy();
        i.setPresenter(presenterSpy);
        i.perform(MovementAction.up());
        assertEquals(true, presenterSpy.showUpdatePositionWasCalled);
        assertEquals(new Coordinates(0, 1), presenterSpy.providedLocation);
    }

    @Test
    public void cannotMoveWhenNoGameIsStarted() {
        UpdateWithinBuildingLocationSpy presenterSpy = new UpdateWithinBuildingLocationSpy();
        i.setPresenter(presenterSpy);
        i.perform(MovementAction.up());
        assertEquals(false, presenterSpy.showUpdatePositionWasCalled);
    }

    @Test
    public void cannotMoveOutsideTheBuildingX() {
        MovementAction moveLeft = MovementAction.left();
        UpdateWithinBuildingLocationSpy mockPresenter = new UpdateWithinBuildingLocationSpy();
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        i.setGame(game);
        i.setPresenter(new PresenterStub());
        moveToEdge(moveLeft);
        i.setPresenter(mockPresenter);
        i.perform(moveLeft);
        assertEquals(false, mockPresenter.showUpdatePositionWasCalled);
    }

    @Test
    public void cannotMoveOutsideTheBuildingY() {
        MovementAction moveUp = MovementAction.up();
        UpdateWithinBuildingLocationSpy mockPresenter = new UpdateWithinBuildingLocationSpy();
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        i.setGame(game);
        i.setPresenter(new PresenterStub());
        moveToEdge(moveUp);
        i.setPresenter(mockPresenter);
        i.perform(moveUp);
        assertEquals(false, mockPresenter.showUpdatePositionWasCalled);
    }


    @Test
    public void cannotSeeAvailableBuildingsIfGameHasNotStarted(){
        SeeAvailableBuildingsAction action = new SeeAvailableBuildingsAction();
        AvailableBuildingsPresenterSpy mockPresenter = new AvailableBuildingsPresenterSpy();
        i.setPresenter(mockPresenter);
        i.perform(action);
        assertFalse(mockPresenter.showAvailableBuildingsWasCalled);
    }

    private Game getGameWithOneBuildingAndLocationAtItsEntrance() {
        Game game = new Game();
        Building b = new Building("building1");
        game.addBuilding(b);
        game.setLocation(WithinBuildingLocation.atEntranceOf(b));
        return game;
    }

    private void moveToEdge(MovementAction move) {
        i.perform(move);
        i.perform(move);
        i.perform(move);
        i.perform(move);
        i.perform(move);
        i.perform(move);
        i.perform(move);
        i.perform(move);
        i.perform(move);
        i.perform(move);
        i.perform(move);
        i.perform(move);
        i.perform(move);
        i.perform(move);
        i.perform(move);
        i.perform(move);
        i.perform(move);
        i.perform(move);
        i.perform(move);
        i.perform(move);
    }

    @Test
    public void selectBuildingTest() {
        SelectBuildingAction action = new SelectBuildingAction("Donner");
        Building building = new Building("Donner", 0);
        Game game = new Game();
        game.addBuilding(building);
        i.setGame(game);
        i.setPresenter(new PresenterStub());
        i.perform(action);
        Building currentBuilding = i.getGame().getCurrentBuilding();
        assertTrue(building.equals(currentBuilding));
    }

    @Test (expected = RuntimeException.class)
    public void selectBuildingTestWithIncorrectName() {
        SelectBuildingAction action = new SelectBuildingAction("Wiley");
        Building building = new Building("Donner", 0);
        Game game = new Game();
        game.addBuilding(building);
        i.setGame(game);
        i.setPresenter(new PresenterStub());
        i.perform(action);
        i.getGame().getCurrentBuilding(); // not exist
    }
}
