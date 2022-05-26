package Commands;

import Org.Product;
import Org.ProductCollection;
import manager.Message;

import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FilterContainsName implements Command{
    @Override
    public String execute(Object arg) {
        try {
            StringBuilder result = new StringBuilder("");
            if (ProductCollection.getSize() == 0) {
                Message.setMessage("Коллекция пустая.");
                return null;
            }
            else {

                result.append(ProductCollection.getCollection().stream()
                        .filter(product -> product.getName().equals(arg)));
                /*
                for (Product product : ProductCollection.getCollection()) {
                    if (product.getName().contains((String) arg)) {
                        result.append("\n").append(product.toString());
                        return null;
                    }
                }
                */
                Message.setMessage("Выведены элементы значение поля name которых содержит подстроку " + arg+"\n"+result);
                return null;


            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getName() {
        return "filter_contains_name";
    }

    @Override
    public String getDescription() {
        return "Вывести элементы, значение поля name которых содержит заданную подстроку";
    }
}
