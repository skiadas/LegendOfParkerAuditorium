package core;

import org.junit.Before;

public class BaseAppTest {
    protected Game game;
    protected Interactor interactor;

    @Before
    public void setUp(){
        MessageFactory.setInstance(new StandardMessageFactory());
        interactor = new Interactor();
        game = new Game();
        interactor.setGame(game);
    }

    protected void addBuildingAndMoveToItsEntrance(String name) {
        Building b = addBuilding(name);
        game.setLocation(WithinBuildingLocation.atEntranceOf(b));
    }

    public Building addBuilding(String name) {
        Building building = new Building(name);
        game.addBuilding(building);
        return building;
    }

    public Building addBuildingRequiringKeys(String name, int requiredKeys) {
        Building building = new Building(name, requiredKeys);
        game.addBuilding(building);
        return building;
    }
}
