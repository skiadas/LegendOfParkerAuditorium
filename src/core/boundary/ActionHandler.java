package core.boundary;

import core.AppLoadAction;

public interface ActionHandler {
    void perform(AppLoadAction action);
}
