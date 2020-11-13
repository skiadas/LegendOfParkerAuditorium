package core.action;

import core.boundary.ActionVisitor;

import java.io.IOException;

public interface UserAction {
    void accept(ActionVisitor visitor) throws IOException;
}
