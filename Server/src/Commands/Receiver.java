package Commands;

import manager.Message;

import java.util.HashMap;
import java.util.Map;

public class Receiver {

    private static final Map<String, Command> commandList = new HashMap<>();
    private static final Map<String, String> commandDescriptionList = new HashMap<>();


    public static Map<String, String> getCommandDescriptionList() {
        return commandDescriptionList;
    }

    public void regist(Command... commands) {
        for (Command command : commands) {
            Receiver.commandList.put(command.getName(), command);
            Receiver.commandDescriptionList.put(command.getName(), command.getDescription());
        }
    }


    public void runCommand(String command, Object arg) {
        String[] nameStr = command.split(" ");
        String name = nameStr[0];
        if (commandList.get(name) == null) {
            Message.setMessage("Такой команды не существует");
        }
        else if (nameStr.length > 3){
            Message.setMessage("Неверный формат ввода");
        }
        else {
            try{
                commandList.get(name).execute(arg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


}


