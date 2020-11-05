package core;

import core.action.*;
import core.boundary.ActionHandler;
import core.boundary.Presenter;

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
        presenter.transitionScreen("MessageFiles/StartMessage.txt", new SeeAvailableBuildingsAction());
    }

    public void perform(SelectBuildingAction action){
        String buildingName = action.buildingName;
        try {
            Building building = game.getBuildingNamed(buildingName);
            BuildingView buildingInfo = BuildingConvert.getBuildingViewInfo(building);
            presenter.showChoiceOfBuilding(buildingInfo);
            game.enterBuilding(building);
        } catch (RuntimeException e){
            presenter.showError(e.toString());
        }
    }

    public void perform(MovementAction action) {
        try {
            game.updatePosition(action.direction);
        } catch (RuntimeException e) {
            System.out.println(e.toString());
            return; // return without updating UI
        }
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

    public void perform(SeeAvailableBuildingsAction action) {
        if (game == null) {
            presenter.showError("Sorry game has yet to start!");
        }
        else {
            List<Building> availableBuildings = game.produceAvailableBuildings();
            List<MenuOption> menuOptions = convertBuildingsToMenuOptions(availableBuildings);
            presenter.showAvailableBuildings(menuOptions);
        }
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

