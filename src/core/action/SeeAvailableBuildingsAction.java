package core.action;

import core.Building;
import core.Game;

import java.util.List;

public class SeeAvailableBuildingsAction implements UserAction {
    public List<Building> viewAvailableBuildings(Game game) {
        return game.produceAvailableBuildings();
    }
}
