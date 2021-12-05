###### **Specifications**

_On start-up the user is prompted with a menu containing:_
(each sublist describes the presentation of the following prompts)
* Go to fridge

    * List fridge contents
    * Add  ingredients
    * Go back a menu page

* Go to cookbook
    * List  recipes
        * Based on the ingredient in the fridge
        * By tags
    * Go to recipe to cook
        * Shows ingredients
            * Add ingredients to Grocery list
    * Go back a menu page
* Go to grocery list
    * List of ingredients to buy
    * Add to Grocery list
    * Add to Fridge
    * Go back a menu page

The fridge is a list of ingredients that the user can access to. Go to fridge brings up a menu with the following actions:
* List fridge contents displays a list of all the ingredients currently in your fridge.
* Add / remove ingredients followed by an ingredient(s), will add or remove that ingredient from your fridge. Subsequently, running the list fridge contents would then display the new recipeItem.

The Go-to recipes button brings up a page containing a gallery of recipes. You can see all the recipes that can be made with all or some of the ingredients in your fridge. Each command is as follows:
* Find recipes is one of the main functions of the program. This command with options such as tags to match or recipes you can currently make will return a list of recipes sorted by relevance to your query.
* List recipes displays all available recipes.
* Choose recipe marks a recipe as one you want to make later on and adds any ingredients you do not have to your shopping list. There should also be the option to scale the recipe. This will increase / decrease the portions of different ingredients before adding it to your list.

Go to grocery list will give you the following commands:
* List recipeItems gives you a list of all ingredients you currently need to buy. This is aggregated from the recipes you have marked as wanting to make.
* “Add all to Fridge”  this imports all recipeItems from the grocery list into the fridge and empties the grocery list.
* “Add to Fridge”  this imports a single  recipeItems from the grocery list into the fridge and removes it from the grocery list.

Finally, the Go back command will simply bring you out of the current submenu, or do nothing if you are already at the main menu.

When the app is closed the data will be saved and serialized.
