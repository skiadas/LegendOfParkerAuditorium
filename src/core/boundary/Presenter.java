package core.boundary;

import core.Building;
import core.MenuOption;
import core.action.SeeAvailableBuildingsAction;
import core.action.UserAction;

import java.util.ArrayList;
import java.util.List;

public interface Presenter {
    void showMainMenu(List<MenuOption> options);

    void showAvailableBuildings(List<Building> availableBuildings);

    void transitionScreen(String words, SeeAvailableBuildingsAction action);

    void showErrorForRestrictedBuilding(String errorMessage);

    void showErrorForInvalidIndex(String errorMessage);

    void showChoiceOfBuilding(Building chosenBuilding);
}
