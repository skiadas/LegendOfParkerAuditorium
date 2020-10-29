package mocks;

import core.WithinBuildingLocation;

public class UpdateWithinBuildingLocationSpy extends PresenterStub {

    public boolean showUpdatePositionWasCalled = false;
    public WithinBuildingLocation providedLocation;

    public void showUpdatedInsideLocation(WithinBuildingLocation insideLocation) {
        showUpdatePositionWasCalled = true;
        providedLocation = insideLocation;
    }
}
