package manager;

public class CommandAndArg {

    private static String command;
    private static Object arg;


    public static String getCommand() {
        return command;
    }

    public static void setCommand(String command) {
        CommandAndArg.command = command;
    }

    public static Object getArg() {
        return arg;
    }

    public static void setArg(Object arg) {
        CommandAndArg.arg = arg;
    }
}
