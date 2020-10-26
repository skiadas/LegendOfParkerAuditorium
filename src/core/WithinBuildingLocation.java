package core;


public class WithinBuildingLocation extends PlayerLocation {
    public int xValue;
    public int yValue;

    public WithinBuildingLocation(int xValue, int yValue) {
        super();
        this.xValue = xValue;
        this.yValue = yValue;
    }

    public int getxValue() {
        return xValue;
    }

    public int getyValue() {
        return yValue;
    }

    public void setxValue(int xValue) {
        this.xValue = xValue;
    }

    public void setyValue(int yValue) {
        this.yValue = yValue;
    }

    public void moveX(int amount) {
        xValue += amount;
    }

    public void moveY(int amount) {
        yValue += amount;
    }
}
