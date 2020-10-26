import core.Interactor;
import ui.LoPAMainApp;

public class Main {
    public static void main(String[] args) {
        Interactor interactor = new Interactor();
        LoPAMainApp uiMain = new LoPAMainApp(interactor);
        interactor.setPresenter(uiMain);
        uiMain.open();
    }
}
