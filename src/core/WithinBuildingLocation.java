package core;


public class WithinBuildingLocation extends Location{
    public int xValue;
    public int yValue;

    public WithinBuildingLocation(int xValue, int yValue) {
        super(true);
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
