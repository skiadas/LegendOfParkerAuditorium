package core;

import core.boundary.ActionHandler;
import core.boundary.Presenter;

public class Interactor implements ActionHandler {
    public static Game game;
    private Presenter presenter;

    public Result preformAction(UserAction start){
        return start.Action();
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
