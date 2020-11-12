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
        try {
            action.accept(this);
        } catch (GameErrorException e) {
            presenter.showError(e.getMessage());
        }
    }

    public void perform(NewGameAction action) {

    }

    public void perform(StartGameAction action) {
        if (game != null) {
            presenter.showError("Game Already Started");
        }
        this.game = new Game();
        try {
            presenter.message("MessageFiles/StartMessage.txt", ActionFactory.seeAvailableBuildings());
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
        try {
            Game game = getGameOrFail();
            game.updatePosition(action.direction);
            presenter.showUpdatedInsideLocation(game.getCoords());
            IfPlayerOnEnemy_ShowDeathScreen();
            IfPlayerOnTheDoorCell_thenExitAndShowBuildingMenu();
        } catch (InvalidMovementException | InvalidCoordinateAccessorException e) {
            presenter.showError(e.getMessage());
        }

    }

    private void IfPlayerOnTheDoorCell_thenExitAndShowBuildingMenu() {
        if(game.canExitBuilding()){
            game.setLocation(new MapLocation());
            perform(ActionFactory.seeAvailableBuildings());
        }
    }

    private void IfPlayerOnEnemy_ShowDeathScreen() {
        List<Enemy> enemies = game.getCurrentBuilding().getListOfEnemies();
        for (Enemy enemy : enemies) {
            if (enemy.getEnemyCords() == game.getCoords()) {
                presenter.showDeathScreen("You Are Dead");
            }
        }
        perform(ActionFactory.appLoadAction());
    }

    public void perform(AppLoadAction action) {
        // TODO: Should really not hard-code the actions like that
        List<MenuOption> menuOptions = List.of(
                new MenuOption("New Game", ActionFactory.newGameAction()),
                new MenuOption("Save Game", ActionFactory.saveGameAction()));
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

    private Game getGameOrFail() {
        if (game == null) {
            throw new GameErrorException("Game has not started");
        }
        return game;
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
        return ActionFactory.appLoadAction();
    }

    public List<MenuOption> convertBuildingsToMenuOptions(List<Building> buildings) {
        List<MenuOption> menuOptions = new ArrayList<>();
        for (Building building : buildings) {
            MenuOption m = new MenuOption(building.getBuildingName(), ActionFactory.selectBuildingAction(building.getBuildingName()));
            menuOptions.add(m);
        }
        return menuOptions;
    }
}

