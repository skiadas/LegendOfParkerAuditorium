package mocks;

import core.Coordinates;

public class UpdateWithinBuildingLocationSpy extends PresenterStub {
    public boolean showDeathScreenIsCalled = false;
    public boolean showUpdatePositionWasCalled = false;
    public Coordinates providedLocation;

    public boolean showErrorWasCalled = false;
    public String errorMessage;

    public void showUpdatedInsideLocation(Coordinates insideLocation) {
        showUpdatePositionWasCalled = true;
        providedLocation = insideLocation;
    }

    public void showError(String errorMessage) {
        showErrorWasCalled = true;
        this.errorMessage = errorMessage;
    }

    public void showDeathScreen(String message) {
        showDeathScreenIsCalled = true;
    }
}
