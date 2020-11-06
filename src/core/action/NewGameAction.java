package core.action;

import core.boundary.ActionVisitor;

public class NewGameAction implements UserAction {
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
