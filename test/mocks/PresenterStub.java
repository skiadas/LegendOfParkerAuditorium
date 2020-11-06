package mocks;

import core.BuildingView;
import core.Coordinates;
import core.MenuOption;
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

    public void transitionScreen(String fileName, SeeAvailableBuildingsAction action) {

    }

    @Override
    public void showChoiceOfBuilding(BuildingView buildingView) {

    }

    @Override
    public void showError(String errorMessage) {

    }

}
