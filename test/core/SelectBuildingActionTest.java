package core;

import core.action.ActionFactory;
import core.action.UserAction;
import mocks.BuildingSelectPresenterSpy;
import mocks.PresenterStub;
import org.junit.Test;

import static org.junit.Assert.*;

public class SelectBuildingActionTest extends BaseAppTest {

    @Test
    public void whenSelectingBuilding_CurrentBuildingGetUpdated() {
        UserAction action = ActionFactory.selectBuildingAction("Donner");
        Building building = new Building("Donner", 0);
        game.addBuilding(building);
        interactor.setPresenter(new PresenterStub());
        interactor.perform(action);
        Building currentBuilding = game.getCurrentBuilding();
        assertEquals(currentBuilding, building);
    }

    @Test
    public void whenSelectingBuilding_ANewImageOnScreenIsShow() {
        BuildingSelectPresenterSpy mockPresenter = new BuildingSelectPresenterSpy();
        UserAction action = ActionFactory.selectBuildingAction("Donner");
        Building building = new Building("Donner", 0);
        game.addBuilding(building);
        interactor.setPresenter(mockPresenter);
        interactor.perform(action);
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
        interactor.setPresenter(mockPresenter);
        game.addBuilding(building);
        game.addBuilding(building2);
        UserAction action = ActionFactory.selectBuildingAction("Parker");
        interactor.perform(action);
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
        interactor.setPresenter(mockPresenter);
        interactor.setNoGame();
        UserAction action = ActionFactory.selectBuildingAction("Donner");
        interactor.perform(action);
        assertTrue(mockPresenter.showErrorMessageCalled);
        assertEquals(StandardMessageFactory.getInstance().gameNotStarted(), mockPresenter.message);
    }

    @Test
    public void whenSelectingBuilding_CannotSelectBuildingWhileInsideABuilding() {
        BuildingSelectPresenterSpy mockPresenter = new BuildingSelectPresenterSpy();
        interactor.setPresenter(mockPresenter);
        UserAction action = ActionFactory.selectBuildingAction("Donner");
        Building building = new Building("Donner", 0);
        game.addBuilding(building);
        game.setLocation(new WithinBuildingLocation(building, building.getEntranceCoordinates()));
        interactor.perform(action);
        assertTrue(mockPresenter.showErrorMessageCalled);
        assertEquals(StandardMessageFactory.getInstance().mustExistBuilding(), mockPresenter.message);
    }

    @Test
    public void whenSelectingBuilding_CannotPickABuildingNotWithinAvailableBuildingsList() {
        BuildingSelectPresenterSpy mockPresenter = new BuildingSelectPresenterSpy();
        UserAction action = ActionFactory.selectBuildingAction("Donner");
        Building building = new Building("Donner", 1);
        game.addBuilding(building);
        interactor.setPresenter(mockPresenter);
        interactor.perform(action);
        assertTrue(mockPresenter.showErrorMessageCalled);
        assertEquals(StandardMessageFactory.getInstance().notInAvailableBuildingsList(), mockPresenter.message);
    }

    @Test
    public void whenSelectingANonExistingBuilding_PresenterErrorMethodShouldHaveOccur() {
        BuildingSelectPresenterSpy mockPresenter = new BuildingSelectPresenterSpy();
        interactor.setPresenter(mockPresenter);
        UserAction action = ActionFactory.selectBuildingAction("Wiley");
        Building building = new Building("Donner", 0);
        game.addBuilding(building);
        interactor.perform(action);
        assertTrue(mockPresenter.showErrorMessageCalled);
        assertEquals(StandardMessageFactory.getInstance().buildingDoesNotExist(), mockPresenter.message);
    }
}
