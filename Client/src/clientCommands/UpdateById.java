package clientCommands;

import manager.CommandAndArg;

public class UpdateById implements Command{
    @Override
    public String execute(Object arg) {
        CommandAndArg.setCommand("update_by_id");
        CommandAndArg.setArg(arg);
        return null;
    }

    @Override
    public String getName() {
        return "update_by_id";
    }

    @Override
    public String getDescription() {
        return "Обновить элемент по заданному id";
    }
}
