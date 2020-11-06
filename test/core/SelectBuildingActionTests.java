package core;

import core.action.SelectBuildingAction;
import mocks.PresenterStub;
import org.junit.Before;
import org.junit.Test;

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

    @Test (expected = RuntimeException.class)
    public void whenSelectingANonExistingBuilding_PresenterErrorMethodShouldHaveOccur() {
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
