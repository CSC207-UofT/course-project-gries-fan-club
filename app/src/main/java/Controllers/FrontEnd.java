package Controllers;

import Loaders.Implementations.JSONFileIO;
import Loaders.Loader;
import Storages.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Given a base list of entities, create a loader for it
 */
public class FrontEnd {
    IngredientStorage ingredientStorage;
    RecipeStorage recipeStorage;
    RecipeItemStorage recipeItemStorage;
    TagStorage tagStorage;

    public FrontEnd() throws Exception {
        this.onLoad();
    }
    public Loader createLoader() throws Exception {
        // Read file and pass to JSONFileIO

//        Path currentWorkingDir = Paths.get("").toAbsolutePath();
        Path path = Paths.get("/Users/arielchouminov/Desktop/course-project-gries-fan-club/resources/ingredients.json");
        String json = readFileAsString(path);
        return new JSONFileIO(json);
    }

    public static String readFileAsString(Path file) throws Exception {
        return new String(Files.readAllBytes(file));
    }

    public void onLoad() throws Exception {
        BuilderController builder = new BuilderController();
        Loader loader = this.createLoader();

        builder.load(loader);
        this.ingredientStorage = (IngredientStorage) builder.storages().get("ingredients");
        this.recipeStorage = (RecipeStorage) builder.storages().get("recipes");
        this.recipeItemStorage = (RecipeItemStorage) builder.storages().get("recipeItems");
        this.tagStorage = (TagStorage) builder.storages().get("tags");
    }

    public IngredientStorage ingredientStorage() {
        return ingredientStorage;
    }
}


