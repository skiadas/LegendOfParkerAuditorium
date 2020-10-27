package core;

import core.action.*;
import core.boundary.ActionHandler;
import core.boundary.Presenter;
import core.action.MovementAction;

import java.util.List;

public class Interactor implements ActionHandler {
    private static Game game = null;
    private Presenter presenter;

    public void perform(StartGameAction action){
        if (game == null){
            throw new RuntimeException("Game Already Started");
        }
        System.out.print("Game Started\nOn a dark and spooky night...\nSomething tragic happened that closed Parker Auditorium forever..." +
                "A student wondered into Parker after hours and never made it out. Their spirit haunts anyone who dares to enter. ");
        Interactor.game = new Game();
        List<MenuOption> menuOptions = List.of(
                new MenuOption("New Game", new NewGameAction()),
                new MenuOption("Save Game", new SaveGameAction()));
        presenter.showMainMenu(menuOptions);

    }

    public void perform(SelectBuildingAction action){
        if (game.isInvalidIndex(action.getBuildingNum())){
            throw new RuntimeException("No Such Building index value");
        }
        //handle case of no-game-started
        // ask game about building with id action.id/name
        // check if player has access to that building
        // if yes, then call suitable presenter method and change game state to have enter the building
        // if no, call presenter method to display error message
    }

    public void perform(MovementAction action) {
        // TODO: check if tile is movable
        game.updateY(MovementAction.SPEED);
        // check if tile is a movable tile
        // if yes, update player location
        // if no, throw exception
    }

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
        Building building = action.getBuilding();
        return game.setLocation(building);
    }

    public void perform(UnlockBuildings action){
        game.unlockBuildingsByCurrentKeysInInventory();
    }

    // For test
    public Game getGame() {
        return game;
    }
    public List<Building> getBuildings(){
        return game.getBuildings();
    }
}

