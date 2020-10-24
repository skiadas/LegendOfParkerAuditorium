package core;

public class StartGameAction implements UserAction{
    @Override
    public Result Action() {
        System.out.print("Game Started");
        Interactor.game = new Game();
        return new OkResult();
    }
}
