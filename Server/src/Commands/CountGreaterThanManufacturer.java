package Commands;

import Org.Product;
import Org.ProductCollection;
import manager.Message;

import java.util.Iterator;

public class CountGreaterThanManufacturer implements Command{
    @Override
    public String execute(Object arg) {
        int count = 0;

        for (Product productIt : ProductCollection.getCollection()) {
            if (productIt.getManufacturer().getId() > Integer.parseInt(arg.toString())) {
                count += 1;
            }
        }

        Message.setMessage("количество элементов, значение поля manufacturer которых больше заданного: " + count);
        return null;
    }

    @Override
    public String getName() {
        return "count_greater_than_manufacturer";
    }

    @Override
    public String getDescription() {
        return "Вывести количество элементов, значение поля manufacturer которых больше заданного";
    }
}
