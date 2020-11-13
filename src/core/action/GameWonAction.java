package core.action;

import core.boundary.ActionVisitor;

public class GameWonAction implements UserAction {

    public void accept(ActionVisitor visitor) {
        visitor.perform(this);
    }

}
