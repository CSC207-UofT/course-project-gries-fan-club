package Commands.Implementations;

import Commands.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandImpl implements Command {
    Map<String, String> data = new HashMap<String, String>();

    public CommandImpl(String commandString) {
        if (commandString.contains("Tags")) {
            this.add_tags(commandString);
        }
    }

    public void add_tags(String tagsString) {
        String newString = tagsString;
        // remove the tags keyword and then put the rest inside the data
        newString.replace("Tags", "");
        data.put("Tags", newString);
    }

    public Map<String, String> data() {
        return this.data;
    }

}
