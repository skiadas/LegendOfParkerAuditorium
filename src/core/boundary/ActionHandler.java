package core.boundary;

import core.action.AppLoadAction;
import core.action.SelectBuildingAction;
import core.action.StartGameAction;
import core.action.UserAction;

public interface ActionHandler {
    void perform(AppLoadAction action);
//    void perform(UserAction action);
//    void perform(StartGameAction action);
//    void perform(SelectBuildingAction action);
}
