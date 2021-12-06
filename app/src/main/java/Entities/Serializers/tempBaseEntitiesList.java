package Entities.Serializers;

import Entities.Implementations.IngredientImpl;
import Entities.Implementations.RecipeImpl;
import Entities.Implementations.RecipeItemImpl;
import Entities.Implementations.TagImpl;
import Entities.Ingredient;
import Entities.ItemDisplays.Mass;
import Entities.ItemDisplays.Quantifiable;
import Entities.ItemDisplays.RecipeItemDisplay;
import Entities.ItemDisplays.Volumetric;
import Entities.Recipe;
import Entities.RecipeItem;
import Entities.Tag;
import Loaders.Row;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class tempBaseEntitiesList {
    //Tags
    Tag dairyTag = new TagImpl("Dairy");
    Tag meatTag = new TagImpl("Meat");
    Tag kosherTag = new TagImpl("Non-Kosher");
    Tag halalTag = new TagImpl("Non-Halal");
    Tag glutenTag = new TagImpl("Gluten");

    TagSerializer ts = new TagSerializer();
    Collection<Row> tagSerialized = ts.serializeAll(List.of(dairyTag, meatTag, kosherTag, halalTag, glutenTag));

    //Ingredients
    Ingredient beef = new IngredientImpl("Beef", Collections.singletonList(meatTag));
    Ingredient salt = new IngredientImpl("Salt");
    Ingredient blackPepper = new IngredientImpl("Black Pepper");
    Ingredient oliveOil = new IngredientImpl("Olive Oil");
    Ingredient italianSeasoning = new IngredientImpl("Italian Seasoning");
    Ingredient garlic = new IngredientImpl("Garlic");
    Ingredient butter = new IngredientImpl("Butter", Collections.singletonList(dairyTag));
    Ingredient eggs = new IngredientImpl("Egg");
    Ingredient cheese = new IngredientImpl("Cheese", Collections.singletonList(dairyTag));
    Ingredient oregano = new IngredientImpl("Oregano");
    Ingredient bread = new IngredientImpl("Bread", Collections.singletonList(glutenTag));
    Ingredient tomato = new IngredientImpl("Tomato");
    Ingredient turkeyBreastSlice = new IngredientImpl("Turkey Breast Slice", Collections.singletonList(meatTag));
    Ingredient cheeseSlice = new IngredientImpl("Cheese Slice", Collections.singletonList(dairyTag));
    Ingredient mayo = new IngredientImpl("Mayo", Collections.singletonList(dairyTag));
    Ingredient lettuce = new IngredientImpl("Lettuce");
    Ingredient bacon = new IngredientImpl("Bacon", List.of(kosherTag, halalTag));
    Ingredient croutons = new IngredientImpl("Croutons", Collections.singletonList(glutenTag));
    Ingredient caesarDressing = new IngredientImpl("Caesar Dressing");
    Ingredient bagel = new IngredientImpl("Bagel", Collections.singletonList(glutenTag));
    Ingredient creamCheese = new IngredientImpl("Cream Cheese", Collections.singletonList(dairyTag));

    IngredientSerializer is = new IngredientSerializer();

    List<Ingredient> ingredients = List.of(beef, salt, blackPepper, oliveOil, italianSeasoning,
            garlic, butter, eggs, cheese, oregano, bread, tomato, turkeyBreastSlice, cheeseSlice, mayo, lettuce,
            bacon, croutons, caesarDressing, bagel, creamCheese);

    Collection<Row> ingredientsSerialized = is.serializeAll(ingredients);


    //RecipeItems
    RecipeItemDisplay m = new Mass();
    RecipeItemDisplay q = new Quantifiable();
    RecipeItemDisplay v = new Volumetric();
    RecipeItem beefForSteak = new RecipeItemImpl(beef, 200, false, m);
    RecipeItem pinchOfSaltForSteak = new RecipeItemImpl(salt, 2, false, q);
    RecipeItem pinchOfBlackPepperForSteak = new RecipeItemImpl(blackPepper, 5, false, q);
    RecipeItem oliveOilForSteak = new RecipeItemImpl(oliveOil, 15, false, v);
    RecipeItem pinchOfItalianSeasoningForSteak = new RecipeItemImpl(italianSeasoning, 2, false, q);
    RecipeItem garlicForSteak = new RecipeItemImpl(garlic, 1, false, q);
    RecipeItem butterForSteak = new RecipeItemImpl(butter, 50, false, q);

    RecipeItem eggsForOmelette = new RecipeItemImpl(eggs, 2, false, q);
    RecipeItem butterForOmelette = new RecipeItemImpl(butter, 20, false, q);
    RecipeItem cheeseForOmelette = new RecipeItemImpl(cheese, 50, true, m);
    RecipeItem saltForOmelette = new RecipeItemImpl(salt, 2, true, q);
    RecipeItem oreganoForOmelette = new RecipeItemImpl(oregano, 2, false, q);

    RecipeItem breadForTurkeyBLT = new RecipeItemImpl(bread, 2, false, q);
    RecipeItem tomatoForTurkeyBLT = new RecipeItemImpl(tomato, 0.5, false, q);
    RecipeItem cheeseSlicesForTurkeyBLT = new RecipeItemImpl(cheeseSlice, 1, true, q);
    RecipeItem mayoForTurkeyBLT = new RecipeItemImpl(mayo, 15, false, v);
    RecipeItem turkeyBreastSliceForTurkeyBLT = new RecipeItemImpl(turkeyBreastSlice, 4, false, q);
    RecipeItem baconForTurkeyBLT = new RecipeItemImpl(bacon, 8, false, q);
    RecipeItem lettuceForTurkeyBLT = new RecipeItemImpl(lettuce, 30, false, m);

    RecipeItem lettuceForCaesarSalad = new RecipeItemImpl(lettuce, 200, false, m);
    RecipeItem croutonsForCaesarSalad = new RecipeItemImpl(croutons, 20, false, m);
    RecipeItem caesarDressingForCaesarSalad = new RecipeItemImpl(caesarDressing, 40, false, v);

    RecipeItem creamCheeseForCreamCheeseBagel = new RecipeItemImpl(creamCheese, 2, false, v);
    RecipeItem bagelForCreamCheeseBagel = new RecipeItemImpl(bagel, 1, false, q);

    List<RecipeItem> recipeItems = List.of(beefForSteak, pinchOfSaltForSteak, pinchOfBlackPepperForSteak,
            oliveOilForSteak, pinchOfItalianSeasoningForSteak, garlicForSteak, butterForSteak, eggsForOmelette,
            butterForOmelette, cheeseForOmelette, saltForOmelette, oreganoForOmelette, breadForTurkeyBLT,
            tomatoForTurkeyBLT, cheeseSlicesForTurkeyBLT, mayoForTurkeyBLT, turkeyBreastSliceForTurkeyBLT,
            baconForTurkeyBLT, lettuceForTurkeyBLT, lettuceForCaesarSalad, croutonsForCaesarSalad,
            caesarDressingForCaesarSalad, creamCheeseForCreamCheeseBagel, bagelForCreamCheeseBagel);

    RecipeItemSerializer ris = new RecipeItemSerializer();
    Collection<Row> recipeItemsSerialized = ris.serializeAll(recipeItems);

    //Instructions
    List<String> steakInstructions = List.of("1. Season steaks with salt and pepper on both sides, and rub them all over with oil.", "2. Heat a grill pan over high heat and cook the steaks until browned on one side, about 2 to 3 minutes.", "3. Flip steaks and cook on the other side until just browned, about 2 to 3 minutes. Don’t overcook, or you'll run the risk of toughening the meat.", "4. Remove steaks to plates to let the meat rest. Turn off the heat and add 2 tablespoons butter to the skillet to melt.", "5. Drizzle the melted butter and juices from the skillet on the steaks.", "Adapted from: https://www.thespruceeats.com/steak-medley-date-night-meal-912501");

    List<String> omeletteInstructions = List.of("1. Crack two eggs into bowl.", "2. Grate cheese into separate bowl.", "3. Add cheese, salt, and pinch of oregano into bowl with eggs.", "3. Throughly beat eggs until uniform.", "4. Pour egg mix into frying pan on medium heat until bottom is light-golden.", "5. Flip omelette and fry until light-golden.");

    List<String> turkeyBLTInstructions = List.of("1. Spread mayo onto one slice of bread", "2. Cut lettuce into thin slices, cut and wash.", "3. Pile the ingredients in the following order: cheese, turkey breast, bacon, lettuce, other slice of bread.");

    List<String> caesarSaladInstructions = List.of("2. Cut lettuce into thin slices, wash, and dry.", "2. Put lettuce into bowl, and add croutons and dressing.", "3. Mix well.");

    List<String> creamCheeseBagelInstructions = List.of("1. Cut bagel into two, and toast to light golden-brown.", "2. Spread cream cheese onto bagel slices.");


    //RecipeItemList
    List<RecipeItem> steakRecipeItems = List.of(beefForSteak, pinchOfSaltForSteak, pinchOfBlackPepperForSteak, oliveOilForSteak, pinchOfItalianSeasoningForSteak, garlicForSteak, butterForSteak);

    List<RecipeItem> omeletteRecipeItems = List.of(eggsForOmelette, butterForOmelette, cheeseForOmelette, saltForOmelette, oreganoForOmelette);

    List<RecipeItem> turkeyBLTRecipeItems = List.of(breadForTurkeyBLT, tomatoForTurkeyBLT, cheeseSlicesForTurkeyBLT, mayoForTurkeyBLT, turkeyBreastSliceForTurkeyBLT, baconForTurkeyBLT, lettuceForTurkeyBLT);

    List<RecipeItem> caesarSaladRecipeItems = List.of(lettuceForCaesarSalad, croutonsForCaesarSalad, caesarDressingForCaesarSalad);

    List<RecipeItem> creamCheeseBagelRecipeItems = List.of(creamCheeseForCreamCheeseBagel, bagelForCreamCheeseBagel);

    //Recipes
    Recipe steak = new RecipeImpl("Steak", "A delicious serving of steak for one.", steakInstructions, steakRecipeItems);

    Recipe omelette = new RecipeImpl("Omelette", "A classic omelette with light seasoning and cheese.", omeletteInstructions, omeletteRecipeItems);

    Recipe turkeyBLT = new RecipeImpl("Turkey BLT", "A classic sandwich that everyone loves", turkeyBLTInstructions, turkeyBLTRecipeItems);

    Recipe caesarSalad = new RecipeImpl("Caesar Salad", "A solid side-salad for any good meal", caesarSaladInstructions, caesarSaladRecipeItems);

    Recipe creamCheeseBagel = new RecipeImpl("Cream Cheese Bagel", "A solid midnight snack", creamCheeseBagelInstructions, creamCheeseBagelRecipeItems);

    List<Recipe> recipes = List.of(steak, omelette, turkeyBLT, caesarSalad, creamCheeseBagel);

    RecipeSerializer recipeS = new RecipeSerializer();

    Collection<Row> recipeSerialized = recipeS.serializeAll(recipes);

}


