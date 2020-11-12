package core.action;

import core.boundary.ActionVisitor;

public class SaveGameAction implements UserAction {

    public SaveGameAction() {
    }

    public String toString() {
        return "SaveGameAction";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    public void accept(ActionVisitor visitor) {
        visitor.perform(this);
    }
}
