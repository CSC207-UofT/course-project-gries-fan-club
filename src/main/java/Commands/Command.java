package Commands;

import java.util.List;

public interface Command {
    /**
     * Returns a list of arguments based on the arguments in the command
     * @return List of arguments
     */
    List<String> arguments();
}
