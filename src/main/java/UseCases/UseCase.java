package UseCases;
import Commands.Command;

/**
 * Defines a use case interface
 *
 */
public interface UseCase {
    Response run(Command command);
}

