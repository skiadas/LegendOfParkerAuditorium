package core.action;

public class SaveGameAction implements UserAction {

    public String toString() {
        return "SaveGameAction";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

}
