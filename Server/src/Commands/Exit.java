package Commands;

import manager.Message;

public class Exit implements Command{


    @Override
    public String execute(Object o) {
        Message.setMessage("Выход из приложения...");
        //System.exit(0);
        return null;
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "Завершение работы";
    }
}
