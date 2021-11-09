package UseCases;

import Storages.Exceptions.NoSuchEntity;

import java.util.List;

/**
 * Defines a use case
 *
 */
public interface UseCase {
    /**
     *
     * @return List containing the matched recipes
     */
     List<String> result();
}
