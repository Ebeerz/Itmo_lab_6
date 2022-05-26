package clientCommands;

import Org.Product;
import Org.ProductCollection;
import manager.CommandAndArg;

import java.util.Iterator;

public class CountGreaterThanManufacturer implements Command{
    @Override
    public String execute(Object arg) {
        CommandAndArg.setCommand("count_greater_than_manufacturer manufacturer");
        CommandAndArg.setArg(arg);
        return null;
    }

    @Override
    public String getName() {
        return "count_greater_than_manufacturer";
    }

    @Override
    public String getDescription() {
        return "Вывести количество элементов, значение поля manufacturer которых больше заданного";
    }
}
