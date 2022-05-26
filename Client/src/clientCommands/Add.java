package clientCommands;

import Org.Product;
import Org.ProductCollection;
import manager.CommandAndArg;

public class Add implements Command {
    @Override
    public String execute(Object arg) {
        ProductCreator productCreator = new ProductCreator();
        Product product = productCreator.create((String) arg);
        if (product != null){
            CommandAndArg.setCommand("add");
            CommandAndArg.setArg(product);
            return null;
        }
        CommandAndArg.setCommand("");
        return null;
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "добавление объекта";
    }
}
