package core.boundary;

import java.util.Objects;

public class MenuOption {
    public final String name;
    public final UserAction action;

    public MenuOption(String name, UserAction action) {
        this.name = name;
        this.action = action;
    }

    public String toString() {
        return String.format("MenuOption<%s, %s>", name, action);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuOption that = (MenuOption) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(action, that.action);
    }

    public int hashCode() {
        return Objects.hash(name, action);
    }
}
