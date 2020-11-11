package core.action;


import core.boundary.ActionVisitor;

public class SeeAvailableBuildingsAction implements UserAction {
    SeeAvailableBuildingsAction() {
    }

    public void accept(ActionVisitor visitor) {
        visitor.perform(this);
    }
}
