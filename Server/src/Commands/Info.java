package Commands;

import Org.ProductCollection;
import manager.Message;

public class Info implements Command{
    @Override
    public String execute(Object o) {
        Message.setMessage("Тип коллекции: " + ProductCollection.getType() + " дата инициализации: " + ProductCollection.getTime() + " количество элементов: " + ProductCollection.getSize());
        //System.out.println("Тип коллекции: " + ProductCollection.getType() + " дата инициализации: " + ProductCollection.getTime() + " количество элементов: " + ProductCollection.getSize());
        return null;
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "Вывести информацию о коллекции";
    }
}

