package manager;

import java.io.Serializable;

public class MessageToSer implements Serializable {
    private String message;

    public MessageToSer(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageToSer{" +
                "message='" + message + '\'' +
                '}';
    }
}
