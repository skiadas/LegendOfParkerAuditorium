package mocks;

import core.BuildingView;
import core.location.Coordinates;

public class BuildingSelectPresenterSpy extends PresenterStub{
    public boolean showChoiceOfBuildingCalled = false;
    public BuildingView chosenBuilding;
    public boolean showErrorMessageCalled = false;
    public String message;
    public boolean showUpdatedLocationCalled = false;
    public Coordinates showUpdatedLocation;

    public void showChoiceOfBuilding(BuildingView chosenBuilding){
        showChoiceOfBuildingCalled = true;
        this.chosenBuilding = chosenBuilding;
    }

    public void showError(String message) {
        showErrorMessageCalled = true;
        this.message = message;
    }

    public void showUpdatedInsideLocation(Coordinates insideLocation){
        showUpdatedLocationCalled = true;
        this.showUpdatedLocation = insideLocation;
    }
}
