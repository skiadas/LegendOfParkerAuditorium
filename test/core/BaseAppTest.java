package core;

import org.junit.Before;

public class BaseAppTest {
    protected Interactor interactor;

    @Before
    public void setUp(){
        MessageFactory.setInstance(new StandardMessageFactory());
        interactor = new Interactor();
    }
}
