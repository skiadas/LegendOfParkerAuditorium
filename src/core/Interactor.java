package core;

import core.action.*;
import core.boundary.ActionHandler;
import core.boundary.Presenter;
import core.action.MovementAction;

import java.util.ArrayList;
import java.util.List;

public class Interactor implements ActionHandler {
    public Game game = null;
    private Presenter presenter;
    private Building chosenBuilding = null;

    public void perform(StartGameAction action) throws GameAlreadyStartedException {
        if(game != null) {
            throw new GameAlreadyStartedException("Game Already Started");
        }
        this.game = new Game();
        presenter.transitionScreen();
        perform(new SeeAvailableBuildingsAction());
    }

    public void perform(SelectBuildingAction action){
        //handle case of no-game-started
        if (game == null) {
            presenter.showErrorForGameNotStarted("Sorry game has yet to start!");
        }
        // ask game about building with id action.id/name
        // check if a player into already inside a building
        if (game.isNotWithinABuilding()) {
            presenter.showErrorForNotBeingAtExist("Oh, sorry you cannot select a new building until you are at exist of THIS building!");
        }
        // check if player has access to that building
        // if yes, then call suitable presenter method and change game state to have enter the building
        // if no, call presenter method to display error message
        if (game.isWithinABuilding())
        {
            presenter.showErrorForRestrictedBuilding("Oh, sorry you are unable to access this building!");
        }
        else if (game.isNotWithinABuilding()){
            List<MenuOption> menuOptions = convertBuildingsToMenuOptions(game.produceAvailableBuildings());
            presenter.showAvailableBuildings(menuOptions);
            presenter.showChoiceOfBuilding(game.getBuildingBasedOnName(action.getSelectedBuildingName()));
            game.enterBuilding(game.getBuildingBasedOnName(action.getSelectedBuildingName()));
        }
        if (!game.isSelectedBuildingInBuildingList(action.getSelectedBuildingName()))
        {
            presenter.showErrorForInvalidBuilding("No Such Building");;
        }
        presenter.showChoiceOfBuilding(game.getBuildingBasedOnName(action.getSelectedBuildingName()));
    }

    public void perform(MovementAction action) {
        // TODO: check if tile is movable
        // check if tile is a movable tile
        // if yes, update player location
        // if no, throw exception
        game.updatePosition(action.direction);
        presenter.showUpdatedInsideLocation(game.getCoords());
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
        return game.enterBuilding(building);
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
        List<Building> availableBuildings = game.produceAvailableBuildings();
        List<MenuOption> menuOptions = convertBuildingsToMenuOptions(availableBuildings);
        presenter.showAvailableBuildings(menuOptions);
    }

    static class GameAlreadyStartedException extends Exception {
        public GameAlreadyStartedException(String message) {
            super(message);
        }
    }

    public List<MenuOption> convertBuildingsToMenuOptions(List<Building> buildings) {
        List<MenuOption> menuOptions = new ArrayList<>();
        for (Building building : buildings) {
            MenuOption m = new MenuOption(building.getBuildingName(), new SelectBuildingAction(building.getBuildingName()));
            menuOptions.add(m);
        }
        return menuOptions;
    }
}

