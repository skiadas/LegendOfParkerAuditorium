package core.boundary;

public interface UserAction {
    void accept(ActionVisitor visitor);
}
