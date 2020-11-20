package core.boundary;

public interface ActionRouter {
    void perform(UserAction action);

    UserAction getStartAction();

    default void performStartAction() {
        perform(getStartAction());
    }
}
