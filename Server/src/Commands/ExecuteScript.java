package Commands;

import java.io.*;
import java.util.Arrays;

public class ExecuteScript implements Command{
    @Override
    public String execute(Object arg) throws IOException {
        File file = new File((String) arg);
        FileInputStream fileIn = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fileIn);
        int charCode;
        StringBuilder data = new StringBuilder();
        while ((charCode = isr.read()) != -1) { // Read each character.
            data.append((char) charCode);
        }
        isr.close();

        Receiver receiver = new Receiver();
        String str = data.toString();
        String[] mass = str.split("\\s");
        System.out.println(Arrays.toString(mass));
        for (String i : mass){

            //System.out.println(i + " a");
            receiver.runCommand(i, arg);
        }
        return null;
    }

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "Считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
