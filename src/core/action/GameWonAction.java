package core.action;

import core.boundary.ActionVisitor;
import core.boundary.UserAction;

public class GameWonAction implements UserAction {

    public void accept(ActionVisitor visitor) {
        visitor.perform(this);
    }

}
