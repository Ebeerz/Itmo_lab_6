package Commands;

import manager.Message;

import java.util.Map;

public class Help implements Command{
    @Override
    public String execute(Object o) {
        Map<String,String> commandDescriptionList = Receiver.getCommandDescriptionList();
        StringBuilder result = new StringBuilder("");
        for(Map.Entry<String, String> pair : commandDescriptionList.entrySet())
        {
            String value = pair.getKey() + " -> " +  pair.getValue();
            result.append("\n").append(value);
        }
        Message.setMessage(result.toString());
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
