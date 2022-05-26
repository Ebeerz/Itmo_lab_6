package clientCommands;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public interface Command {

    String execute(Object o) throws ParserConfigurationException, IOException, TransformerException;

    String getName();
    String getDescription();
}
