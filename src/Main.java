import core.Interactor;
import core.MessageFactory;
import core.StandardMessageFactory;
import core.boundary.ActionRouter;
import core.boundary.Presenter;
import ui.LoPAMainApp;

public class Main {

    public static void main(String[] args) {
        new Main().start();
    }

    void start() {
        MessageFactory.setInstance(new StandardMessageFactory());
        Interactor interactor = new Interactor();
        LoPAMainApp uiMain = new LoPAMainApp(setupInteractor(interactor));
        interactor.setPresenter(setupPresenter(uiMain));
        uiMain.open();
    }

    protected ActionRouter setupInteractor(ActionRouter router) {
            return router;
    }

    protected Presenter setupPresenter(Presenter presenter) {
            return presenter;
    }
}
