package core;

import core.action.*;
import core.boundary.ActionHandler;
import core.boundary.Presenter;
import core.exceptions.GameErrorException;

import java.util.ArrayList;
import java.util.List;

public class Interactor implements ActionHandler {
    public Game game = null;
    private Presenter presenter;

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
            presenter.showError(MessageFactory.getInstance().gameAlreadyStarted());
        } else {
            this.game = new Game();
            presenter.showTransition(AssetReader.fileToString("MessageFiles/StartMessage.txt"), ActionFactory.seeAvailableBuildings());
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
                presenter.showDeathScreen(MessageFactory.getInstance().characterIsDead());
            }
        }
        perform(ActionFactory.appLoadAction());
    }

    public void perform(AppLoadAction action) {
        // TODO: Should really not hard-code the actions like that
        List<MenuOption> menuOptions = List.of(
                new MenuOption(MessageFactory.getInstance().newGameMenuOption(), ActionFactory.startGameAction()),
                new MenuOption(MessageFactory.getInstance().saveGameMenuOption(), ActionFactory.saveGameAction()));
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
            throw new GameErrorException(MessageFactory.getInstance().gameNotStarted());
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
            presenter.showError(MessageFactory.getInstance().gameNotStarted());
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

