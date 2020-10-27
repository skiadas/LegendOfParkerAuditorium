package core.boundary;

import core.action.AppLoadAction;

public interface ActionHandler {
    void perform(AppLoadAction action);
}
