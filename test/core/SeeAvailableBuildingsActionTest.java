package core;

import core.action.SeeAvailableBuildingsAction;
import mocks.AvailableBuildingsPresenterSpy;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SeeAvailableBuildingsActionTest {

    @Test
    public void whenSeeAvailableBuildingsPerformed_AvailableBuildingsPresented(){
        Interactor i = new Interactor();
        SeeAvailableBuildingsAction action = new SeeAvailableBuildingsAction();
        AvailableBuildingsPresenterSpy mockPresenter = new AvailableBuildingsPresenterSpy();
        i.setPresenter(mockPresenter);
        Game game = new Game();
        i.setGame(game);
        Building building1 = new Building("building1", true);
        Building building2 = new Building("building2", false);
        game.addBuildings(building1);
        game.addBuildings(building2);
        i.perform(action);
        List<Building> availableBuildings2 = game.produceAvailableBuildings();
        assertTrue(mockPresenter.showAvailableBuildingsWasCalled);
        assertEquals(availableBuildings2, mockPresenter.availableBuildings);
    }

}

