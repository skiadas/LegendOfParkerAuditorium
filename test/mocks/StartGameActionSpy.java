package mocks;

import core.action.SeeAvailableBuildingsAction;
import core.action.UserAction;

public class StartGameActionSpy extends PresenterStub{
    public boolean transitionScreenIsCalled = false;

    public void transitionScreen(String message, SeeAvailableBuildingsAction action) {
        transitionScreenIsCalled = true;
    }
}
