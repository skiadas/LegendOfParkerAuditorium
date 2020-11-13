package core.boundary;

import core.action.UserAction;

public interface ActionRouter {
    void perform(UserAction action);

    UserAction getStartAction();

    default void performStartAction() {
        perform(getStartAction());
    }
}
