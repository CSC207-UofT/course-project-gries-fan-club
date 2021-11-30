package UseCases;

/**
 * Defines a use case interface
 *
 */
public interface UseCase {
    Response run(Command command);
}

