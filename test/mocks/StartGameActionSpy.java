package mocks;

import core.action.UserAction;

public class StartGameActionSpy extends PresenterStub{
    public boolean transitionScreenIsCalled = false;
    public boolean showErrorIsCalled = true;

    public void message(String message, UserAction action) {
        transitionScreenIsCalled = true;
        showErrorIsCalled = false;
    }
}
