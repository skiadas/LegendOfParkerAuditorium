package core.game;

import core.BaseAppTest;
import core.boundary.Coordinates;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildingTest extends BaseAppTest {

    @Test
    public void canAddEnemyToBuilding() throws Exception {
        Building building1 = new Building("building1", 0);
        Coordinates cords = new Coordinates(1, 1);
        Enemy enemy1 = new Enemy();
        building1.addEnemy(enemy1, cords);
        assertEquals(enemy1, building1.getEnemyAtIndex(0));
    }

    @Test
    public void falseWhenNotInBoundaries() {
        Building building1 = new Building("building1", 0);
        Coordinates cords = new Coordinates(-21, 0);
        Coordinates cords1 = new Coordinates(-21, -21);
        Coordinates cords2 = new Coordinates(0, 21);
        Coordinates cords3 = new Coordinates(21, 0);
        Coordinates cords4 = new Coordinates(21, 21);
        Coordinates cords5 = new Coordinates(0, -21);
        assertFalse(building1.isInsideBuilding(cords));
        assertFalse(building1.isInsideBuilding(cords1));
        assertFalse(building1.isInsideBuilding(cords2));
        assertFalse(building1.isInsideBuilding(cords3));
        assertFalse(building1.isInsideBuilding(cords4));
        assertFalse(building1.isInsideBuilding(cords5));
    }

    @Test
    public void trueWhenInBoundaries() {
        Building building1 = new Building("building1", 0);
        Coordinates cords = new Coordinates(0, 0);
        Coordinates cords1 = new Coordinates(-20, 0);
        Coordinates cords2 = new Coordinates(-20, -20);
        Coordinates cords3 = new Coordinates(20, 0);
        Coordinates cords4 = new Coordinates(20, 20);
        assertTrue(building1.isInsideBuilding(cords));
        assertTrue(building1.isInsideBuilding(cords1));
        assertTrue(building1.isInsideBuilding(cords2));
        assertTrue(building1.isInsideBuilding(cords3));
        assertTrue(building1.isInsideBuilding(cords4));
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
        building1.setEntrance(2,0);
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