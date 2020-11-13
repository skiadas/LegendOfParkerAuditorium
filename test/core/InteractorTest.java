package core;

import core.action.ActionFactory;
import core.action.UserAction;
import mocks.AvailableBuildingsPresenterSpy;
import mocks.PresenterStub;
import mocks.StartGameActionSpy;
import mocks.UpdateWithinBuildingLocationSpy;
import org.junit.Test;
import static org.junit.Assert.*;

public class InteractorTest extends BaseAppTest {

    @Test
    public void canCreateGame() {
        PresenterStub mocks = new PresenterStub();
        interactor.setPresenter(mocks);
        UserAction start = ActionFactory.startGameAction();
        interactor.perform(start);
        assertEquals(true , interactor.getGame().gameStarted);
    }

    @Test
    public void cannotStartGameInProgress() {
        StartGameActionSpy presenterSpy = new StartGameActionSpy();
        interactor.setPresenter(presenterSpy);
        interactor.game = new Game();
        UserAction start = ActionFactory.startGameAction();
        interactor.perform(start);
        assertTrue(presenterSpy.showErrorIsCalled);
    }

    @Test
    public void canReadFile() {
        assertEquals("Test Message", AssetReader.fileToString("TestMessage.txt"));
    }

    @Test
    public void transitionScreenIsCalled() {
        StartGameActionSpy presenterSpy = new StartGameActionSpy();
        UserAction start = ActionFactory.startGameAction();
        interactor.setPresenter(presenterSpy);
        interactor.perform(start);
        assertTrue(presenterSpy.transitionScreenIsCalled);
    }

    @Test
    public void canMoveUp() {
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        interactor.setGame(game);
        interactor.setPresenter(new PresenterStub());
        interactor.perform(ActionFactory.moveUp());
        assertEquals(1, game.getYValue());
    }

    @Test
    public void canMoveUpMultipleTimes() {
        UserAction moveUp = ActionFactory.moveUp();
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        interactor.setGame(game);
        interactor.setPresenter(new PresenterStub());
        interactor.perform(moveUp);
        interactor.perform(moveUp);
        interactor.perform(moveUp);
        assertEquals(3, interactor.getGame().getYValue());
    }

    @Test
    public void canMoveDown() {
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        interactor.setGame(game);
        interactor.setPresenter(new PresenterStub());
        interactor.perform(ActionFactory.moveDown());
        assertEquals(-1, interactor.getGame().getYValue());
    }

    @Test
    public void canMoveDownMultipleTimes() {
        UserAction moveDown = ActionFactory.moveDown();
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        interactor.setGame(game);
        interactor.setPresenter(new PresenterStub());
        interactor.perform(moveDown);
        interactor.perform(moveDown);
        interactor.perform(moveDown);
        assertEquals(-3, interactor.getGame().getYValue());
    }

    @Test
    public void canMoveLeft() {
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        interactor.setGame(game);
        interactor.setPresenter(new PresenterStub());
        interactor.perform(ActionFactory.moveLeft());
        assertEquals(-1, interactor.getGame().getXValue());
    }

    @Test
    public void canMoveLeftMultipleTimes() {
        UserAction moveLeft = ActionFactory.moveLeft();
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        interactor.setGame(game);
        interactor.setPresenter(new PresenterStub());
        interactor.perform(moveLeft);
        interactor.perform(moveLeft);
        interactor.perform(moveLeft);
        assertEquals(-3, interactor.getGame().getXValue());
    }

    @Test
    public void canMoveRight() {
        UserAction moveRight = ActionFactory.moveRight();
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        interactor.setGame(game);
        interactor.setPresenter(new PresenterStub());
        interactor.perform(moveRight);
        assertEquals(1, interactor.getGame().getXValue());
    }

    @Test
    public void canMoveRightMultipleTimes() {
        UserAction moveLeft = ActionFactory.moveLeft();
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        interactor.setGame(game);
        interactor.setPresenter(new PresenterStub());
        interactor.perform(moveLeft);
        interactor.perform(moveLeft);
        interactor.perform(moveLeft);
        assertEquals(-3, interactor.getGame().getXValue());
    }

    @Test
    public void whenMovementActionIsPerformed_UpdatePositionWasCalled() {
        UserAction moveLeft = ActionFactory.moveLeft();
        UpdateWithinBuildingLocationSpy mockPresenter = new UpdateWithinBuildingLocationSpy();
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        interactor.setGame(game);
        interactor.setPresenter(mockPresenter);
        interactor.perform(moveLeft);
        assertTrue(mockPresenter.showUpdatePositionWasCalled);
        assertNotNull(mockPresenter.providedLocation);
        Coordinates expectedInsideLocation = new Coordinates(-1, 0);
        assertEquals(expectedInsideLocation, mockPresenter.providedLocation);
    }

    @Test
    public void cannotMoveWhenNotInsideBuilding() {
        interactor.setGame(new Game());
        UpdateWithinBuildingLocationSpy presenterSpy = new UpdateWithinBuildingLocationSpy();
        interactor.setPresenter(presenterSpy);
        interactor.perform(ActionFactory.moveUp());
        assertFalse(presenterSpy.showUpdatePositionWasCalled);
    }

