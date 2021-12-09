package Controllers;

import Loaders.Implementations.JSONFileIO;
import Loaders.Loader;
import Storages.IngredientStorage;
import Storages.RecipeItemStorage;
import Storages.RecipeStorage;
import Storages.TagStorage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Do front end tasks and call the controllers needed
 * This class interacts directly with the UI
 *
 * HOW TO USE:
 * To load:
 *  - provide constructors with
 * To access the storages:
 *  - frontEndObject.ingredientStorage() for ingredients
 *  - frontEndObject.recipeStorage() for recipes
 *  - frontEndObject.recipeItemStorage() for recipeItems
 *  - frontEndObject.tagStorage() for tags
 */
public class FrontEnd {
    IngredientStorage ingredientStorage;
    RecipeStorage recipeStorage;
    RecipeItemStorage recipeItemStorage;
    TagStorage tagStorage;

    public FrontEnd(String ingredientPath, String tagPath,  String recipeItemPath, String recipePath) throws Exception {
        // Build and fill the storages
        this.onLoad(ingredientPath, tagPath, recipeItemPath, recipePath);
    }

    /**
     * Read the File Path
     * @param pathGiven
     * @return
     * @throws Exception
     */
    public Loader createLoader(String pathGiven) throws Exception {
        Path path = Paths.get(pathGiven);
        String json = new String(Files.readAllBytes(path));
        return new JSONFileIO(json);
    }

    /**
     *
     * Takes in all of the paths needed to load
     */
    public void onLoad(String ingredientPath, String tagPath,  String recipeItemPath, String recipePath) throws Exception {
        BuilderController builder = new BuilderController();

        // create loaders
        Loader ingredientLoader = this.createLoader(ingredientPath);
        Loader tagLoader = this.createLoader(tagPath);
        Loader recipeItemLoader = this.createLoader(recipeItemPath);
        Loader recipeLoader = this.createLoader(recipePath);

        // load loaders
        builder.load(tagLoader);
        builder.load(ingredientLoader);
        builder.load(recipeItemLoader);
        builder.load(recipeLoader);

        // populate storages for frontend
        this.ingredientStorage = (IngredientStorage) builder.storages().get("ingredients");
        this.recipeStorage = (RecipeStorage) builder.storages().get("recipes");
        this.recipeItemStorage = (RecipeItemStorage) builder.storages().get("recipeItems");
        this.tagStorage = (TagStorage) builder.storages().get("tags");
    }

    public IngredientStorage ingredientStorage() {
        return this.ingredientStorage;
    }

    public RecipeStorage recipeStorage() {
        return this.recipeStorage;
    }

    public RecipeItemStorage recipeItemStorage() {
        return this.recipeItemStorage;
    }

    public TagStorage tagStorage() {
        return this.tagStorage;
    }

}
