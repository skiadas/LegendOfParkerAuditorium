package core.action;

public class NewGameAction implements UserAction {

    public String toString() {
        return "NewGameAction";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

}
