package ui.impl;

import ui.ImageManager;
import ui.framework.Element;
import ui.framework.MainView;

import javax.swing.*;
import java.awt.*;

// This class represents essentially a whole application's window (via JFrame)
class MyMainView extends JFrame implements MainView {
    private JPanel mainPane;

    public MyMainView(String title, int width, int height) {
        super(title);
        setCrossPlatformLookAndFeel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMainPanel(width, height);
        setVisible(true);
        pack();
    }

    public void add(Element elem) {
        JComponent jComponent = ((MyElement) elem).getJComponent();
        getJComponent().add(jComponent);
        repaint();
        pack();
    }

    public void remove(Element elem) {
        MyElement elem1 = (MyElement) elem;
        JComponent jComponent = elem1.getJComponent();
        getJComponent().remove(jComponent);
        repaint();
        pack();
    }

    public JComponent getJComponent() {
        return mainPane;
    }

    public void setCrossPlatformLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Sets this jpanel instance to act as the content pane
    public void setMainPanel(int width, int height) {
        mainPane = new JPanel(new BorderLayout()) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int x = (this.getWidth() - new ImageManager().getImage("parker").getWidth(null)) / 2;
                int y = (this.getHeight() - new ImageManager().getImage("parker").getHeight(null)) / 2;
                g2d.drawImage(new ImageManager().getImage("parker"), x, y, null);
            }

        };
        mainPane.setPreferredSize(new Dimension(width, height));
        mainPane.setVisible(true);
        setContentPane(mainPane);
    }

    // TODO: Use Jlabel for images and text
}
