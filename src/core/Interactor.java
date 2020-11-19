package core;

import core.action.*;
import core.boundary.ActionHandler;
import core.boundary.Presenter;
import core.exceptions.GameErrorException;
import core.location.MapLocation;

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
            this.game = (new GameCreator().createGame());
            presenter.showTransition(AssetReader.fileToString("MessageFiles/StartMessage.txt"), ActionFactory.seeAvailableBuildings());
        }
    }

    public void perform(SelectBuildingAction action) {
        String buildingName = action.buildingName;
        Game game = getGameOrFail();
        if (game.isWithinABuilding()) {
            throw GameErrorException.mustExitBuilding();
        }
        Building building = game.getBuilding(buildingName);
        BuildingView buildingInfo = BuildingConvert.getBuildingViewInfo(building);
        game.enterBuilding(building);
        presenter.showChoiceOfBuilding(buildingInfo);
        presenter.showUpdatedInsideLocation(game.getCoords());
    }

    public void perform(MovementAction action) {
        Game game = getGameOrFail();
        game.updatePosition(action.direction);
        presenter.showUpdatedInsideLocation(game.getCoords());
        handleAfterMovementAction();
    }

    public void handleAfterMovementAction() {
        List<Enemy> enemies = game.getCurrentBuilding().getListOfEnemies();
        for (Enemy enemy : enemies) {
            if (enemyOnPlayerSquare(enemy)) {
                showDeathScreen();
            }
        }
        if (playerExitsFinalBuilding()) {
            perform(ActionFactory.gameWonAction());
        } else if (game.canExitBuilding()) {
            game.setLocation(new MapLocation());
            perform(ActionFactory.seeAvailableBuildings());
        } else if (game.getCurrentBuilding().hasKeyAt(game.getCoords())) {
            game.getInventory().addKey(); }
    }

    public boolean playerExitsFinalBuilding() {
        return game.canExitBuilding() && game.getCurrentBuilding().getIsFinalBuilding();
    }

    private void showDeathScreen() {
        presenter.showDeathScreen(MessageFactory.getInstance().characterIsDead());
        perform(ActionFactory.appLoadAction());
    }

    private boolean enemyOnPlayerSquare(Enemy enemy) {
        return enemy.getEnemyCords().equals(game.getCoords());
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

    @Override
    public void perform(GameWonAction action) {
        presenter.showWinScreen(MessageFactory.getInstance().gameWon());
        perform(ActionFactory.appLoadAction());

    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private Game getGameOrFail() {
        if (game == null) {
            throw GameErrorException.gameNotStarted();
        }
        return game;
    }

    // For test
    public Game getGame() {
        return game;
    }

    public void setNoGame() {
        setGame(null);
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

