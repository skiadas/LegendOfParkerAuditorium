package ui;

import core.AssetReader;
import core.BuildingView;
import core.Coordinates;
import core.MenuOption;
import core.action.UserAction;
import core.boundary.ActionRouter;
import core.boundary.Presenter;
import ui.framework.*;
import ui.impl.MyUIFactory;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class LoPAMainApp implements Presenter {
    private ActionRouter actionRouter;
    private MainView view;

    public LoPAMainApp(ActionRouter actionRouter) {
        UIFactory.setInstance(new MyUIFactory());
        this.view = UIFactory.getInstance().createMainView("Legend of Parker Auditorium", 1000, 700);
        this.actionRouter = actionRouter;
    }


    public void showMainMenu(List<MenuOption> options) {
        view.add(createMainMenuWithOptions(options));
    }

    private Menu createMainMenuWithOptions(List<MenuOption> options) {
        Menu menu = UIFactory.getInstance().createMainMenu();
        menu.addItems(commandsForOptions(options, menu));
        return menu;
    }

    private List<NamedCommand> commandsForOptions(List<MenuOption> options, Element menu) {
        return options.stream()
                .map(option -> menuClosingOptionCommand(option, menu))
                .collect(Collectors.toList());
    }

    private NamedCommand menuClosingOptionCommand(MenuOption option, Element menu) {
        Command command = chained(close(menu), trigger(option.action));
        return new NamedCommand(option.name, command);
    }

    @Override
    public void showAvailableBuildings(List<MenuOption> availableBuildings) {
        // TODO: We need some actual buildings now
    }

    @Override
    public void showUpdatedInsideLocation(Coordinates insideLocation) {

    }

    public void message(String fileName, UserAction action) {
        String message = AssetReader.fileToString(fileName);
        displayTransitionScreen(message, trigger(action));
    }

    private void displayTransitionScreen(String message, Command followup) {
        TransitionScreen transitionScreen =
                UIFactory.getInstance().createTransitionScreen(message);
        transitionScreen.onClose(chained(close(transitionScreen), followup));
        view.add(transitionScreen);
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

    public void open() {
//        super.open();
        UserAction startAction = actionRouter.getStartAction();
        actionRouter.perform(startAction);
    }

    private Command close(Element element) {
        return new Command() {
            public void execute() {
                view.remove(element);
            }
        };
    }

    private Command trigger(UserAction action) {
        return new Command() {
            public void execute() {
                actionRouter.perform(action);
            }
        };
    }

    private Command chained(Command cmd1, Command cmd2) {
        return new Command() {
            public void execute() {
                cmd1.execute();
                cmd2.execute();
            }
        };
    }

}
