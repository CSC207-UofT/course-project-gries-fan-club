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
 */
public class FrontEnd {
    IngredientStorage ingredientStorage;
    RecipeStorage recipeStorage;
    RecipeItemStorage recipeItemStorage;
    TagStorage tagStorage;

    public FrontEnd() throws Exception {
        this.onLoad();
    }

    public Loader createLoader(String pathGiven) throws Exception {
        Path path = Paths.get(pathGiven);
        String json = readFileAsString(path);
        return new JSONFileIO(json);
    }

    public static String readFileAsString(Path file) throws Exception {
        return new String(Files.readAllBytes(file));
    }

    public void onLoad() throws Exception {
        BuilderController builder = new BuilderController();

        Loader ingredientLoader = this.createLoader("/Users/arielchouminov/Desktop/course-project-gries-fan-club/resources/ingredients.json");
        Loader tagLoader = this.createLoader("/Users/arielchouminov/Desktop/course-project-gries-fan-club/resources/tags.json");
        Loader recipeItemLoader = this.createLoader("/Users/arielchouminov/Desktop/course-project-gries-fan-club/resources/recipeItems.json");
        Loader recipeLoader = this.createLoader("/Users/arielchouminov/Desktop/course-project-gries-fan-club/resources/recipes.json");

        builder.load(tagLoader);
        builder.load(ingredientLoader);
        builder.load(recipeItemLoader);
        builder.load(recipeLoader);

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
