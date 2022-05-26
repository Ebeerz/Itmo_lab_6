package manager;

public class Message {
    private static String message;

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        Message.message = message;
    }
}
