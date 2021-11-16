package UseCases;
import Commands.Implementations.CommandImpl;

/**
 * Defines a use case interface
 *
 */
public interface UseCase {
    Response run(CommandImpl command);
}

