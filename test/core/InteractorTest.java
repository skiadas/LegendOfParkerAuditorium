package core;

import core.action.EnterTheBuilding;
import core.action.StartGameAction;
import core.movement.UpwardsMovementAction;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class InteractorTest {
    @Test
    public void canCreateGame(){
        Interactor i = new Interactor();
        StartGameAction start = new StartGameAction();
        assertThat(new OkResult(), instanceOf(i.perform(start).getClass()));
    }

    @Test
    public void canMoveUp() {
        Interactor i = new Interactor();
        UpwardsMovementAction moveUp = new UpwardsMovementAction();
        i.perform(moveUp);
        assertEquals(1, getyValue(i));
    }

    @Ignore
    @Test
    public void canMoveUpMultipleTimes() {
        Interactor i = new Interactor();
        UpwardsMovementAction moveUp = new UpwardsMovementAction();
        i.perform(moveUp);
        i.perform(moveUp);
        i.perform(moveUp);
        assertEquals(3, getyValue(i));
    }

    private int getyValue(Interactor i) {
        return i.getGame().getInsideLocation().yValue;
    }

    @Test
    public void canEnterTheBuilding() {
        Interactor i = new Interactor();
        i.perform(new StartGameAction());
        assertThat(new OkResult(), instanceOf(i.perform(new EnterTheBuilding()).getClass()));
    }
}
