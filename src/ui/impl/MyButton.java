package ui.impl;

import ui.framework.Button;
import ui.framework.Command;

import javax.swing.*;
import java.awt.*;

class MyButton extends MyElement implements Button {
    private Command command;

    MyButton(String label) {
        JButton button = prepareJButton(label);
        setListener(button);
        this.jComponent = button;
    }

    MyButton(String label, Command command) {
        this(label);
        this.command = command;
    }

    private void setListener(JButton button) {
        button.addActionListener(e -> command.execute());
    }

    private JButton prepareJButton(String label) {
        JButton button = new JButton(label);
        button.setBackground(Color.red);
        button.setForeground(Color.blue);
        button.setFont(new Font("TimesRoman", Font.PLAIN, 60));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    public void setText(String text) {
        ((JButton) getJComponent()).setText(text);
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
