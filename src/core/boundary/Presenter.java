package core.boundary;

import core.Building;
import core.MenuOption;

import java.util.ArrayList;
import java.util.List;

public interface Presenter {
    void showMainMenu(List<MenuOption> options);
}
