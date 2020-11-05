package core;

import org.junit.Test;
import java.util.concurrent.ThreadLocalRandom;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccessRestrictionTest {

    private final int randomAmountOfKeys = ThreadLocalRandom.current().nextInt(0, 10 + 1);
    private final Game game = new Game();
    private final Building buildingNeedingThreeKeys = new Building("buildingNeedingThreeKeys", 3);
    private final Building buildingNeedingOneKey = new Building("buildingNeedingOneKey", 1);
    private final Building buildingNeedingRandomAmountOfKeys = new Building("buildingNeedingRandomAmountOfKeys", randomAmountOfKeys);

    @Test
    public void canEnterBuildingWithEnoughKeys() {
        setupGame(buildingNeedingRandomAmountOfKeys, randomAmountOfKeys);
        assertTrue(game.hasAccessTo(buildingNeedingRandomAmountOfKeys));

    }

    @Test
    public void canEnterBuildingWithMoreThanEnoughKeys() {
        setupGame(buildingNeedingOneKey, 3);
        assertTrue(game.hasAccessTo(buildingNeedingOneKey));
    }

    @Test
    public void cannotEnterBuildingWithoutEnoughKeys() {
        setupGame(buildingNeedingThreeKeys, 0);
        assertFalse(game.hasAccessTo(buildingNeedingThreeKeys));
    }

    private void setupGame(Building building, int amountOfKeys) {
        game.addBuilding(building);
        game.setInventory(amountOfKeys);
    }
}
