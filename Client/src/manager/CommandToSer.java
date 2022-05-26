package manager;

import java.io.Serial;
import java.io.Serializable;

public class CommandToSer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String command;
    private Object arg;

    public CommandToSer(String command, Object arg) {
        this.command = command;
        this.arg = arg;
    }


    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Object getArg() {
        return arg;
    }

    public void setArg(Object arg) {
        this.arg = arg;
    }

    @Override
    public String toString() {
        return "CommandAndArg{" +
                "command='" + command + '\'' +
                ", arg=" + arg +
                '}';
    }
}
