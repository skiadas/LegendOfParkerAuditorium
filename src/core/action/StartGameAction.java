package core.action;

import core.Game;
import core.Interactor;
import core.OkResult;
import core.Result;

public class StartGameAction implements UserAction{
    @Override
    public Result Action() {
        System.out.print("Game Started");
        Interactor.game = new Game();
        return new OkResult();
    }
}
