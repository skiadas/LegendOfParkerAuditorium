package ui;

import core.boundary.ActionRouter;
import core.boundary.MenuOption;
import org.junit.Before;
import org.junit.Test;
import ui.framework.Element;
import ui.framework.NamedCommand;
import ui.framework.TransitionScreen;
import ui.framework.UIFactory;
import ui.stubs.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoPAMainAppTest {
    private ActionRouterStub routerSpy;
    private TestableLoPAMainApp app;
    private UIFactoryStub uiFactoryStub;
    private MainViewStub view;
    private MenuStub menu;
    private TransitionScreenStub transitionScreen;

    @Before
    public void setUp() {
        routerSpy = new ActionRouterStub();
        view = new MainViewStub();
        menu = new MenuStub();
        transitionScreen = new TransitionScreenStub();
        uiFactoryStub = new UIFactoryStub(view, menu, transitionScreen);
        app = new TestableLoPAMainApp(routerSpy, uiFactoryStub);
    }

    @Test
    public void whenAppOpens_IsMainViewIsCreatedAndStartUserActionIsTriggered() {
        app.open();
        assertTrue(uiFactoryStub.createMainViewCalled);
        assertTrue(routerSpy.startActionPerformed);
    }

    @Test
    public void whenShowMainMenuIsCalled_AMainMenuShouldBeCreatedAndAddedToViewAndContainsAppropriateCommands() {
        app.open();
        List<MenuOption> options = List.of(makeMenuOptionStub(1), makeMenuOptionStub(2));
        app.showMainMenu(options);
        assertTrue(uiFactoryStub.createMainMenuCalled);
        assertViewConsistsOf(List.of(menu));
        assertGeneratedMenuItemsMatchProvidedOptions(options, menu.addedItems);
    }

    private void assertGeneratedMenuItemsMatchProvidedOptions(List<MenuOption> options, List<NamedCommand> addedItems) {
        assertEquals(2, addedItems.size());
        for (int i = 0; i < addedItems.size(); i++) {
            assertCreatedCommandClosesMenuAndMatchesOption(addedItems.get(i), options.get(i));
        }
    }

    private void assertCreatedCommandClosesMenuAndMatchesOption(NamedCommand createdCommand, MenuOption option) {
        assertEquals(option.name, createdCommand.name);
        createdCommand.command.execute();
        assertViewConsistsOf(List.of());
        assertEquals(option.action, routerSpy.getLastRequestedPerform());
    }

    @Test
    public void whenShowTransitionIsCalled_thenTransitionScreenIsAdded() {
        app.open();
        UserActionStub action = new UserActionStub(0);
        app.showTransition("message", action);
        assertViewConsistsOf(List.of(transitionScreen));
        assertEquals("message", uiFactoryStub.transitionScreenMessage);
        assertTrue(transitionScreen.onCloseCalled);
        transitionScreen.providedCommand.execute();
        assertViewConsistsOf(List.of());
        assertEquals(action, routerSpy.getLastRequestedPerform());
    }

    @Test
    public void showBuildingsWorks() {
        app.open();
    }

    public MenuOption makeMenuOptionStub(int i) {
        return new MenuOption("option " + i, new UserActionStub(i));
    }

    private void assertViewConsistsOf(List<Element> items) {
        assertEquals(items, view.addedItems);
    }


    private class TestableLoPAMainApp extends LoPAMainApp {
        public TestableLoPAMainApp(ActionRouter actionRouter, UIFactoryStub uiFactoryStub) {
            super(actionRouter);
            UIFactory.setInstance(uiFactoryStub);
        }
    }
}
