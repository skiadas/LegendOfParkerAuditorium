package core;

import core.game.Building;
import core.game.Game;

public class GameCreator {
    public Game createGame() {
        Game game = new Game();
        Building cc = new Building("Campus Center", 0);
        Building parker = new Building("Parker", 1);
        game.addBuilding(cc);
        game.addBuilding(parker);
        return game;
    }
}
