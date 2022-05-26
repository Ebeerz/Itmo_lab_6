package Commands;

import Org.Product;
import Org.ProductCollection;
import manager.Message;

public class Add implements Command {
    @Override
    public String execute(Object arg) {
        Product product = (Product) arg;
        Message.setMessage("Был добавлен продукт");
        ProductCollection.add(product);
        //System.out.println("Был добавлен продукт");
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
