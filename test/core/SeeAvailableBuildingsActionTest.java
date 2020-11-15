package core;

import core.action.ActionFactory;
import core.action.UserAction;
import mocks.AvailableBuildingsPresenterSpy;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SeeAvailableBuildingsActionTest extends BaseAppTest {

    @Test
    public void whenSeeAvailableBuildingsPerformed_AvailableBuildingsPresented(){
        UserAction action = ActionFactory.seeAvailableBuildings();
        AvailableBuildingsPresenterSpy mockPresenter = new AvailableBuildingsPresenterSpy();
        interactor.setPresenter(mockPresenter);
        Game game = new Game();
        interactor.setGame(game);
        game.addBuilding(new Building("building1", 0));
        game.addBuilding(new Building("building2", 1));
        interactor.perform(action);
        List<Building> availableBuildings2 = game.produceAvailableBuildings();
        assertTrue(mockPresenter.showAvailableBuildingsWasCalled);
        List<MenuOption> menuOptions = interactor.convertBuildingsToMenuOptions(availableBuildings2);
        assertEquals(menuOptions, mockPresenter.availableBuildings);
    }


}

