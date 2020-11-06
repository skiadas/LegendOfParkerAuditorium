package core.action;


import core.boundary.ActionVisitor;

public class SeeAvailableBuildingsAction implements UserAction {
    public void accept(ActionVisitor visitor) {
        visitor.perform(this);
    }
}
