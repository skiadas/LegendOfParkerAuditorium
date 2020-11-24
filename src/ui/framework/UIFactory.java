package ui.framework;

import core.boundary.BuildingView;

public abstract class UIFactory {
    private static UIFactory instance;

    public static UIFactory getInstance() {
        if (instance == null) {
            throw new RuntimeException("Must provide a UIFactory Instance");
        }
        return instance;
    }

    public static void setInstance(UIFactory factory) {
        instance = factory;
    }

    public abstract MainView createMainView(String title, int width, int height);
    public abstract Menu createMainMenu();
    public abstract Button createButton(String name, Command command);

    Button createButton(NamedCommand command) {
        return createButton(command.name, command.command);
    }

    public abstract TransitionScreen createTransitionScreen(String message);

    public abstract BuildingPane createBuildingPane(BuildingView buildingView);
}
