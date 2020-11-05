package core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuildingTest {

    @Test
    public void canAddEnemyToBuilding(){
        Building building1 = new Building("building1", 0);
        Coordinates cords = new Coordinates(1,1);
        Enemy enemy1 = new Enemy(cords);
        building1.addEnemy(enemy1);
        assertEquals(enemy1, building1.getEnemyAtIndex(0));
    }
}