package core;

public class MovementAction implements UserAction {
    public Player player;
    public MovementAction(Player player) {
        this.player = player;
    }

    // TODO: move UI element corresponding to player
    public void moveX(int amount) {
        player.moveX(amount);
    }

    // TODO: move UI element corresponding to player
    public void moveY(int amount) {
        player.moveY(amount);
    }
}
