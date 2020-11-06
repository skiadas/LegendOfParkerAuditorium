package core;

import core.action.SelectBuildingAction;
import mocks.AvailableBuildingsPresenterSpy;
import mocks.BuildingSelectPresenterSpy;
import mocks.PresenterStub;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SelectBuildingActionTests {

    private Interactor i;

    @Before
    public void setUp(){
        i = new Interactor();
    }

    @Test
    public void whenSelectingBuilding_CurrentBuildingGetUpdated() {
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

    @Test
    public void whenSelectingBuilding_CannotSelectBuildingWhenGameHasNotStarted() {
        BuildingSelectPresenterSpy mockPresenter = new BuildingSelectPresenterSpy();
        i.setPresenter(mockPresenter);
        SelectBuildingAction action = new SelectBuildingAction("Donner");
        i.perform(action);
        String expected = "Game Has Not Started";
        assertTrue(mockPresenter.showErrorMessageCalled);
        assertEquals(expected, mockPresenter.message);
    }

    @Test
    public void whenSelectingBuilding_CannotSelectBuildingWhileInsideABuilding() {
        BuildingSelectPresenterSpy mockPresenter = new BuildingSelectPresenterSpy();
        i.setPresenter(mockPresenter);
        SelectBuildingAction action = new SelectBuildingAction("Donner");
        Building building = new Building("Donner", 0);
        Game game = new Game();
        game.addBuilding(building);
        game.setLocation(new WithinBuildingLocation(building, building.getEntranceCoordinates()));
        i.setGame(game);
        i.perform(action);
        String expected = "core.Game$ExistingBuildingError: You cannot select a building when you are already inside a building"; // Why??
        assertTrue(mockPresenter.showErrorMessageCalled);
        assertEquals(expected, mockPresenter.message);
    }

    @Test
    public void whenSelectingANonExistingBuilding_PresenterErrorMethodShouldHaveOccur() {
        BuildingSelectPresenterSpy mockPresenter = new BuildingSelectPresenterSpy();
        i.setPresenter(mockPresenter);
        SelectBuildingAction action = new SelectBuildingAction("Wiley");
        Building building = new Building("Donner", 0);
        Game game = new Game();
        game.addBuilding(building);
        i.setGame(game);
        i.perform(action);
        String expected = "core.Game$ExistingBuildingError: Building does not exist!"; /// How to fix this
        assertTrue(mockPresenter.showErrorMessageCalled);
        assertEquals(expected, mockPresenter.message);
    }
}
