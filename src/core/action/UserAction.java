package core.action;

import core.boundary.ActionVisitor;

public interface UserAction {
    void accept(ActionVisitor visitor);
}
