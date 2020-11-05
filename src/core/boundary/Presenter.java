package core.boundary;

import core.BuildingView;
import core.Coordinates;
import core.MenuOption;
import core.action.SeeAvailableBuildingsAction;

import java.util.List;

public interface Presenter {
    void showMainMenu(List<MenuOption> options);

    void showAvailableBuildings(List<MenuOption> availableBuildings);

    void showUpdatedInsideLocation(Coordinates insideLocation);

    void transitionScreen(String fileName, SeeAvailableBuildingsAction action);

    void showChoiceOfBuilding(BuildingView buildingView);

    void showError(String errorMessage);


}
