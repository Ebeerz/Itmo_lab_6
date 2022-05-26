package Commands;

import Org.ProductCollection;
import manager.Message;

public class Show implements Command{
    @Override
    public String execute(Object o) {
        Message.setMessage(ProductCollection.getCollection().toString());
        //System.out.println(ProductCollection.getCollection().toString());
        return null;
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "Показать коллекцию";
    }
}
