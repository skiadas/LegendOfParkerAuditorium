package core.boundary;

import core.action.*;

import java.io.IOException;

public interface ActionVisitor {
    void perform(SeeAvailableBuildingsAction action);
    void perform(NewGameAction action);
    void perform(StartGameAction action) throws IOException;
    void perform(SelectBuildingAction action);
    void perform(MovementAction action);
    void perform(AppLoadAction action);
    void perform(SaveGameAction action);
}
