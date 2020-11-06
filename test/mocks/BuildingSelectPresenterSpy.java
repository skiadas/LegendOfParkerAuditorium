package mocks;

import core.BuildingView;

public class BuildingSelectPresenterSpy extends PresenterStub{
    public boolean showChoiceOfBuildingCalled = false;
    public BuildingView chosenBuilding;
    public boolean showErrorMessageCalled = false;
    public String message;

    public void showChoiceOfBuilding(BuildingView chosenBuilding){
        showChoiceOfBuildingCalled = true;
        this.chosenBuilding = chosenBuilding;
    }

    public void showError(String message) {
        showErrorMessageCalled = true;
        this.message = message;
    }
}
