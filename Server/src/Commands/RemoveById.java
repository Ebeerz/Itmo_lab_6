package Commands;

import Org.ProductCollection;
import manager.Message;

import java.util.Objects;

public class RemoveById implements Command{
    @Override
    public String execute(Object arg) {
        try {
            if (ProductCollection.getSize() == 0) {
                Message.setMessage("Коллекция пустая.");
            }
            else {
                Long id = Long.parseLong((String) arg);
                ProductCollection.getCollection().removeIf(product -> Objects.equals(product.getId(), id));
                Message.setMessage("Был удален продукт с id: "+ id);
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getDescription() {
        return "Удаление элемента по заданному id";
    }
}
