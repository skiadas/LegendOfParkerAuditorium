package ui.stubs;

import core.boundary.ActionVisitor;
import core.boundary.UserAction;

import java.util.Objects;

public class UserActionStub implements UserAction {
    private int i;

    public UserActionStub(int i) {
        this.i = i;
    }

    public void accept(ActionVisitor visitor) {

    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserActionStub that = (UserActionStub) o;
        return i == that.i;
    }

    public int hashCode() {
        return Objects.hash(i);
    }
}
