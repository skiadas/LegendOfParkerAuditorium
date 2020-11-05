package core;

import java.util.ArrayList;
import java.util.List;

import java.util.Objects;

public class Building {
    private String name;
    private int requiredNumOfKeys;
    private List<LocatedItem<Integer>> keys = new ArrayList<>() {
    };
    private List<Enemy> enemies = new ArrayList<>();
    private Coordinates upperLeft;
    private Coordinates lowerRight;
    private Coordinates buildingEntrance = new Coordinates(0, 0);

    Building(String name) {
        this(name, 0);
    }

    Building(String name, int requiredNumOfKeys) {
        this.name = name;
        this.requiredNumOfKeys = requiredNumOfKeys;
        this.setBuildingBoundaries();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return requiredNumOfKeys == building.requiredNumOfKeys &&
                Objects.equals(name, building.name) &&
                Objects.equals(upperLeft, building.upperLeft) &&
                Objects.equals(lowerRight, building.lowerRight);
    }


    String getBuildingName() {
        return name;
    }
    int getRequiredNumOfKeys() {
        return requiredNumOfKeys;
    }
    Coordinates getEntranceCoordinates() {
        return buildingEntrance;
    }

    // Some buildings could have different entrances?
    //      By default the entrance should still be 0, 0
    void setEntranceCoordinates(int x, int y) {
        buildingEntrance = new Coordinates(x, y);
    }

    public void addLocatedItem(Coordinates coords) {
        keys.add(new LocatedItem<>(coords));
    }

    public boolean hasKeyAt(Coordinates coords) {
        if (keys.size() == 0) { return false; }
        for (int i = 0; i < keys.size(); i++) {
            if (hasLocatedItemWithMatchingCoords(coords, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasLocatedItemWithMatchingCoords(Coordinates coords, int i) {
        return keys.get(i).getCoords() == coords;
    }

    boolean isValidMovement(Coordinates requestedMove) {
        if (isInsideBuilding(requestedMove)) {
            // TODO: checking if tile is a wall or other invalid movement tile
            return true;
        }
        return false;
    }

    public Coordinates getLowerRight() {
        return lowerRight;
    }

    public Coordinates getUpperLeft() {
        return upperLeft;
    }

    private boolean isInsideBuilding(Coordinates requestedMove) {
        return (requestedMove.xValue >= upperLeft.xValue && requestedMove.yValue <= upperLeft.yValue)
                && (requestedMove.xValue <= lowerRight.xValue && requestedMove.yValue >= lowerRight.yValue);
    }

    private void setBuildingBoundaries(){
        this.upperLeft = new Coordinates(-20,20);
        this.lowerRight = new Coordinates(20,-20);
    }

    public void addEnemy(Enemy enemy, Coordinates cords) throws Exception {
        if (!isInsideBuilding(cords)){
            throw new Exception("These Coordinates are not withing the building");
        }
        else {
            this.enemies.add(enemy);
            enemy.setCords(cords);
        }
    }

    public Enemy getEnemyAtIndex(int index) {
        return this.enemies.get(index);
    }
}
