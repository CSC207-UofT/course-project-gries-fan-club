package UseCases;

/**
 * Defines a use case interface
 *
 */
public interface UseCase {
    ResponseImpl run(CommandImpl command);
}

