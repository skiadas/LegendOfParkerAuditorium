package core;

import core.boundary.Coordinates;
import core.location.Location;
import core.location.MapLocation;
import core.location.WithinBuildingLocation;
import org.junit.Before;

public class BaseAppTest {
    protected Game game;
    protected Interactor interactor;

    @Before
    public void setUp() {
        MessageFactory.setInstance(new StandardMessageFactory());
        interactor = new Interactor();
        game = new Game();
        interactor.setGame(game);
    }

    protected Building addBuildingAndMoveToItsEntrance(String name) {
        Building b = addBuilding(name);
        game.setLocation(WithinBuildingLocation.atEntranceOf(b));
        return b;
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

    public Location createMapLocation() {
        return new MapLocation();
    }

    public WithinBuildingLocation createBuildingLocation(Building building, int xValue, int yValue) {
        return new WithinBuildingLocation(building, new Coordinates(xValue, yValue));
    }
}
