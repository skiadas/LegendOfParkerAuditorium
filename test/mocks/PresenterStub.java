package mocks;

import core.Building;
import core.MenuOption;
import core.Coordinates;
import core.action.SeeAvailableBuildingsAction;
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

    @Override
    public void transitionScreen() {

    }

    @Override
    public void showErrorForRestrictedBuilding(String errorMessage) {

    }

    @Override
    public void showErrorForInvalidBuilding(String errorMessage) {

    }

    @Override
    public void showChoiceOfBuilding(String chosenBuilding) {

    }

    @Override
    public void showErrorForNotBeingAtExist(String errorMessage) {

    }

    @Override
    public void showErrorForGameNotStarted(String errorMessage) {

    }

    @Override
    public void showErrorForUnavailableBuildings(String s) {

    }
}
