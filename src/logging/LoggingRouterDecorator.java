package logging;

import core.boundary.UserAction;
import core.boundary.ActionRouter;

public class LoggingRouterDecorator implements ActionRouter {
    private Logger logger;
    private ActionRouter router;

    public LoggingRouterDecorator(ActionRouter router, Logger logger) {
        this.router = router;
        this.logger = logger;
    }

    public void perform(UserAction action) {
        logger.log(action);
        router.perform(action);
    }

    public UserAction getStartAction() {
        return router.getStartAction();
    }
}
