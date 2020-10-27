package core;

import core.action.*;
import core.boundary.ActionHandler;
import core.boundary.Presenter;
import core.movement.UpwardsMovementAction;

import java.util.List;

public class Interactor implements ActionHandler {
    private static Game game;
    private Presenter presenter;

    public Result performAction(StartGameAction action){
        System.out.print("Game Started");
        Interactor.game = new Game();
        return new OkResult();
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

    public void perform(UpwardsMovementAction action) {
        // TODO: check if tile is movable
        game.updateY(UpwardsMovementAction.SPEED);
        // check if tile is a movable tile
        // if yes, update player location
        // if no, throw exception
    }

//    public void perform(DownwardsMovementAction action) {
//        // TODO: check if tile is movable
//        game.updateY(UpwardsMovementAction.SPEED);
//        // check if tile is a movable tile
//        // if yes, update player location
//        // if no, throw exception
//    }

    public void perform(AppLoadAction action) {
        // TODO: Should really not hard-code the actions like that
        List<MenuOption> menuOptions = List.of(
                new MenuOption("New Game", new NewGameAction()),
                new MenuOption("Save Game", new SaveGameAction()));
        presenter.showMainMenu(menuOptions);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    // For test
    public Game getGame() {
        return game;
    }
}
