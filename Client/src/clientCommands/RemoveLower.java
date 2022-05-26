package clientCommands;

import Org.Product;
import Org.ProductCollection;
import manager.CommandAndArg;

import java.util.Iterator;

public class RemoveLower implements Command {

    @Override
    public String execute(Object arg) {
        ProductCreator productCreator = new ProductCreator();
        Product product = productCreator.create((String) arg);

        CommandAndArg.setCommand("remove_lower");
        CommandAndArg.setArg(product);

        return null;
    }

    @Override
    public String getName() {
        return "remove_lower";
    }

    @Override
    public String getDescription() {
        return "удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
