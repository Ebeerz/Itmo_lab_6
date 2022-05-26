package clientCommands;

import manager.CommandAndArg;

import java.util.Map;

public class Help implements Command{
    @Override
    public String execute(Object o) {
        CommandAndArg.setCommand("help");
        return null;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Справка по коммандам";
    }
}
