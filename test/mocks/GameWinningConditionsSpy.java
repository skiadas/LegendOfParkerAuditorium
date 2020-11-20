package mocks;
import core.boundary.MenuOption;

import java.util.List;

public class GameWinningConditionsSpy extends PresenterStub{
    public boolean showWinScreenWasCalled = false;
    public boolean showMainMenuWasCalled = false;

    public void showWinScreen(String message) {showWinScreenWasCalled = true; }
    public void showMainMenu(List<MenuOption> menu) {
        showMainMenuWasCalled = true;
    }
}
