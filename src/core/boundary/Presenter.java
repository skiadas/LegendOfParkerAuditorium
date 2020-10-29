package core.boundary;

import core.Building;
import core.MenuOption;
import core.action.UserAction;

import java.util.ArrayList;
import java.util.List;

public interface Presenter {
    void showMainMenu(List<MenuOption> options);

    void showAvailableBuildings(List<Building> availableBuildings);

    void transitionScreen(String words, UserAction action);

    void showErrorForRestrictedBuilding(String errorMessage);

    void showErrorForInvalidIndex(String errorMessage);
}
