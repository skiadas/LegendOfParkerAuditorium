package ui;

import core.Building;
import core.Interactor;
import core.MenuOption;
import core.Coordinates;
import core.action.SeeAvailableBuildingsAction;
import core.boundary.ActionHandler;
import core.boundary.Presenter;
import minidraw.standard.MiniDrawApplication;

import java.util.List;

public class LoPAMainApp extends MiniDrawApplication implements Presenter {
    private ActionHandler actionHandler;

    public LoPAMainApp(ActionHandler actionHandler) {
        super("Legend of Parker Auditorium", new LoPAFactory());
        this.actionHandler = actionHandler;
    }

    public void showMainMenu(List<MenuOption> options) {
        // TODO: Show the options, allow for option to be chosen
    }

    @Override
    public void showAvailableBuildings(List<MenuOption> availableBuildings) {

    }

    @Override
    public void showUpdatedInsideLocation(Coordinates insideLocation) {

    }

    @Override
    public void transitionScreen() {
        //TODO; Implement Story Screen With Click To Continue.
    }

    @Override
    public void showErrorForRestrictedBuilding(String errorMessage) {

    }

    @Override
    public void showErrorForInvalidBuilding(String errorMessage) {

    }

    @Override
    public void showChoiceOfBuilding(Building chosenBuilding) {

    }

    @Override
    public void showErrorForNotBeingAtExist(String errorMessage) {

    }

    @Override
    public void showErrorForGameNotStarted(String errorMessage) {

    }
}
