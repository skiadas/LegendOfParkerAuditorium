package core.action;

import core.Result;

public class NewGameAction implements UserAction {
    public Result Action() {
        return null;
    }

    public String toString() {
        return "NewGameAction";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

}
