package mocks;

import core.Building;
import core.MenuOption;
import core.action.SeeAvailableBuildingsAction;
import core.action.UserAction;
import core.boundary.Presenter;

import java.util.List;

public class PresenterStub implements Presenter {
    public void showMainMenu(List<MenuOption> options) {

    }

    @Override
    public void showAvailableBuildings(List<Building> availableBuildings) {

    }

    @Override
    public void transitionScreen(String words, SeeAvailableBuildingsAction action) {

    }

    @Override
    public void showErrorForRestrictedBuilding(String errorMessage) {

    }

    @Override
    public void showErrorForInvalidIndex(String errorMessage) {

    }

    @Override
    public void showChoiceOfBuilding(Building chosenBuilding) {

    }

    @Override
    public void showErrorForNotBeingAtExist(String errorMessage) {

    }
}
