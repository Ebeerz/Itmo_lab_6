package Commands;

public class ParserException extends Exception {
    public ParserException(String message, Object o) {
        super(message + String.valueOf(o));
    }
}
