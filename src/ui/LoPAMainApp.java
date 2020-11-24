package ui;

import core.boundary.*;
import ui.framework.*;
import ui.impl.MyUIFactory;

import java.util.List;
import java.util.stream.Collectors;

public class LoPAMainApp implements Presenter {
    private ActionRouter actionRouter;
    private MainView view;
    private BuildingPane buildingPane;

    public LoPAMainApp(ActionRouter actionRouter) {
        UIFactory.setInstance(new MyUIFactory());
        this.actionRouter = actionRouter;
    }

    public void initializeView() {
        this.view = UIFactory.getInstance().createMainView("Legend of Parker Auditorium", 1000, 700);
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
        // TODO: if building visible, hide it
        view.add(createMainMenuWithOptions(availableBuildings));
    }

    @Override
    public void showUpdatedInsideLocation(Coordinates insideLocation) {
        buildingPane.updateLocation(insideLocation);
    }

    public void showTransition(String message, UserAction action) {
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
        buildingPane = UIFactory.getInstance().createBuildingPane(buildingView);
        view.add(buildingPane);
        buildingPane.setRouter(actionRouter);
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

    public void open() {
        initializeView();
        actionRouter.performStartAction();
    }

    private Command close(Element element) {
        return () -> view.remove(element);
    }

    private Command trigger(UserAction action) {
        return () -> actionRouter.perform(action);
    }

    private Command chained(Command cmd1, Command cmd2) {
        return () -> { cmd1.execute(); cmd2.execute(); };
    }

}
