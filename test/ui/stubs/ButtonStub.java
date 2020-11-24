package ui.stubs;

import ui.framework.Button;
import ui.framework.Command;

public class ButtonStub implements Button {
    public String text;
    public Command command;

    public ButtonStub(String name, Command command) {
        this.text = name;
        this.command = command;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
