package mocks;

import core.MenuOption;

import java.util.List;

public class AvailableBuildingsPresenterSpy extends PresenterStub {
    public boolean showAvailableBuildingsWasCalled = false;
    public List<MenuOption> availableBuildings;

    public void showAvailableBuildings(List<MenuOption> availableBuildings){
        showAvailableBuildingsWasCalled = true;
        this.availableBuildings = availableBuildings;
    }
}
