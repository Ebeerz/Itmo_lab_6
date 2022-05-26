package clientCommands;

import Org.Product;
import manager.CommandAndArg;


public class AddIfMin implements Command {

    @Override
    public String execute(Object arg) {
        ProductCreator productCreator = new ProductCreator();
        Product product = productCreator.create((String) arg);
        CommandAndArg.setCommand("add_if_min");
        CommandAndArg.setArg(product);
        return null;
    }

    @Override
    public String getName() {
        return "add_if_min";
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }
}