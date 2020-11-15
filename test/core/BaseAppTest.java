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

    protected void addBuildingAndMoveToItsEntrance() {
        Building b = new Building("building1");
        game.addBuilding(b);
        game.setLocation(WithinBuildingLocation.atEntranceOf(b));
    }

}
