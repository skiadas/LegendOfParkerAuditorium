import core.Interactor;
import core.MessageFactory;
import core.StandardMessageFactory;
import ui.LoPAMainApp;

public class Main {
    public static void main(String[] args) {
        MessageFactory.setInstance(new StandardMessageFactory());
        Interactor interactor = new Interactor();
        LoPAMainApp uiMain = new LoPAMainApp(interactor);
        interactor.setPresenter(uiMain);
        uiMain.open();
    }
}
