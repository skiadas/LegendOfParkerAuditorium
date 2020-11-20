package core;

import core.action.ActionFactory;
import core.boundary.BuildingView;
import core.boundary.UserAction;
import mocks.BuildingSelectPresenterSpy;
import mocks.PresenterStub;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SelectBuildingActionTest extends BaseAppTest {

    private BuildingSelectPresenterSpy mockPresenter;
    private UserAction action;

    @Before
    public void setUp() {
        super.setUp();
        mockPresenter = new BuildingSelectPresenterSpy();
        interactor.setPresenter(mockPresenter);
        action = ActionFactory.selectBuildingAction("Donner");
    }

    @Test
    public void whenSelectingBuilding_CurrentBuildingGetUpdated() {
        UserAction action = ActionFactory.selectBuildingAction("Donner");
        Building building = addBuildingRequiringKeys("Donner", 0);
        interactor.setPresenter(new PresenterStub());
        interactor.perform(action);
        Building currentBuilding = game.getCurrentBuilding();
        assertEquals(currentBuilding, building);
    }

    @Test
    public void whenSelectingBuilding_ANewImageOnScreenIsShow() {
        UserAction action = ActionFactory.selectBuildingAction("Donner");
        Building building = addBuildingRequiringKeys("Donner", 0);
        interactor.perform(action);
        BuildingView chosenBuilding = mockPresenter.chosenBuilding;
        assertTrue(mockPresenter.showChoiceOfBuildingCalled);
        assertTrue(mockPresenter.showUpdatedLocationCalled);
        BuildingView bv = BuildingConvert.getBuildingViewInfo(building);
        assertEquals(bv, chosenBuilding);
        assertEquals(building.getEntrance(), mockPresenter.showUpdatedLocation);
    }

    @Test
    public void whenSelectingBuildingOutOfMoreThanOneBuilding_ANewImageOnScreenIsShow() {
        Building building = addBuildingRequiringKeys("Parker", 0);
        building.setEntranceCoordinates(1,5);
        Building building2 = addBuildingRequiringKeys("Donner", 0);
        interactor.perform(action);
        assertTrue(mockPresenter.showChoiceOfBuildingCalled);
        assertTrue(mockPresenter.showUpdatedLocationCalled);
        BuildingView chosenBuilding = mockPresenter.chosenBuilding;
        assertNotEquals(BuildingConvert.getBuildingViewInfo(building), chosenBuilding);
        assertEquals(BuildingConvert.getBuildingViewInfo(building2), chosenBuilding);
        assertEquals(building2.getEntrance(), mockPresenter.showUpdatedLocation);
    }

    @Test
    public void whenSelectingBuilding_CannotSelectBuildingWhenGameHasNotStarted() {
        interactor.setNoGame();
        interactor.perform(action);
        assertTrue(mockPresenter.showErrorMessageCalled);
        assertEquals(StandardMessageFactory.getInstance().gameNotStarted(), mockPresenter.message);
    }

    @Test
    public void whenSelectingBuilding_CannotSelectBuildingWhileInsideABuilding() {
        addBuildingAndMoveToItsEntrance("Donner");
        interactor.perform(action);
        assertTrue(mockPresenter.showErrorMessageCalled);
        assertEquals(StandardMessageFactory.getInstance().mustExistBuilding(), mockPresenter.message);
    }

    @Test
    public void whenSelectingBuilding_CannotPickABuildingNotWithinAvailableBuildingsList() {
        addBuildingRequiringKeys("Donner", 1);
        interactor.perform(action);
        assertTrue(mockPresenter.showErrorMessageCalled);
        assertEquals(StandardMessageFactory.getInstance().notInAvailableBuildingsList(), mockPresenter.message);
    }

    @Test
    public void whenSelectingANonExistingBuilding_PresenterErrorMethodShouldHaveOccur() {
        addBuildingRequiringKeys("Wiley", 0);
        interactor.perform(action);
        assertTrue(mockPresenter.showErrorMessageCalled);
        assertEquals(StandardMessageFactory.getInstance().buildingDoesNotExist(), mockPresenter.message);
    }

}
