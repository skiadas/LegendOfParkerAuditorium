package core;

import org.junit.Test;
import java.util.concurrent.ThreadLocalRandom;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccessRestrictionTest extends BaseAppTest {

    @Test
    public void canEnterBuildingWithEnoughKeys() {
        int randomKeys = ThreadLocalRandom.current().nextInt(0, 10 + 1);
        assertTrue(hasEnoughKeysToAccess(randomKeys, randomKeys));
    }

    @Test
    public void canEnterBuildingWithMoreThanEnoughKeys() {
        assertTrue(hasEnoughKeysToAccess(1, 3));
    }

    @Test
    public void cannotEnterBuildingWithoutEnoughKeys() {
        assertFalse(hasEnoughKeysToAccess(3, 0));
    }

    public boolean hasEnoughKeysToAccess(int requiredKeys, int availableKeys) {
        Building building = new Building("building", requiredKeys);
        setupGame(building, availableKeys);
        return game.hasAccessTo(building);
    }

    private void setupGame(Building building, int amountOfKeys) {
        game.addBuilding(building);
        game.setInventory(amountOfKeys);
    }
}
