package core;

import core.action.ActionFactory;
import core.action.UserAction;
import mocks.BuildingSelectPresenterSpy;
import mocks.PresenterStub;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SelectBuildingActionTest {

    private Interactor i;

    @Before
    public void setUp(){
        i = new Interactor();
    }

    @Test
    public void whenSelectingBuilding_CurrentBuildingGetUpdated() {
        UserAction action = ActionFactory.selectBuildingAction("Donner");
        Building building = new Building("Donner", 0);
        Game game = new Game();
        game.addBuilding(building);
        i.setGame(game);
        i.setPresenter(new PresenterStub());
        i.perform(action);
        Building currentBuilding = game.getCurrentBuilding();
        assertEquals(currentBuilding, building);
    }

    @Test
    public void whenSelectingBuilding_ANewImageOnScreenIsShow() {
        BuildingSelectPresenterSpy mockPresenter = new BuildingSelectPresenterSpy();
        UserAction action = ActionFactory.selectBuildingAction("Donner");
        Building building = new Building("Donner", 0);
        Game game = new Game();
        game.addBuilding(building);
        i.setGame(game);
        i.setPresenter(mockPresenter);
        i.perform(action);
        BuildingView chosenBuilding = mockPresenter.chosenBuilding;
        assertTrue(mockPresenter.showChoiceOfBuildingCalled);
        assertTrue(mockPresenter.showUpdatedLocationCalled);
        BuildingView bv = BuildingConvert.getBuildingViewInfo(building);
        assertEquals(bv, chosenBuilding);
        assertEquals(building.getEntranceCoordinates(), mockPresenter.showUpdatedLocation);
    }

    @Test
    public void whenSelectingBuildingOutOfMoreThanOneBuilding_ANewImageOnScreenIsShow() {
        BuildingSelectPresenterSpy mockPresenter = new BuildingSelectPresenterSpy();
        Building building = new Building("Donner", 0);
        building.setEntranceCoordinates(1,5);
        Building building2 = new Building("Parker", 0);
        Game game = new Game();
        i.setGame(game);
        i.setPresenter(mockPresenter);
        game.addBuilding(building);
        game.addBuilding(building2);
        UserAction action = ActionFactory.selectBuildingAction("Parker");
        i.perform(action);
        assertTrue(mockPresenter.showChoiceOfBuildingCalled);
        assertTrue(mockPresenter.showUpdatedLocationCalled);
        BuildingView chosenBuilding = mockPresenter.chosenBuilding;
        assertNotEquals(BuildingConvert.getBuildingViewInfo(building), chosenBuilding);
        assertEquals(BuildingConvert.getBuildingViewInfo(building2), chosenBuilding);
        assertEquals(building2.getEntranceCoordinates(), mockPresenter.showUpdatedLocation);
    }

    @Test
    public void whenSelectingBuilding_CannotSelectBuildingWhenGameHasNotStarted() {
        BuildingSelectPresenterSpy mockPresenter = new BuildingSelectPresenterSpy();
        i.setPresenter(mockPresenter);
        UserAction action = ActionFactory.selectBuildingAction("Donner");
        i.perform(action);
        String expected = "Game has not started";
        assertTrue(mockPresenter.showErrorMessageCalled);
        assertEquals(expected, mockPresenter.message);
    }

    @Test
    public void whenSelectingBuilding_CannotSelectBuildingWhileInsideABuilding() {
        BuildingSelectPresenterSpy mockPresenter = new BuildingSelectPresenterSpy();
        i.setPresenter(mockPresenter);
        UserAction action = ActionFactory.selectBuildingAction("Donner");
        Building building = new Building("Donner", 0);
        Game game = new Game();
        game.addBuilding(building);
        game.setLocation(new WithinBuildingLocation(building, building.getEntranceCoordinates()));
        i.setGame(game);
        i.perform(action);
        String expected = "You cannot select a building when you are already inside a building";
        assertTrue(mockPresenter.showErrorMessageCalled);
        assertEquals(expected, mockPresenter.message);
    }

    @Test
    public void whenSelectingANonExistingBuilding_PresenterErrorMethodShouldHaveOccur() {
        BuildingSelectPresenterSpy mockPresenter = new BuildingSelectPresenterSpy();
        i.setPresenter(mockPresenter);
        UserAction action = ActionFactory.selectBuildingAction("Wiley");
        Building building = new Building("Donner", 0);
        Game game = new Game();
        game.addBuilding(building);
        i.setGame(game);
        i.perform(action);
        String expected = "Building does not exist!";
        assertTrue(mockPresenter.showErrorMessageCalled);
        assertEquals(expected, mockPresenter.message);
    }
}
