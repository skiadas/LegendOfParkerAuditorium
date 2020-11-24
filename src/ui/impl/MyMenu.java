package ui.impl;

import ui.framework.*;
import ui.framework.Button;
import ui.framework.Menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class MyMenu extends MyElement implements Menu {
    private JPanel buttonPanel;

    public MyMenu() {
        jComponent = new JPanel();
        jComponent.setOpaque(false);
        jComponent.setLayout(new BoxLayout(jComponent, BoxLayout.PAGE_AXIS));
        JPanel innerPanel = new JPanel();
        innerPanel.setOpaque(false);
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.LINE_AXIS));
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        jComponent.add(Box.createVerticalGlue());
        jComponent.add(innerPanel);
        jComponent.add(Box.createVerticalGlue());
        innerPanel.add(Box.createHorizontalGlue());
        innerPanel.add(buttonPanel);
        innerPanel.add(Box.createHorizontalGlue());
    }

    public void add(Element e) {
        buttonPanel.add(((MyElement) e).getJComponent());
    }

    public void remove(Element e) {
        buttonPanel.remove(((MyElement) e).getJComponent());
    }
}
