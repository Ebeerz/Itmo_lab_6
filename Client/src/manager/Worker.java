package manager;

import clientCommands.*;

import java.io.IOException;


public class Worker {
    public byte[] work(String command) throws IOException {
        Receiver receiver = new Receiver();
        receiver.regist();
        receiver.regist(new Exit(), new Info(), new Show(), new Add(), new RemoveById(), new Clear(), new UpdateById(), new RemoveAnyByPrice(), new Help(),
                new FilterContainsName(), new ExecuteScript(), new CountGreaterThanManufacturer(), new AddIfMin(), new RemoveLower());
        receiver.runCommand(command + " a");
        CommandToSer commandAndArg = new CommandToSer(CommandAndArg.getCommand(), CommandAndArg.getArg());
        if (CommandAndArg.getCommand().equals("")){return null;}

        return Serializator.serialization(commandAndArg);

    }
}
