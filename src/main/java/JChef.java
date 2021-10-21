import Builders.IngredientBuilder;
import Entities.TagImpl;
import EntityInterfaces.Ingredient;
import LoaderInterfaces.Loader;
import Loaders.JSONLoader;
import Storages.IngredientStorageImpl;

import java.io.IOException;
import java.util.Collections;

public class JChef {

    // This is temporary.
    static String ingredientJSONSource = "[]";

    public static void main(String[] args) throws IOException {
        System.out.println("Hello JChef");

        // Please be advised, the code below is TEMPORARY and is written specifically for phase 0.
        // It does not reflect the final structure of our project.
        // It is just to showcase the features we have implemented as of phase 0.
        //
        // The flow of our programs goes something like this:
        // First, load up our recipes and ingredients.
        Loader ingredientLoader = new JSONLoader(ingredientJSONSource);

        // Then we send them to the builders to fill storages.
        IngredientStorageImpl ingredientStorage = new IngredientStorageImpl();

        IngredientBuilder ingredientBuilder = new IngredientBuilder();
        ingredientBuilder.addTo(ingredientStorage, ingredientLoader);

        for(Ingredient i : ingredientStorage.ingredients()) {
            System.out.println(i);
        }

        System.out.println();

        for(Ingredient i : ingredientStorage.find(Collections.singletonList(new TagImpl("veggie")))) {
            System.out.println(i);
        }
    }

}
