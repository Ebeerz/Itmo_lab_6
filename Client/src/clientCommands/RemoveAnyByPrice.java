package clientCommands;

import Org.Product;
import Org.ProductCollection;
import manager.CommandAndArg;

import java.util.Iterator;

public class RemoveAnyByPrice implements Command{
    @Override
    public String execute(Object arg) {
        CommandAndArg.setCommand("remove_any_by_price");
        CommandAndArg.setArg(arg);
        return null;
    }

    @Override
    public String getName() {
        return "remove_any_by_price";
    }

    @Override
    public String getDescription() {
        return "Удаление одного объекта с заданным полем price";
    }
}
