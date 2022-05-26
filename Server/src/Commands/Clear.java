package Commands;

import Org.ProductCollection;
import manager.Message;

public class Clear implements Command{
    @Override
    public String execute(Object o) {
        ProductCollection.clear();
        Message.setMessage("Коллекция очищена");
        return null;
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "Очищение коллекции";
    }
}
