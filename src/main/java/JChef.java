import Entities.Implementations.TagImpl;
import Entities.Ingredient;
import Loaders.Implementations.JSONLoader;
import Loaders.Loader;
import Storages.Implementations.IngredientStorageImpl;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collections;

public class JChef {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello JChef");

        // Please be advised, the code below is TEMPORARY and is written specifically for phase 0.
        // It does not reflect the final structure of our project.
        // It is just to showcase the features we have implemented as of phase 0.
        //
        // The flow of our programs goes something like this:
        // First, load up our recipes and ingredients.
        Loader ingredientLoader = new JSONLoader(Paths.get("resources/Ingredients.json"));

        // Then we send them to the builders to fill storages.
        IngredientStorageImpl ingredientStorage = new IngredientStorageImpl();

        // We are out growing out example.
        // IngredientBuilder ingredientBuilder = new IngredientBuilder();
        // ingredientBuilder.addTo(ingredientStorage, ingredientLoader);

        for(Ingredient i : ingredientStorage.ingredients()) {
            System.out.println(i);
        }

        System.out.println();

        TagImpl tag = new TagImpl("veggie");
        for(Ingredient i : ingredientStorage.findByTags(Collections.singletonList(tag))) {
            System.out.println(i);
        }
    }

}
