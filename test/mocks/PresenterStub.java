package mocks;

import core.BuildingView;
import core.MenuOption;
import core.Coordinates;
import core.action.UserAction;
import core.boundary.Presenter;

import java.io.File;
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
    public void transitionScreen(String fileName, SeeAvailableBuildingsAction action) {

    }

    @Override
    public void showChoiceOfBuilding(BuildingView buildingView) {

    }

    @Override
    public void showError(String errorMessage) {

    }

}
