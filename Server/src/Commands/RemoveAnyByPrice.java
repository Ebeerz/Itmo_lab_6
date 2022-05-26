package Commands;

import Org.Product;
import Org.ProductCollection;
import manager.Message;

import java.util.Iterator;

public class RemoveAnyByPrice implements Command{
    @Override
    public String execute(Object arg) {

        try {
            if (ProductCollection.getSize() == 0) {
                Message.setMessage("Коллекция пустая.");
                return null;
            }
            else {
                long price = Long.parseLong((String) arg);
                for(Iterator<Product> it = ProductCollection.getCollection().iterator(); it.hasNext();)
                {
                    Product product = it.next();
                    if (product.getPrice() == price){
                        it.remove();
                        Message.setMessage("Был удален продукт с price: "+ price);
                        return null;
                    }

                }
                Message.setMessage("Продукта с price: " + price + " не найдено");
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

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
