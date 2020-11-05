package ui;

import core.Coordinates;
import core.Interactor;
import core.MenuOption;
import core.action.SeeAvailableBuildingsAction;
import core.*;
import core.action.UserAction;
import core.boundary.ActionHandler;
import core.boundary.Presenter;
import minidraw.standard.MiniDrawApplication;

import core.AssetReader;
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
    public void transitionScreen(String fileName, SeeAvailableBuildingsAction action) {
        AssetReader fileReader = new AssetReader(fileName);
        fileReader.printFileTxt();
        Interactor i = new Interactor();
        i.perform(action);
    }

    @Override
    public void showChoiceOfBuilding(BuildingView buildingView) {

    }

    @Override
    public void showError(String errorMessage) {

    }

}
