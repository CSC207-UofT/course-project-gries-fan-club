# JChef - CRC Scenario Walkthrough

The user will enter the console, and be greeted by the home screen.
Behind the scenes, JChef will create `Loaders` pointed at the source data for ingredients and recipes.
These loaders, alongside `Storages`, are given to ingredient and recipe `Builders` which create entities to fill up their given storage.

Now in the recipe search section, the user can type in a tag for the food, such as ‘gluten-free’.
This will have a `TagMatcher` created.
For each tag that was specified by the user, matcher will find recipes and ingredients that contain the given tags and return them back.
This output will then be rendered and presented back to the user.
