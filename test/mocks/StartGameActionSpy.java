package mocks;

import core.boundary.UserAction;

public class StartGameActionSpy extends PresenterStub{
    public boolean transitionScreenIsCalled = false;
    public boolean showErrorIsCalled = false;

    public void showError(String message) {
        showErrorIsCalled = true;
    }
    public void showTransition(String message, UserAction action) {
        transitionScreenIsCalled = true;

    }
}
