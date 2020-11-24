package ui.framework;

import java.util.List;
import java.util.stream.Collectors;

public interface Menu extends Element, Container {
    default void addItems(List<NamedCommand> options) {
        addButtons(getButtons(options));
    }

    default List<Button> getButtons(List<NamedCommand> options) {
        UIFactory uiFactory = UIFactory.getInstance();
        return options.stream()
                .map(uiFactory::createButton)
                .collect(Collectors.toList());
    }

    default void addButtons(List<Button> buttons) {
        for (Button button : buttons) {
            add(button);
        }
    }
}
