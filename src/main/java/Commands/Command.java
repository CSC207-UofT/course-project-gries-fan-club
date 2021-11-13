package Commands;

import java.util.Map;

public interface Command {
    /**
     * Takes in a string and updates the "Tags" key in the data to the value of the rest of the string
     * @param tagsString string in the format "Tags Tag1, Tag2, Tag3"
     */
    void add_tags(String tagsString);
}
