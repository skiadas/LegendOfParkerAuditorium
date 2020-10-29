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
        presenter.transitionScreen("Game Started\nOn a dark and spooky night at Hanover College, something tragic happened that closed Parker Auditorium forever...\n" +
                "A student was dared to break into Parker Auditorium and stay the whole night inside.\n " +
                "While inside weird things started happening, the student started to hear suspicious noises like voices and doors started closing on their own.\n" +
                "As scared as he was he was determined to stay in Parker all night.\n" +
                "The student never made it out and eas never heard from again, closing Parker Auditorium forever!" +
                "No one dares to enter Parker and it is said that the student along with the other spirits haunt anyone who dares to enter.", new SeeAvailableBuildingsAction());
    }

    public void perform(SelectBuildingAction action){
        //handle case of no-game-started
        if (game == null) {
            presenter.showErrorForGameNotStarted("Sorry game has yet to start!");
        }
        // ask game about building with id action.id/name
        // check if a player into already inside a building
        if (!game.getInsideLocation().isBuildingEntrance()) {
            presenter.showErrorForNotBeingAtExist("Oh, sorry you cannot select a new building until you are at exist of THIS building!");
        }
        // check if player has access to that building
        // if yes, then call suitable presenter method and change game state to have enter the building
        // if no, call presenter method to display error message
        if (!game.isValidIndex(action, this))
        {
            presenter.showErrorForRestrictedBuilding("Oh, sorry you are unable to access this building!");
            presenter.showAvailableBuildings(game.produceAvailableBuildings());
        }
        else if (game.isValidIndex(action, this)){
            presenter.showChoiceOfBuilding(game.getBuildingAtIndex(action.getSelectedBuildingNum()));
            game.setLocation(game.getBuildingAtIndex(action.getSelectedBuildingNum()));
        }
        if (game.isInvalidIndex(action.getSelectedBuildingNum())){
            presenter.showErrorForInvalidIndex("No Such Building index value");
        }
        presenter.showChoiceOfBuilding(game.getBuildingAtIndex(action.getSelectedBuildingNum()));
    }

    public void perform(MovementAction action) {
        // TODO: check if tile is movable
        // check if tile is a movable tile
        // if yes, update player location
        // if no, throw exception
        game.updatePosition(action);
        presenter.showUpdatedInsideLocation(game.getInsideLocation());
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

    public Presenter getPresenter() {
        return presenter;
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

