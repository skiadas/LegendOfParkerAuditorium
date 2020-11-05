package mocks;

import core.BuildingView;

public class BuildingSelectPresenterSpy extends PresenterStub{
    public boolean showChoiceOfBuilding = false;
    public BuildingView chosenBuilding;

    public void showChoiceOfBuilding(BuildingView chosenBuilding){
        showChoiceOfBuilding = true;
        this.chosenBuilding = chosenBuilding;
    }
}
