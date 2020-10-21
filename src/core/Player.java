package core;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return xValue == player.xValue &&
                yValue == player.yValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xValue, yValue);
    }
}
