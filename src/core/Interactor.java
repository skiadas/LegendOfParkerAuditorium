package core;

import core.action.*;
import core.boundary.ActionHandler;
import core.boundary.Presenter;
import core.exceptions.InvalidCoordinateAccessorException;
import core.exceptions.InvalidMovementException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Interactor implements ActionHandler {
    public Game game = null;
    private Presenter presenter;
    private Building chosenBuilding = null;

    public void perform(UserAction action) {
        action.accept(this);
    }

    public void perform(NewGameAction action) {

    }

    public void perform(StartGameAction action) {
        if (game != null) {
            presenter.showError("Game Already Started");
        }
        this.game = new Game();
        try {
            presenter.message("MessageFiles/StartMessage.txt", new SeeAvailableBuildingsAction());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void perform(SelectBuildingAction action) {
        String buildingName = action.buildingName;
        if (game == null){
            presenter.showError("Game Has Not Started");
            return;
        }
        try {
            Building building = game.getBuildingNamed(buildingName);
            BuildingView buildingInfo = BuildingConvert.getBuildingViewInfo(building);
            game.enterBuilding(building);
            presenter.showChoiceOfBuilding(buildingInfo);
            presenter.showUpdatedInsideLocation(game.getCoords());
        } catch (Game.ExistingBuildingError e) {
            presenter.showError(e.getMessage());
        }
    }

    public void perform(MovementAction action) {
        if (game == null) {
            presenter.showError("No game started.");
            return;
        }
        try {
            game.updatePosition(action.direction);
            presenter.showUpdatedInsideLocation(game.getCoords());
        } catch (InvalidMovementException | InvalidCoordinateAccessorException e) {
            presenter.showError(e.getMessage());
        } catch (RuntimeException e) {
            // TODO: change to catching a specific exception
        }
        IfPlayerOnTheDoorCell_thenExitAndShowBuildingMenu();
    }

    private void IfPlayerOnTheDoorCell_thenExitAndShowBuildingMenu() {
        if(game.isOnTheEntranceCell()){
            game.setLocation(new MapLocation());
            perform(new SeeAvailableBuildingsAction());
        }
    }

    public void perform(AppLoadAction action) {
        // TODO: Should really not hard-code the actions like that
        List<MenuOption> menuOptions = List.of(
                new MenuOption("New Game", new NewGameAction()),
                new MenuOption("Save Game", new SaveGameAction()));
        presenter.showMainMenu(menuOptions);
    }

    public void perform(SaveGameAction action) {
        // TODO
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

    public List<Building> getBuildings() {
        return game.getBuildings();
    }

    public void perform(SeeAvailableBuildingsAction action) {
        if (game == null) {
            presenter.showError("Sorry game has yet to start!");
        } else {
            List<Building> availableBuildings = game.produceAvailableBuildings();
            List<MenuOption> menuOptions = convertBuildingsToMenuOptions(availableBuildings);
            presenter.showAvailableBuildings(menuOptions);
        }
    }

    public UserAction getStartAction() {
        return new AppLoadAction();
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

