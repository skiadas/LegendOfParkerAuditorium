package core.boundary;

import core.Coordinates;
import core.MenuOption;
import core.action.SeeAvailableBuildingsAction;

import java.util.List;

public interface Presenter {
    void showMainMenu(List<MenuOption> options);

    void showAvailableBuildings(List<MenuOption> availableBuildings);

    void showUpdatedInsideLocation(Coordinates insideLocation);

    void transitionScreen(String fileName, SeeAvailableBuildingsAction action);

    void showErrorForRestrictedBuilding(String errorMessage);

    void showErrorForInvalidBuilding(String errorMessage);

    void showChoiceOfBuilding(String chosenBuilding);

    void showErrorForNotBeingAtExist(String errorMessage);

    void showErrorForGameNotStarted(String errorMessage);

    void showErrorForUnavailableBuildings(String s);
}
