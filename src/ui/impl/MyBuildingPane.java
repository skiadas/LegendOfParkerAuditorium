package ui.impl;

import core.action.ActionFactory;
import core.boundary.ActionRouter;
import core.boundary.BuildingView;
import core.boundary.Coordinates;
import core.boundary.UserAction;
import core.game.Direction;
import ui.ImageManager;
import ui.framework.BuildingPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyBuildingPane extends MyElement implements BuildingPane, MouseListener {
    private BuildingView buildingView;
    private JPanel innerPanel;
    private Image doorImage = new ImageManager().getImage("door");
    private Image playerImage = new ImageManager().getImage("player");
    private Coordinates playerLocation = null;
    private ActionRouter actionRouter;

    public MyBuildingPane(BuildingView buildingView) {
        this.buildingView = buildingView;
        jComponent = prepareJPanel();
    }

    public JPanel prepareJPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setOpaque(false);
        GridBagLayout layout = new GridBagLayout();
        jPanel.setLayout(layout);
        innerPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                paintInPanel(g);
            }
        };
        innerPanel.setPreferredSize(new Dimension(getWidth(), getHeight()));
        innerPanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        jPanel.add(innerPanel);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        layout.setConstraints(innerPanel, c);
        innerPanel.setBackground(Color.lightGray);
        innerPanel.addMouseListener(this);
        return jPanel;
    }

    private void paintInPanel(Graphics g) {
        paintDoor(g);
        if (playerLocation != null) {
            paintPlayerLocation(g);
        }
    }

    private void paintPlayerLocation(Graphics g) {
        int x = getRelativeX(playerLocation.xValue);
        int y = getRelativeY(playerLocation.yValue);
        g.drawImage(playerImage, x, y, null);
    }

    private void paintDoor(Graphics g) {
        int x = getRelativeX(buildingView.getEntranceCoordinates().xValue);
        int y = getRelativeY(buildingView.getEntranceCoordinates().yValue);
        g.drawImage(doorImage, x, y, null);
    }

    private int getRelativeY(int yValue) {
        return (yValue - buildingView.getLowerRight().yValue) * 10;
    }

    private int getRelativeX(int xValue) {
        return (xValue - buildingView.getUpperLeft().xValue) * 10;
    }

    private int getHeight() {
        return 10 * (buildingView.getUpperLeft().yValue - buildingView.getLowerRight().yValue);
    }

    private int getWidth() {
        return 10 * (buildingView.getLowerRight().xValue - buildingView.getUpperLeft().xValue);
    }

    public void updateLocation(Coordinates location) {
        playerLocation = location;
        innerPanel.repaint();
    }

    public void setRouter(ActionRouter actionRouter) {
        this.actionRouter = actionRouter;
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        int x = mouseEvent.getX() / 10 - buildingView.getLowerRight().xValue;
        int y = mouseEvent.getY() / 10 - buildingView.getUpperLeft().yValue;
        System.out.println(String.format("%d, %d, %d, %d", x, y, playerLocation.xValue, playerLocation.yValue));
        performMoveAction(x, y, playerLocation.xValue, playerLocation.yValue);
    }

    private void performMoveAction(int x, int y, int px, int py) {
        if (x > px) { actionRouter.perform(ActionFactory.moveRight()); }
        else if (x < px) { actionRouter.perform(ActionFactory.moveLeft()); }
        else if (y > py) { actionRouter.perform(ActionFactory.moveUp()); }
        else if (y < py) { actionRouter.perform(ActionFactory.moveDown()); }
        // TODO: Up/Down logic is backwards?
    }

    public void mousePressed(MouseEvent mouseEvent) { }

    public void mouseReleased(MouseEvent mouseEvent) {

    }

    public void mouseEntered(MouseEvent mouseEvent) {

    }

    public void mouseExited(MouseEvent mouseEvent) {

    }
}
