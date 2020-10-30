package core;


import java.util.Objects;

public class Coordinates {
    public int xValue;
    public int yValue;

    public Coordinates(int xValue, int yValue) {
        super();
        this.xValue = xValue;
        this.yValue = yValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return xValue == that.xValue &&
                yValue == that.yValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xValue, yValue);
    }

    public void updateY(int amount) {
        this.yValue += amount;
    }

    public void updateX(int amount) {
        this.xValue += amount;
    }

    public void updatePosition(Direction direction) {
        switch (direction) {
            case up:
                updateY(Direction.SPEED);
                break;
            case down:
                updateY(-Direction.SPEED);
                break;
            case left:
                updateX(-Direction.SPEED);
                break;
            case right:
                updateX(Direction.SPEED);
                break;
            default:
                break;
        }
    }
}
