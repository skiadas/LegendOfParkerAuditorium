package ui;

import core.boundary.ActionHandler;
import core.boundary.Presenter;
import minidraw.standard.MiniDrawApplication;

public class LoPAMainApp extends MiniDrawApplication implements Presenter {
    private ActionHandler actionHandler;

    public LoPAMainApp(ActionHandler actionHandler) {
        super("Legend of Parker Auditorium", new LoPAFactory());
        this.actionHandler = actionHandler;
    }
}
