package ui.stubs;

import ui.framework.Element;
import ui.framework.MainView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainViewStub implements MainView {
    public List<Element> addedItems = new ArrayList<>();

    public void setMainPanel(int width, int height) {

    }

    public void add(Element elem) {
        addedItems.add(elem);
    }

    public void remove(Element elem) {
        addedItems.remove(elem);
    }
}
