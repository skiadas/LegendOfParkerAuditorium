package core;

import core.action.AppLoadAction;
import core.action.NewGameAction;
import core.action.SaveGameAction;
import core.action.StartGameAction;
import core.action.*;
import mocks.AppLoadPresenterSpy;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AppLoadActionTest {
    @Test
    public void whenTheAppLoadActionIsPerformed_MainMenuIsShown() {
        Interactor interactor = new Interactor();
        UserAction action = ActionFactory.appLoadAction();
        AppLoadPresenterSpy mockPresenter = new mocks.AppLoadPresenterSpy();
        interactor.setPresenter(mockPresenter);
        interactor.perform(action);
        assertTrue(mockPresenter.showMainMenuWasCalled);
        assertNotNull(mockPresenter.providedOptions);
        List<MenuOption> expectedOptions = List.of(
                new MenuOption("New Game", ActionFactory.newGameAction()),
                new MenuOption("Save Game", ActionFactory.saveGameAction()));
        assertEquals(expectedOptions, mockPresenter.providedOptions);
    }
}
