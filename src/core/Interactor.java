package core;

import core.boundary.ActionHandler;
import core.boundary.Presenter;

public class Interactor implements ActionHandler {
    public static Game game;
    private Presenter presenter;

    public Result performAction(UserAction start){
        return start.Action();
    }

    public void perform(SelectBuildingAction action){
        if (action.getBuildingNum() < 0 || action.getBuildingNum() > game.sizeOfBuildingList()){
            throw new RuntimeException("No Such Building index value");
        }
        //handle case of no-game-started
        // ask game about building with id action.id/name
        // check if player has access to that building
        // if yes, then call suitable presenter method and change game state to have enter the building
        // if no, call presenter method to display error message
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
