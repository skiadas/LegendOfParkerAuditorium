package core;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class InteractorTest {
    @Test
    public void canCreateGame(){
        Interactor i = new Interactor();
        StartGameAction start = new StartGameAction();
        assertThat(new OkResult(), instanceOf(i.preformAction(start).getClass()));
    }
}
