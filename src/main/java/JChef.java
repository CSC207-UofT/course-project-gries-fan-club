import Builders.IngredientBuilder;
import LoaderInterfaces.Loader;
import Loaders.JSONLoader;
import Storages.IngredientStorage;
import Storages.RecipeStorage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class JChef {

    // This is temporary.
    static String ingredientJSONSource = """
[
    {
        \"type\": \"ingredient\",
            \"name\": \"carrot\",
            \"tags\": [
        \"veggie\",
                \"orange\"
    ]
    },
    {
        \"type\": \"ingredient\",
            \"name\": \"apple\",
            \"tags\": [
        \"fruit\",
                \"red\"
    ]
    }
]
""";

    public static void main(String[] args) throws IOException {
        System.out.println("Hello JChef");

        // Please be advised, the code below is TEMPORARY and is written specifically for phase 0.
        // It does not reflect the final structure of our project, or even our current CRC cards.
        // It is just to showcase the features we have implemented as of phase 0.
        //
        // The flow of our programs goes something like this:
        // First, load up our recipes and ingredients.
        Loader ingredientLoader = new JSONLoader(ingredientJSONSource);

        // Then we send them to the builders to fill storages.
        IngredientStorage ingredientStorage = new IngredientStorage();

        IngredientBuilder ingredientBuilder = new IngredientBuilder();
        ingredientBuilder.addTo(ingredientStorage, ingredientLoader);

        RecipeStorage recipeStorage = new RecipeStorage();

        return;
    }

}
