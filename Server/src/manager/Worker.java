package manager;

import Commands.*;

import java.io.IOException;

public class Worker {

    public byte[] work(String command, Object arg) throws IOException {
        Receiver receiver = new Receiver();
        receiver.regist();
        receiver.regist(new Exit(), new Info(), new Show(), new Add(), new RemoveById(), new Clear(), /*new UpdateById(),*/ new RemoveAnyByPrice(), new Help(),
                new FilterContainsName(), new Save(), /*new ExecuteScript(),*/ new CountGreaterThanManufacturer(), new AddIfMin(), new RemoveLower());
        receiver.runCommand(command, arg);
        //CommandAndArg commandAndArg = new CommandAndArg(CommandToSer.getCommand(),CommandToSer.getArg());
        MessageToSer messageToSer = new MessageToSer(Message.getMessage());
        System.out.println(messageToSer);
        return Serializator.serialization(messageToSer);

    }
}
