package clientCommands;

import manager.CommandAndArg;

public class Exit implements Command{


    @Override
    public String execute(Object o) {
        CommandAndArg.setCommand("exit");
        return null;
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "Завершение работы";
    }
}
