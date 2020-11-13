package core.action;

import core.boundary.ActionVisitor;

public class StartGameAction implements UserAction{

    public StartGameAction() {
    }

    public void accept(ActionVisitor visitor) {
        visitor.perform(this);
    }

    public String toString() {
        return "StartGameAction";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }
}
