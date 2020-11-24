package ui.stubs;

import ui.framework.Command;
import ui.framework.TransitionScreen;

public class TransitionScreenStub implements TransitionScreen {
    public boolean onCloseCalled = false;
    public Command providedCommand;

    public void onClose(Command command) {
        this.providedCommand = command;
        onCloseCalled = true;
    }
}
