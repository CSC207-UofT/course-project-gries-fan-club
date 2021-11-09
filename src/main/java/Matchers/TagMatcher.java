package Matchers;
import Entities.Entity;
import Entities.Recipe;
import Storages.Implementations.RecipeStorageImpl;

// Matches ingredients with recipes
public interface TagMatcher<T extends Entity> {
    /** Returns whether or not the specified entity contains all of the tags.
     *
     * @param entity
     * @return whether or not the entity has all the tags..
     */
    boolean binaryMatch(T entity);

    /** Returns a decimal percentage of how many of the tags a certain entity has.
     *
     * @param entity
     * @return a decimal percentage of the tags that an entity has.
     */
    double floatMatch(T entity);
}
