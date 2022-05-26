package clientCommands;

import Org.ProductCollection;
import manager.CommandAndArg;

public class Info implements Command{
    @Override
    public String execute(Object o) {
        CommandAndArg.setCommand("info");
        //System.out.println("Тип коллекции: " + ProductCollection.getType() + " дата инициализации: " + ProductCollection.getTime() + " количество элементов: " + ProductCollection.getSize());
        return null;
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "Вывести информацию о коллекции";
    }
}

