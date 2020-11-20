package core.action;

import core.boundary.ActionVisitor;
import core.boundary.UserAction;

public class NewGameAction implements UserAction {
    public NewGameAction() {
    }

    public void accept(ActionVisitor visitor) {
        visitor.perform(this);
    }
    public String toString() {
        return "NewGameAction";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

}
