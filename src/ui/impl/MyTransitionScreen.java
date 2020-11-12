package ui.impl;

import ui.framework.Button;
import ui.framework.Command;
import ui.framework.TransitionScreen;
import ui.framework.UIFactory;

import javax.swing.*;
import java.awt.*;

public class MyTransitionScreen extends MyElement implements TransitionScreen {
    private final MyButton okButton;

    public MyTransitionScreen(String message) {
        jComponent = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea(message);
        textArea.setEditable(false);

        jComponent.add(textArea, BorderLayout.CENTER);
        jComponent.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        okButton = (MyButton) UIFactory.getInstance().createButton("Continue", null);
        jComponent.add(okButton.getJComponent(), BorderLayout.PAGE_END);
    }

    public void onClose(Command command) {
        okButton.setCommand(command);
    }
}
