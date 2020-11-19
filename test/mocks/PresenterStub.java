package mocks;

import core.BuildingView;
import core.location.Coordinates;
import core.MenuOption;
import core.action.UserAction;
import core.boundary.Presenter;

import java.util.List;

public class PresenterStub implements Presenter {

    public void showMainMenu(List<MenuOption> options) {

    }

    @Override
    public void showAvailableBuildings(List<MenuOption> availableBuildings) {

    }

    @Override
    public void showUpdatedInsideLocation(Coordinates insideLocation) {

    }

    public void showTransition(String message, UserAction action) {

    }

    @Override
    public void showChoiceOfBuilding(BuildingView buildingView) {

    }

    @Override
    public void showError(String errorMessage) {

    }

    @Override
    public void showDeathScreen(String message) {

    }

    @Override
    public void showWinScreen(String message) {

    }


}
