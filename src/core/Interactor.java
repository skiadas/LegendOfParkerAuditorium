package core;

public class Interactor {
    public static Game game;
    public Result preformAction(UserAction start){
        return start.Action();
    }

}
