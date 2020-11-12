package ui.framework;

public class NamedCommand {
    public final String name;
    public final Command command;

    public NamedCommand(String name, Command command) {
        this.name = name;
        this.command = command;
    }
}
