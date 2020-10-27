package mocks;

import core.MenuOption;

import java.util.List;

public class AppLoadPresenterSpy extends PresenterStub {
    public boolean showMainMenuWasCalled = false;
    public List<MenuOption> providedOptions;

    public void showMainMenu(List<MenuOption> options) {
        showMainMenuWasCalled = true;
        providedOptions = options;
    }
}
