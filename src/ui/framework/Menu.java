package ui.framework;

import java.util.List;

public interface Menu extends Element, Container {
    void addItems(List<NamedCommand> options);

    List<Button> getButtons(List<NamedCommand> options);

    default void addButtons(List<Button> buttons) {
        for (Button button : buttons) {
            add(button);
        }
    }
}
