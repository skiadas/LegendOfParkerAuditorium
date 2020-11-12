package core;

import core.action.AppLoadAction;
import core.action.NewGameAction;
import core.action.SaveGameAction;
import core.action.StartGameAction;
import mocks.AppLoadPresenterSpy;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AppLoadActionTest {
    @Test
    public void whenTheAppLoadActionIsPerformed_MainMenuIsShown() {
        Interactor interactor = new Interactor();
        AppLoadAction action = new AppLoadAction();
        AppLoadPresenterSpy mockPresenter = new mocks.AppLoadPresenterSpy();
        interactor.setPresenter(mockPresenter);
        interactor.perform(action);
        assertTrue(mockPresenter.showMainMenuWasCalled);
        assertNotNull(mockPresenter.providedOptions);
        List<MenuOption> expectedOptions = List.of(
                new MenuOption("New Game", new StartGameAction()),
                new MenuOption("Save Game", new SaveGameAction()));
        assertEquals(expectedOptions, mockPresenter.providedOptions);
    }
}
