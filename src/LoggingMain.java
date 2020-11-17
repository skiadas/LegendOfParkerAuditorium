import core.boundary.ActionRouter;
import core.boundary.Presenter;
import logging.Logger;
import logging.LoggingRouterDecorator;

public class LoggingMain extends Main {
    private Logger logger = new Logger();

    public static void main(String[] args) {
        new LoggingMain().start();
    }

    protected ActionRouter setupInteractor(ActionRouter router) {
            return new LoggingRouterDecorator(router, logger);
    }

    protected Presenter setupPresenter(Presenter presenter) {
            return presenter;
    }

}
