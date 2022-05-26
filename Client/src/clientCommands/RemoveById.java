package clientCommands;

import manager.CommandAndArg;

public class RemoveById implements Command{
    @Override
    public String execute(Object arg) {
        CommandAndArg.setCommand("remove_by_id");
        CommandAndArg.setArg(arg);
        return null;
    }


    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getDescription() {
        return "Удаление элемента по заданному id";
    }
}
