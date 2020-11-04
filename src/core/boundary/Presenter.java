package core.boundary;

import core.Building;
import core.Coordinates;
import core.MenuOption;

import java.util.List;

public interface Presenter {
    void showMainMenu(List<MenuOption> options);

    void showAvailableBuildings(List<MenuOption> availableBuildings);

    void showUpdatedInsideLocation(Coordinates insideLocation);

    void transitionScreen();

    void showErrorForRestrictedBuilding(String errorMessage);

    void showErrorForInvalidBuilding(String errorMessage);

    void showChoiceOfBuilding(Building chosenBuilding);

    void showErrorForNotBeingAtExist(String errorMessage);

    void showErrorForGameNotStarted(String errorMessage);

    void showErrorForUnavailableBuildings(String s);
}
