package Controllers;

import Entities.Builders.*;
import Entities.Implementations.*;
import Entities.Recipe;
import Entities.RecipeItem;
import Entities.Serializers.RecipeSerializer;
import Loaders.Loader;
import Storages.*;
import Storages.Implementations.IngredientStorageImpl;
import Storages.Implementations.RecipeItemStorageImpl;
import Storages.Implementations.RecipeStorageImpl;
import Storages.Implementations.TagStorageImpl;

import java.util.*;

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
        this.recipeItemStorage = new RecipeItemStorageImpl();
        this.recipeStorage = new RecipeStorageImpl();
        this.tagStorage = new TagStorageImpl();
    }

    /**
     * Takes in the loader and then fills the storages
     * @param loader
     */
    public Map<String, Storage> load(Loader loader) {
//      load all the builders and try them all
        IngredientBuilder ingredientBuilder = new IngredientBuilder(this.tagStorage);
        ingredientBuilder.addTo(this.ingredientStorage, loader);

        TagBuilder tagBuilder = new TagBuilder();
        tagBuilder.addTo(this.tagStorage, loader);

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

    /**
     * Returns a hashmap containing all of the storages
     * .get('ingredients') => ingredient storage
     * .get('recipeItems') => recipe item storage
     * .get('tags') => tag storage
     * .get('recipes') => recipes storage
     * @return
     */
    public Map<String, Storage> storages() {
        Map<String, Storage> storages = new HashMap<>();
        storages.put("ingredients", this.ingredientStorage);
        storages.put("recipeItems", this.recipeItemStorage);
        storages.put("tags", this.tagStorage);
        storages.put("recipes", this.recipeStorage);
        return storages;
    }

}
