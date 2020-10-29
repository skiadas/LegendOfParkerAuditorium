package core;

import core.action.*;
import core.boundary.ActionHandler;
import core.boundary.Presenter;
import core.action.MovementAction;

import java.util.List;

public class Interactor implements ActionHandler {
    public Game game = null;
    private Presenter presenter;

    public void perform(StartGameAction action) throws GameAlreadyStartedException {
        if(game != null) {
            throw new GameAlreadyStartedException("Game Already Started");
        }
        this.game = new Game();
        presenter.transitionScreen("Game Started\nOn a dark and spooky night...\nSomething tragic happened that closed Parker Auditorium forever..." +
                "A student wondered into Parker after hours and never made it out. Their spirit haunts anyone who dares to enter. ", new SeeAvailableBuildingsAction());
    }

    public void perform(SelectBuildingAction action){
        //handle case of no-game-started
        // ask game about building with id action.id/name
        // check if player has access to that building
        // if yes, then call suitable presenter method and change game state to have enter the building
        // if no, call presenter method to display error message
        if (!game.getBuildingAtIndex(action.getBuildingNum()).canEnter())
        {
            presenter.showErrorForRestrictedBuilding("Oh, sorry you are unable to access this building!");
        }
        else if (game.getBuildingAtIndex(action.getBuildingNum()).canEnter()){
            presenter.showAvailableBuildings(game.produceAvailableBuildings());
        }

        if (game.isInvalidIndex(action.getBuildingNum())){
            presenter.showErrorForInvalidIndex("No Such Building index value");
        }
        //presenter.showChoiceOfBuilding(game.getChosenBuilding());
    }

    public void perform(MovementAction action) {
        // TODO: check if tile is movable

        switch (action.direction) {
            case up:
                game.updateY(MovementAction.SPEED);
                break;
            case down:
                game.updateY(-MovementAction.SPEED);
                break;
            case left:
                game.updateX(-MovementAction.SPEED);
                break;
            case right:
                game.updateX(MovementAction.SPEED);
                break;
            default:
                break;
        }
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
    public void setGame(Game game) {
        this.game = game;
    }
    public List<Building> getBuildings(){
        return game.getBuildings();
    }

    public void perform(SeeAvailableBuildingsAction action){
        List<Building> availableBuildings = action.viewAvailableBuildings(game);
        presenter.showAvailableBuildings(availableBuildings);
    }

    static class GameAlreadyStartedException extends Exception {
        public GameAlreadyStartedException(String message) {
            super(message);
        }
    }
}

