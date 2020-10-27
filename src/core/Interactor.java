package core;

import core.action.*;
import core.boundary.ActionHandler;
import core.boundary.Presenter;
import core.movement.UpwardsMovementAction;

import java.util.List;

public class Interactor implements ActionHandler {
    private static Game game = null;
    private Presenter presenter;

    public void perform(StartGameAction action){
        if (game == null){
            throw new RuntimeException("Game Already Started");
        }
        System.out.print("Game Started");
        Interactor.game = new Game();
        Interactor.game.gameStarted = true;
        //Need to show building menu and show backstory
    }

    public void perform(SelectBuildingAction action){
        if (game.isInvalidIndex(action.getBuildingNum())){
            throw new RuntimeException("No Such Building index value");
        }
        //handle case of no-game-started
        if (Interactor.game.gameStarted.equals(false)){

        }
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

    public Result perform(EnterTheBuilding action){
        // See the building select menu
        // player choose one
        int indexOfBuilding = showBuildingSelector(game.getBuildings());
        // if player has enough key
        if (game.canEnterTheBuilding(indexOfBuilding)) {
            return new OkResult();
        }else{
            return new NegativeResult();
        }

    }

    private int showBuildingSelector(List<Building> buildings) {
        return 0;
    }

    // For test
    public Game getGame() {
        return game;
    }
}

