package core;

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
                new MenuOption("New Game", new NewGameAction()),
                new MenuOption("Save Game", new SaveGameAction()));
        assertEquals(expectedOptions, mockPresenter.providedOptions);
    }
}
