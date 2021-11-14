package UseCases;
import Commands.Command;

import java.util.List;

/**
 * Defines a use case interface
 *
 */
public interface UseCase {
    ResponseImpl run(Command command);
}

