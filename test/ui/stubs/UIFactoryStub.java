package ui.stubs;

import core.boundary.BuildingView;
import ui.framework.*;

import java.util.HashMap;

public class UIFactoryStub extends UIFactory {
    public boolean createMainViewCalled = false;
    public boolean createMainMenuCalled = false;
    public String transitionScreenMessage;
    private MainViewStub viewStub;
    private MenuStub menuStub;
    private TransitionScreen transitionScreen;

    public UIFactoryStub(MainViewStub viewStub, MenuStub menuStub, TransitionScreen transitionScreen) {
        this.viewStub = viewStub;
        this.menuStub = menuStub;
        this.transitionScreen = transitionScreen;
    }

    public MainView createMainView(String title, int width, int height) {
        createMainViewCalled = true;
        return viewStub;
    }

    public Menu createMainMenu() {
        createMainMenuCalled = true;
        return menuStub;
    }

    public Button createButton(String name, Command command) {
        return new ButtonStub(name, command);
    }

    public TransitionScreen createTransitionScreen(String message) {
        transitionScreenMessage = message;
        return transitionScreen;
    }

    public BuildingPane createBuildingPane(BuildingView buildingView) {
        return null;
    }
}
