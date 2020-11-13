package core.action;

import core.boundary.ActionVisitor;

import java.io.IOException;

public class StartGameAction implements UserAction{

    public StartGameAction() {
    }

    public void accept(ActionVisitor visitor) throws IOException {
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
