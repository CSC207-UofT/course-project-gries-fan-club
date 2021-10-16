# JChef - Progress Report

## Specification Review

Our project, JChef, is a sophisticated cook book program that allows users to maintain a record of the ingredients in their fridge and pantry to see what they can cook.
Users are able to sort through recipes through filters such as recipes that they can make with food on hand, dietary restrictions, and food by reviews.

## CRC Model Review

We have the following entity classes: `RecipeItem`, `Recipe`, `Ingredient`, and `Tag`.
These store information on our food and recipes.

Then the Use Case Classes are the `FridgeMatcher` and the `TagMatcher` which both extend the `AbstractMatcher` class.
These provide the main behaviour of our program.

For controllers, we have the `IngredientStorage`, `IngredientStorage`, and so on.
The `Loader` classes and `Builder` classes also act as controllers responsible for filling these storages.

## Scenario Walkthrough

The scenario walk through that we’ve created covers a scenario where the program automatically loads all its recipes and ingredients into storages, and then searches for recipes by a certain dietary restriction tag.
This demonstrates our program’s power to find relevant recipes for the user.

## Skeleton Program

The skeleton code present showcases many of the CRC cards implemented while respecting clean architecture principles.
This includes Loaders, Builders, and Storages, capable of turning raw data strings into ingredients and other entities.
These entities themselves are represented as data objects enabling us to query for tags and necessary information.
Finally, we also have a few Matchers that use (currently simple) strategies of searching for requested recipes.

To keep things simple for the purpose of this code staying skeletized, we have included a temporary main function to demonstrate searching of tags on recipes.
For phase 0 we decided to not focus on the implementation details of the user interface and instead create a stronger CRC, plan, and internal functionality.
This is also because we are not currently sure how whether we would like to do a GUI or CLI interface in the end and as such didn't think our time would be well spent working on one.

## Current Struggles

Our group was having a few issues with the organization of the CRC model.
With such a complex project, and the need to adhere to SOLID principles and Uncle Bob’s Clean Architecture, we found ourselves making much more frequent use of Interfaces than in our previous experience.
Gerd, Derek and Ezra had some difficulties with the CRC cards as new models and cards kept being updated, which forced Ezra to keep updating his CRC dependency model, Derek to make new cards, and Gerd to adequately create a good walk through.

Derek and Ariel had a relatively easy time implementing the cards into classes after the plan was finalised.
However, Derek had some difficulty in implementing the Loader class and that functionality was pushed back to Phase 1.
The coders also had some difficulties adhering to the DIP, as the dependency on objects from different levels was high and contracts could have been broken.
Ariel remarked that it was at times confusing when referring to Entities’ interfaces or their implementations.

We found that it was slightly difficult at times to communicate within our group.
Being in a group where so many of the members are incredibly busy makes it difficult for everyone to be on the same page all the time.
We will strive to have meetings more frequently and delegate more precise tasks such that our group members can work more autonomously and without confusion.

## What’s Working Well?

The code base, especially the high-level code is thorough, and will make it easy for us to build lower level classes, especially if we need to pivot while we progress into phase 2.
We have decent unit test coverage as well, as Ariel and Derek programmed with Test Driven Development in mind when possible.
They adhered to Clean Architecture’s core principles and the SOLID principles throughout their programming as well.

Ezra’s CRC dependency model made it easy for Gerd with Prithee and Ayush to make a thorough walkthrough scenario.
Additionally, Gerd made dependency charts in IntelliJ that made it very easy to see class interactions, along with preventing contract violation.

# #Group Members’ Contributions
- Derek 
  - Was working on coding the Loader along with a temporary CLI. Helped create the CRC cards, and organized them into higher and lower levels. Plans on coding the Readers and Loaders.
- Ezra 
  - Created CRC cards and the dependency CRC model. Plans on updating the CRC model as more modes and a GUI is implemented in the future. 
- Ariel
  - Coded the high-level entities along with the Matcher. Provided Test Cases for his code. Will continue to code, potentially work on the aforementioned Tinder functionality. 
- Gerd 
  - Wrote the Progress Report, created the CRC Walkthrough Scenario with Ayush and Prithee. Plans to move into a stronger coding role, where he wants to spearhead the development of the GUI and implement broad functionality, such as shopping carts, multi-item adding to the cart, and the Tinder mode. 
- Ayush
  - Assisted with the CRC Walkthrough. Created thorough commenting and descriptions of the classes and methods. Will focus on implementing the Android app along with its GUI. 
- Prithee
  - Assisted with the CRC Walkthrough. Created thorough commenting and descriptions of the classes and methods. Will focus on implementing the Android app along with its GUI.
