package ui.stubs;

import core.action.ActionFactory;
import core.boundary.ActionRouter;
import core.boundary.UserAction;

import java.util.ArrayList;
import java.util.List;

public class ActionRouterStub implements ActionRouter {
    public boolean startActionPerformed = false;
    public List<UserAction> requestedPerforms = new ArrayList<>();

    public void perform(UserAction action) {
        requestedPerforms.add(action);
    }

    public UserAction getStartAction() {
        return ActionFactory.appLoadAction();
    }

    public void performStartAction() {
        startActionPerformed = true;
        ActionRouter.super.performStartAction();
    }

    public UserAction getLastRequestedPerform() {
        return requestedPerforms.get(requestedPerforms.size() - 1);
    }
}
