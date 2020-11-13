package core;

import core.action.*;
import core.boundary.ActionHandler;
import core.boundary.Presenter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Interactor implements ActionHandler {
    public Game game = null;
    private Presenter presenter;

    public void perform(UserAction action) {
        try {
            action.accept(this);
        } catch (GameErrorException | IOException e) {
            presenter.showError(e.getMessage());
        }
    }

    public void perform(NewGameAction action) {

    }

    public void perform(StartGameAction action) throws IOException {
        if (game != null) {
            presenter.showError("Game Already Started");
        } else {
            this.game = new Game();
            presenter.message("MessageFiles/StartMessage.txt", ActionFactory.seeAvailableBuildings());
        }
    }

    public void perform(SelectBuildingAction action) {
        String buildingName = action.buildingName;
        Game game = getGameOrFail();
        Building building = game.getBuildingNamed(buildingName);
        BuildingView buildingInfo = BuildingConvert.getBuildingViewInfo(building);
        game.enterBuilding(building);
        presenter.showChoiceOfBuilding(buildingInfo);
        presenter.showUpdatedInsideLocation(game.getCoords());
    }

    public void perform(MovementAction action) {
        Game game = getGameOrFail();
        game.updatePosition(action.direction);
        presenter.showUpdatedInsideLocation(game.getCoords());
        showDeathScreenIfPlayerOnEnemySquare();
        exitBuildingIfPLayerOnExitCell();
    }

    public void exitBuildingIfPLayerOnExitCell() {
        if (game.canExitBuilding()) {
            game.setLocation(new MapLocation());
            perform(ActionFactory.seeAvailableBuildings());
        }
    }

    private void showDeathScreenIfPlayerOnEnemySquare() {
        List<Enemy> enemies = game.getCurrentBuilding().getListOfEnemies();
        for (Enemy enemy : enemies) {
            if (enemy.getEnemyCords().equals(game.getCoords())) {
                presenter.showDeathScreen("You Are Dead");
            }
        }
        perform(ActionFactory.appLoadAction());
    }

    public void perform(AppLoadAction action) {
        // TODO: Should really not hard-code the actions like that
        List<MenuOption> menuOptions = List.of(
                new MenuOption("New Game", ActionFactory.startGameAction()),
                new MenuOption("Save Game", ActionFactory.saveGameAction()));
        presenter.showMainMenu(menuOptions);
    }

    public void perform(SaveGameAction action) {
        // TODO
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
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

