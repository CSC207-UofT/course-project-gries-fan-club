package UseCases;

import java.util.List;
import java.util.Map;

public interface Response extends Map<String, List<String>> {
    /**
     * Return whether the response is a success
     * @return a boolean representing if it was a success
     */
    boolean success();

    /**
     * Return the status of the response
     * @return String containing error code
     */
    String status();
}
