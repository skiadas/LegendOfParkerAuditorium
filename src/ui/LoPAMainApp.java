package ui;

import core.Building;
import core.MenuOption;
import core.action.UserAction;
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
    public void showAvailableBuildings(List<Building> availableBuildings) {

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
    public void transitionScreen(String words, UserAction action) {

    }
}
