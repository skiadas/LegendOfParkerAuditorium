package core;

public class StartGameAction implements UserAction{
    @Override
    public Result Action() {
        Interactor.game = new Game();
        return new OkResult();
    }
}
