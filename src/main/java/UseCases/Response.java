package UseCases;

import Entities.Recipe;

import java.util.List;

// Mock Response interface for use case purpose
public interface Response {
    void addValues();
    List<Recipe> returnRecipes();
}