    @Test
    public void PresenterIsCalledWithCorrectArgsWhenPlayerMoved() {
        interactor.setGame(getGameWithOneBuildingAndLocationAtItsEntrance());
        UpdateWithinBuildingLocationSpy presenterSpy = new UpdateWithinBuildingLocationSpy();
        interactor.setPresenter(presenterSpy);
        interactor.perform(ActionFactory.moveUp());
        assertTrue(presenterSpy.showUpdatePositionWasCalled);
        assertEquals(new Coordinates(0, 1), presenterSpy.providedLocation);
    }

    @Test
    public void cannotMoveWhenNoGameIsStarted() {
        UpdateWithinBuildingLocationSpy presenterSpy = new UpdateWithinBuildingLocationSpy();
        interactor.setPresenter(presenterSpy);
        interactor.perform(ActionFactory.moveUp());
        assertFalse(presenterSpy.showUpdatePositionWasCalled);
        assertTrue(presenterSpy.showErrorWasCalled);
        assertEquals("Game has not started", presenterSpy.errorMessage);
    }

    @Test
    public void cannotMoveOutsideTheBuildingX() {
        UserAction moveLeft = ActionFactory.moveLeft();
        UpdateWithinBuildingLocationSpy presenterSpy = new UpdateWithinBuildingLocationSpy();
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        interactor.setGame(game);
        interactor.setPresenter(new PresenterStub());
        moveToEdge(moveLeft);
        interactor.setPresenter(presenterSpy);
        interactor.perform(moveLeft);
        assertFalse(presenterSpy.showUpdatePositionWasCalled);
        assertTrue(presenterSpy.showErrorWasCalled);
        assertEquals("Unable to move to location.", presenterSpy.errorMessage);
    }

    @Test
    public void cannotMoveOutsideTheBuildingY() {
        UserAction moveUp = ActionFactory.moveUp();
        UpdateWithinBuildingLocationSpy mockPresenter = new UpdateWithinBuildingLocationSpy();
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        interactor.setGame(game);
        interactor.setPresenter(new PresenterStub());
        moveToEdge(moveUp);
        interactor.setPresenter(mockPresenter);
        interactor.perform(moveUp);
        assertFalse(mockPresenter.showUpdatePositionWasCalled);
    }

    @Test
    public void playerDiesWhenOnEnemySquare() {
        UpdateWithinBuildingLocationSpy mockPresenter = new UpdateWithinBuildingLocationSpy();
        Game game = getGameWithOneBuildingAndLocationAtItsEntrance();
        game.getCurrentBuilding().getListOfEnemies().add(new Enemy());
        Coordinates cords = new Coordinates(0, 1);
        game.getCurrentBuilding().getListOfEnemies().get(0).setCords(cords);
        interactor.setGame(game);
        interactor.setPresenter(mockPresenter);
        interactor.perform(ActionFactory.moveUp());
        assertEquals(cords.yValue, game.getCoords().yValue);
        assertEquals(cords.xValue, game.getCoords().xValue);
        assertTrue(mockPresenter.showDeathScreenIsCalled);
        assertTrue(mockPresenter.showMainMenuWasCalled);
    }

    @Test
    public void cannotSeeAvailableBuildingsIfGameHasNotStarted(){
        UserAction action = ActionFactory.seeAvailableBuildings();
        AvailableBuildingsPresenterSpy mockPresenter = new AvailableBuildingsPresenterSpy();
        interactor.setPresenter(mockPresenter);
        interactor.perform(action);
        assertFalse(mockPresenter.showAvailableBuildingsWasCalled);
    }

    private Game getGameWithOneBuildingAndLocationAtItsEntrance() {
        Game game = new Game();
        Building b = new Building("building1");
        game.addBuilding(b);
        game.setLocation(WithinBuildingLocation.atEntranceOf(b));
        return game;
    }

    @Test
    public void canLeaveTheBuildingBySteppingOnTheEntrance() {
        Game game = new Game();
        WithinBuildingLocation wbl = WithinBuildingLocation.atEntranceOf(new Building("B1",0));
        game.setLocation(wbl.getRequestedMove(Direction.up));
        AvailableBuildingsPresenterSpy mockPresenter = new AvailableBuildingsPresenterSpy();
        interactor.setGame(game);
        interactor.setPresenter(mockPresenter);
        interactor.perform(ActionFactory.moveDown());
        assertFalse(game.isWithinABuilding());
        assertTrue(mockPresenter.showAvailableBuildingsWasCalled);
    }

    @Test
    public void canLeaveTheBuildingWithDifferentEntranceCoordinates() {
        Game game = new Game();
        Building b = new Building("B1",0);
        b.setEntranceCoordinates(1,1);
        WithinBuildingLocation wbl = new WithinBuildingLocation(b, new Coordinates(1,0));
        game.setLocation(wbl);
        AvailableBuildingsPresenterSpy mockPresenter = new AvailableBuildingsPresenterSpy();
        interactor.setGame(game);
        interactor.setPresenter(mockPresenter);
        interactor.perform(ActionFactory.moveUp());
        interactor.exitBuildingIfPLayerOnExitCell();
        assertFalse(game.isWithinABuilding());
        assertTrue(mockPresenter.showAvailableBuildingsWasCalled);
    }

    private void moveToEdge(UserAction move) {
        for (int n = 0; n<=20; n++){
            interactor.perform(move);
        }
    }
}
