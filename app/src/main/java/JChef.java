import Entities.RecipeItem;
import Storages.Implementations.IngredientStorageImpl;
import Storages.Implementations.RecipeItemStorageImpl;
import Storages.Implementations.RecipeStorageImpl;
import Storages.Implementations.TagStorageImpl;
import Storages.IngredientStorage;
import Storages.RecipeStorage;
import Storages.Storage;
import Storages.TagStorage;

public class JChef {

    IngredientStorage ingredients = new IngredientStorageImpl();
    RecipeStorage recipes = new RecipeStorageImpl();
    TagStorage tags = new TagStorageImpl();
    Storage<RecipeItem> items = new RecipeItemStorageImpl();

    public JChef() {

        this.onLoad();

    }

    public void onLoad() {

    }

}
