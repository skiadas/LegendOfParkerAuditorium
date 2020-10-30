package core.boundary;

import core.Building;
import core.MenuOption;
import core.Coordinates;
import core.action.SeeAvailableBuildingsAction;

import java.util.List;

public interface Presenter {
    void showMainMenu(List<MenuOption> options);

    void showAvailableBuildings(List<MenuOption> availableBuildings);

    void showUpdatedInsideLocation(Coordinates insideLocation);


    void transitionScreen(String words, SeeAvailableBuildingsAction action);

    void showErrorForRestrictedBuilding(String errorMessage);

    void showErrorForInvalidBuilding(String errorMessage);

    void showChoiceOfBuilding(Building chosenBuilding);

    void showErrorForNotBeingAtExist(String errorMessage);

    void showErrorForGameNotStarted(String errorMessage);
}
