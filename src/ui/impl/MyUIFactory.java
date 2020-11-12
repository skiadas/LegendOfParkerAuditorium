package ui.impl;

import ui.framework.*;

public class MyUIFactory extends UIFactory {
    public MyUIFactory() { }

    public MainView createMainView(String title, int width, int height) {
        return new MyMainView(title, width, height);
    }

    public Menu createMainMenu() {
        return new MyMenu();
    }

    public Button createButton(String name, Command command) {
        return new MyButton(name, command);
    }

    public TransitionScreen createTransitionScreen(String message) {
        return new MyTransitionScreen(message);
    }
}