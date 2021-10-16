# JChef Specification

On start-up the user is prompted with a menu containing:
- Go to fridge
    - List fridge contents
    - Add / remove ingredients
- Go to cookbook
    - Find recipes
        - Based on relevance to fridge
        - By name
        - By tags
    - List recipes
    - Choose recipe to cook
- Go to grocery list
    - List of recipeItems to buy
    - Import recipeItems
- Go back a menu page
- Exit

The fridge is a list of ingredients that you currently have access to.
**Go to fridge** brings up a menu with the following commands:

- **List fridge contents** displays a list of all the ingredients currently in your fridge.
- **Add / remove ingredient** followed by an ingredient(s), will add or remove that ingredient from your fridge.
  Subsequently, running the list fridge contents would then display the new recipeItem.

The **Go to cookbook** command brings up a page containing a gallery of recipes.
You can see all the recipes that can be made with all or some of the ingredients in your fridge.
Each command is as follows:

- **Find recipes** is one of the main functions of the program. 
  This command with options such as tags to match or recipes you can currently make will return a list of recipes sorted by relevance to your query.
- **List recipes** displays all available recipes.
- **Choose recipe** marks a recipe as one you want to make later on and adds any ingredients you do not have to your shopping list.
  There should also be the option to scale the recipe.
  This will increase / decrease the portions of different ingredients before adding it to your list.

**Go to grocery list** will give you the following commands:

- **List recipeItems** gives you a list of all ingredients you currently need to buy. 
  This is aggregated from the recipes you have marked as wanting to make.
- **Import recipeItems** imports the recipeItems in the grocery list into the fridge and empties the grocery list.

Finally, the **Go back** command will simply bring you out of the current submenu, or do nothing if you are already at the main menu.
The **Exit** command will be used to stop the program and save any persistent data.

Potential next steps:
- Rate recipes
