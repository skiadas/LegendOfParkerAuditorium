package core.boundary;

import java.util.List;

public interface Presenter {
    void showMainMenu(List<MenuOption> options);

    void showAvailableBuildings(List<MenuOption> availableBuildings);

    void showUpdatedInsideLocation(Coordinates insideLocation);

    void showTransition(String message, UserAction action);

    void showChoiceOfBuilding(BuildingView buildingView);

    void showError(String errorMessage);

    void showDeathScreen(String message);

    void showWinScreen(String message);
}
