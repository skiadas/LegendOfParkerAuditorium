package ui.stubs;

import ui.framework.Button;
import ui.framework.Element;
import ui.framework.Menu;
import ui.framework.NamedCommand;

import java.util.List;

public class MenuStub implements Menu {
    public List<NamedCommand> addedItems = List.of();

    public void addItems(List<NamedCommand> options) {
        addedItems = options;
        Menu.super.addItems(options);
    }

    public void add(Element elem) {

    }

    public void remove(Element elem) {

    }
}
