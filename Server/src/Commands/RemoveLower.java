package Commands;

import Org.Product;
import Org.ProductCollection;
import manager.Message;

import java.util.Iterator;

public class RemoveLower implements Command {

    @Override
    public String execute(Object arg) {
        ProductCreator productCreator = new ProductCreator();

        Product product = productCreator.create((String) arg);
        int count = 0;

        for(Iterator<Product> it = ProductCollection.getCollection().iterator(); it.hasNext();)
        {
            Product productIt = it.next();
            if (product.compareTo(productIt) >= 0) {
                it.remove();
                Message.setMessage("Был удален элемент");
                count++;
            }
        }
        if (count == 0) Message.setMessage("Не обнаружено элементов меньших чем созданный");
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
