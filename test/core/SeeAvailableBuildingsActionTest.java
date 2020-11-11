package core;

import core.action.ActionFactory;
import core.action.UserAction;
import mocks.AvailableBuildingsPresenterSpy;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SeeAvailableBuildingsActionTest {

    @Test
    public void whenSeeAvailableBuildingsPerformed_AvailableBuildingsPresented(){
        Interactor i = new Interactor();
        UserAction action = ActionFactory.seeAvailableBuildings();
        AvailableBuildingsPresenterSpy mockPresenter = new AvailableBuildingsPresenterSpy();
        i.setPresenter(mockPresenter);
        Game game = new Game();
        i.setGame(game);
        game.addBuilding(new Building("building1", 0));
        game.addBuilding(new Building("building2", 1));
        i.perform(action);
        List<Building> availableBuildings2 = game.produceAvailableBuildings();
        assertTrue(mockPresenter.showAvailableBuildingsWasCalled);
        List<MenuOption> menuOptions = i.convertBuildingsToMenuOptions(availableBuildings2);
        assertEquals(menuOptions, mockPresenter.availableBuildings);
    }


}

