package core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuildingTest {

    @Test
    public void canAddEnemyToBuilding() throws Exception {
        Building building1 = new Building("building1", 0);
        Coordinates cords = new Coordinates(1,1);
        Enemy enemy1 = new Enemy();
        building1.addEnemy(enemy1, cords);
        assertEquals(enemy1, building1.getEnemyAtIndex(0));
    }

    @Test (expected = Exception.class)
    public void canNotAddEnemyBecauseCordinatesOutsideBuilding() throws Exception{
        Building building1 = new Building("building1", 0);
        Coordinates cords = new Coordinates(-25, 30);
        Enemy enemy1 = new Enemy();
        building1.addEnemy(enemy1,cords);
    }
}