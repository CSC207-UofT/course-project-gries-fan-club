package Controllers;

import Entities.Builders.*;
import Entities.Recipe;
import Entities.Serializers.RecipeSerializer;
import Loaders.Loader;
import Storages.*;
import Storages.Implementations.IngredientStorageImpl;
import Storages.Implementations.RecipeStorageImpl;
import Storages.Implementations.TagStorageImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a loader, we build storages and fill them
 */
public class BuilderController {
    IngredientStorage ingredientStorage;
    RecipeStorage recipeStorage;
    TagStorage tagStorage;
    RecipeItemStorage recipeItemStorage;

    public BuilderController() {
        this.ingredientStorage = new IngredientStorageImpl();
        this.recipeStorage = new RecipeStorageImpl();
        this.tagStorage = new TagStorageImpl();
    }

    /**
     * Takes in the loader and then fills the storages
     * @param loader
     */
    public Map<String, Storage> load(Loader loader) {
        // load all the builders
        TagBuilder tagBuilder = new TagBuilder();
        tagBuilder.addTo(this.tagStorage, loader);

        IngredientBuilder ingredientBuilder = new IngredientBuilder(this.tagStorage);
        ingredientBuilder.addTo(this.ingredientStorage, loader);

        RecipeItemBuilder recipeItemBuilder = new RecipeItemBuilder(this.ingredientStorage);
        recipeItemBuilder.addTo(this.recipeItemStorage, loader);

        RecipeBuilder recipeBuilder = new RecipeBuilder(this.recipeItemStorage);
        recipeBuilder.addTo(this.recipeStorage, loader);

        Map<String, Storage> storages = new HashMap<>();
        storages.put("ingredients", this.ingredientStorage);
        storages.put("recipeItems", this.recipeItemStorage);
        storages.put("tags", this.tagStorage);
        storages.put("recipes", this.recipeStorage);
        return storages;
    }
}
