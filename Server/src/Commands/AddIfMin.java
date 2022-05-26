package Commands;

import Org.Product;
import Org.ProductCollection;
import manager.Message;


public class AddIfMin implements Command {

    @Override
    public String execute(Object arg) {

        Product product = (Product) arg;

        for (Product productIt : ProductCollection.getCollection()) {
            if (product.compareTo(productIt) >= 0) {
                Message.setMessage("Значение элемента не меньше чем у меньшего элемента в этой коллекции");
                return null;
            }
        }

        ProductCollection.add(product);
        Message.setMessage("Был добавлен продукт");

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
