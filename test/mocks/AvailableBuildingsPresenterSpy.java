package mocks;

import core.Building;

import java.util.List;

public class AvailableBuildingsPresenterSpy extends PresenterStub {
    public boolean showAvailableBuildingsWasCalled = false;
    public List<Building> availableBuildings;

    public void showAvailableBuildings(List<Building> availableBuildings){
        showAvailableBuildingsWasCalled = true;
        this.availableBuildings = availableBuildings;
    }
}
