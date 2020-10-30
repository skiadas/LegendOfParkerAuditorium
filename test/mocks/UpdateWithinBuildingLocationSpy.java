package mocks;

import core.Coordinates;

public class UpdateWithinBuildingLocationSpy extends PresenterStub {

    public boolean showUpdatePositionWasCalled = false;
    public Coordinates providedLocation;

    public void showUpdatedInsideLocation(Coordinates insideLocation) {
        showUpdatePositionWasCalled = true;
        providedLocation = insideLocation;
    }
}
