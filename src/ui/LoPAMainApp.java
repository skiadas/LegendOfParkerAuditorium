package ui;

import core.*;
import core.action.SeeAvailableBuildingsAction;
import core.action.UserAction;
import core.boundary.ActionRouter;
import core.boundary.Presenter;
import minidraw.standard.MiniDrawApplication;

import java.io.IOException;
import java.util.List;

public class LoPAMainApp extends MiniDrawApplication implements Presenter {
    private ActionRouter actionRouter;

    public LoPAMainApp(ActionRouter actionRouter) {
        super("Legend of Parker Auditorium", new LoPAFactory());
        this.actionRouter = actionRouter;
        UserAction startAction = actionRouter.getStartAction();
        actionRouter.perform(startAction);
    }

    public void showMainMenu(List<MenuOption> options) {
        // TODO: Show the options, allow for option to be chosen
        // ....
        UserAction action = options.get(0).action;
        actionRouter.perform(action);
    }

    @Override
    public void showAvailableBuildings(List<MenuOption> availableBuildings) {

    }

    @Override
    public void showUpdatedInsideLocation(Coordinates insideLocation) {

    }

    public void message(String fileName, UserAction action) throws IOException {
        String message = AssetReader.fileToString(fileName);
        actionRouter.perform(action);
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

}
