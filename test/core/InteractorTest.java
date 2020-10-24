package core;

import org.junit.Test;

public class InteractorTest {
    @Test
    public void canCreateGame(){
        Interactor i = new Interactor();
        i.startNewGame();
    }
}
