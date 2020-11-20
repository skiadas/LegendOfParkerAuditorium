package core.action;


import core.boundary.ActionVisitor;
import core.boundary.UserAction;

public class SeeAvailableBuildingsAction implements UserAction {
    SeeAvailableBuildingsAction() {
    }

    public void accept(ActionVisitor visitor) {
        visitor.perform(this);
    }
}
