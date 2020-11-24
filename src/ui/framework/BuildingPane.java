package ui.framework;

import core.boundary.ActionRouter;
import core.boundary.Coordinates;

public interface BuildingPane extends Element {
    void updateLocation(Coordinates location);

    void setRouter(ActionRouter actionRouter);
}
