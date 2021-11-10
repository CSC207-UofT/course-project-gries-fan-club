package Matchers;
import Entities.Entity;
import Entities.Recipe;
import Storages.Implementations.RecipeStorageImpl;

import java.util.List;

// Matches ingredients with recipes
public interface Matcher<T extends Entity> {
    /** Returns whether or not the specified entity contains all of the tags.
     *
     * @param entity
     * @return whether or not the entity has all the tags..
     */
    boolean matches(T entity);

    double floatMatch(T entity);

    List<T>  allMatches(List<T> entity);
}
