package core;

public class Player {
    public int xValue;
    public int yValue;

    public Player(int xValue, int yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }

    public void moveX(int amount) {
        xValue += amount;
    }

    public void moveY(int amount) {
        yValue += amount;
    }
}
