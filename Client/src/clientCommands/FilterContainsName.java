package clientCommands;

import Org.Product;
import Org.ProductCollection;
import manager.CommandAndArg;

import java.util.Iterator;

public class    FilterContainsName implements Command{
    @Override
    public String execute(Object arg) {
        CommandAndArg.setCommand("filter_contains_name");
        CommandAndArg.setArg(arg);
        return null;
    }

    @Override
    public String getName() {
        return "filter_contains_name";
    }

    @Override
    public String getDescription() {
        return "Вывести элементы, значение поля name которых содержит заданную подстроку";
    }
}
