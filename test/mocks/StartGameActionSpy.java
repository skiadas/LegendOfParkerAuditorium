package mocks;

import core.action.SeeAvailableBuildingsAction;

public class StartGameActionSpy extends PresenterStub{
    public boolean transitionScreenIsCalled = false;
    public boolean showErrorIsCalled = true;

    public void transitionScreen(String message, SeeAvailableBuildingsAction action) {
        transitionScreenIsCalled = true;
        showErrorIsCalled = false;
    }
}
