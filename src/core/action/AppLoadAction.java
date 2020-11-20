package core.action;

import core.boundary.ActionVisitor;
import core.boundary.UserAction;

public class AppLoadAction implements UserAction {
    public AppLoadAction() {
    }

    public void accept(ActionVisitor visitor) {
        visitor.perform(this);
    }
}
