package core;

import core.exceptions.GameErrorException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuildingTest extends BaseAppTest {

    @Test
    public void canAddEnemyToBuilding() throws Exception {
        Building building1 = new Building("building1", 0);
        Coordinates cords = new Coordinates(1,1);
        Enemy enemy1 = new Enemy();
        building1.addEnemy(enemy1, cords);
        assertEquals(enemy1, building1.getEnemyAtIndex(0));
    }

    @Test
    public void cannotAddTwoEquivalentBuildings() {
        Building building1 = new Building("building1", 0);
        game.addBuilding(building1);
        game.addBuilding(building1);
        assertEquals(1, game.sizeOfBuildingList());
    }

    @Test
    public void canAddBuildingsWithSameName() {
        Building building1 = new Building("building1", 0);
        Building building2 = new Building("building1", 0);
        game.addBuilding(building1);
        game.addBuilding(building2);
        assertEquals(2, game.sizeOfBuildingList());
    }

    @Test (expected = Exception.class)
    public void canNotAddEnemyBecauseCordinatesOutsideBuilding() throws Exception{
        Building building1 = new Building("building1", 0);
        Coordinates cords = new Coordinates(-25, 30);
        Enemy enemy1 = new Enemy();
        building1.addEnemy(enemy1,cords);
    }

    @Test (expected = Exception.class)
    public void canNotAddEnemyBecauseCordinatesAreADoor() throws Exception{
        Building building1 = new Building("building1", 0);
        building1.setEntranceCoordinates(2,0);
        Coordinates cords = new Coordinates(2, 0);
        Enemy enemy1 = new Enemy();
        building1.addEnemy(enemy1,cords);
    }

    @Test (expected = Exception.class)
    public void canNotAddEnemyBecauseEnemyIsAlreadyThere() throws Exception{
        Building building1 = new Building("building1", 0);
        Coordinates cords = new Coordinates(-25, 30);
        Enemy enemy1 = new Enemy();
        Enemy  enemy2 = new Enemy();
        building1.addEnemy(enemy1,cords);
        building1.addEnemy(enemy2,cords);
    }
}