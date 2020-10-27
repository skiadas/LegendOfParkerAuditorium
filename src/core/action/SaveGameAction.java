package core.action;

import core.Result;

public class SaveGameAction implements UserAction {
    public Result Action() {
        return null;
    }

    public String toString() {
        return "SaveGameAction";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

}
