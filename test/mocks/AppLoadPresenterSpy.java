package mocks;

import core.boundary.MenuOption;

import java.util.List;

public class AppLoadPresenterSpy extends PresenterStub {
    public boolean showMainMenuWasCalled = false;
    public boolean showDeathScreenWasCalled = false;
    public String message;
    public List<MenuOption> providedOptions;

    public void showMainMenu(List<MenuOption> options) {
        showMainMenuWasCalled = true;
        providedOptions = options;
    }

   // @Override
    public void showDeathScreen(String message) {
        showDeathScreenWasCalled = true;
        this.message = message;
        //super.showDeathScreen(message);
    }
}
