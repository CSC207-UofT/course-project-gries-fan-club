package UseCases;
import Commands.Command;
import Commands.Implementations.CommandImpl;

import java.util.List;

/**
 * Defines a use case interface
 *
 */
public interface UseCase {
    Response run(CommandImpl command);
}

