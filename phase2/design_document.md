# JChef Phase 2 Write Up

## Contents

* [Introduction](#introduction)
* [Specifications](#specifications)
* [How To Use](#how-to-use)
* [Class Diagram](#class-diagram)
* [Major Design Decisions](#major-design-decisions)
* [SOLID Design Principles](#SOLID-design-principles)
* [Clean Architecture](#clean-architecture)
* [Our Use of GitHub Features](#our-use-of-github-features)
* [Packaging Strategies](#packaging-strategies)
* [Design Patterns](#design-patterns)
* [Refactoring](#refactoring)
* [Progress report](#progress-report)

## Introduction
JChef is a comprehensive full stack application that serves as a portable, interactive cookbook and shopping list. In the second phase of our development we were able to link our backend code to a user interface allowing for users to enjoy a convenient Android application that improves efficiency in the kitchen and in the store.

## Specifications
We met our aims from the 1st phase of the applications' development. We were able to unify our grocery list and fridge command. We added commands that improve the users accessibility and are more efficient.

On start-up the user is prompted with a menu containing:

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
  
The Go to recipes button brings up a page containing a gallery of recipes. You can see all the recipes that can be made with all or some of the ingredients in your fridge. Each command is as follows:
  * Find recipes is one of the main functions of the program. This command with options such as tags to match or recipes you can currently make will return a list of recipes sorted by relevance to your query.
  * List recipes displays all available recipes.
  * Choose recipe marks a recipe as one you want to make later on and adds any ingredients you do not have to your shopping list. There should also be the option to scale the recipe. This will increase / decrease the portions of different ingredients before adding it to your list.
  
Go to grocery list will give you the following commands:
  * List recipeItems gives you a list of all ingredients you currently need to buy. This is aggregated from the recipes you have marked as wanting to make.
  * “Add all to Fridge”  this imports all recipeItems from the grocery list into the fridge and empties the grocery list.
  * “Add to Fridge”  this imports a single  recipeItems from the grocery list into the fridge and removes it from the grocery list.
  
Finally, the Go back command will simply bring you out of the current submenu, or do nothing if you are already at the main menu.
  
When the app is closed the data will be saved and serialized.



## How to Use
This application is a comprehensive, interactive cookbook. The user will open the app and will be presented with a UI offering a number of potential options.

**Fridge**

The user will be able to add ingredients that they have in real life to their virtual fridge by clicking the “add to fridge” button and inputting a string of the ingredient.

**Grocery list**

If there are items missing from their fridge that are needed for a recipe, the  user can add the ingredients to a “Grocery List” by pressing the button “add to grocery list”. This serves as a shopping list that is portable and efficient. Once the user gets the item they can automatically add the item to the Fridge and remove it from the Grocery list. The user can remove them from the grocery list all at once by clicking “Add All To Fridge”,  or one by one by using the “Add to Fridge” button.

**Recipes**

Once the user has added their available ingredients the user will be able to search the recipe list using a number of filters, the app will provide recipes based on the ingredients presented in their fridge.
Each recipe has a list of tags like “Gluten Free” that can be used to filter the recipes. The app will return the “best” recipes for the user to make. The user can click on a recipe to view it’s instructions and it’s ingredients.



## Class Diagram
Phase 0 Class Diagram:
![0001](https://user-images.githubusercontent.com/63621073/141885746-07dbe78e-d42d-4aa4-a46d-8095cc854288.jpg)
Current Class Diagram:
![Screen Shot 2021-11-15 at 9 36 09 PM](https://user-images.githubusercontent.com/63621073/141885633-096ffc8f-f4b5-4d0d-a29a-e010b821a23f.png)


## Major Design Decisions

- **Serialization**
    - In order to save the state of our program we have utilised the generic “rows” that represented our entities raw data and a new set of serializers to transform our entities back into rows.
    - These rows can then be saved to persistent storage by a writer.
    - Since the rows are not tied to a single type of entity, so we only need one writer to save every entity!
- **Android UI**
    - We had decided to get our app running on an Android GUI to allow for more complex menus and user interactions.
    - There was a lot of difficulty in getting the Android SDK, Intellij, and our code base to work together.
    - See Demo of UI here: https://user-images.githubusercontent.com/63621073/141885958-6550067a-2fd5-4a36-be36-8d844f436892.mp4 (Note that the UI will be connected to the backend in Phase 2)

## SOLID Design Principles
- **Single Responsibility Principle**
    - Our classes hold to a single responsibility, usually illustrated in its interface.
    - For instance, entities need to reference other entities but shouldn’t bother with details of loading other entities. Hence, our reference class!
- **Open/Closed Principle**
    - Base entities deal with IDs and concrete classes only add further data to the entities; they don’t change the underlying class.
    - Builders and Serializers subclasses define how to build/serialize an entity. They do not infringe on the base classes methods for iterating these operations.
- **Liskov Substitution Principle**
    - All objects of our superclasses can be replaceable with objects of its subclasses as none of our subclasses are incompatible with their superclasses.
- **Interface Segregation Principle**
    - All Interfaces are relatively small and single focused.
    - For example, our Matchers interface deals with finding relevant recipes. Separately we have a Scorer interface which deals with scoring already relevant recipes.
- **Dependency Inversion Principle**
    - Our High-level modules are unaffected by changes in our low level modules
    - Our high level, matchers, scorers, and middle level entities, storages, do not care about details such as data storage.


## Clean Architecture
- **Entities**
    - Our entities are built through generic Row objects and loaders / writers to keep storage details away from our data.
    - Thus, the entities do not depend on anything when storing and modifying data
- **Command/Response Classes**
    - Command/response classes keep use cases ignorant of the UI behind it.
    - Use cases are given command interfaces to perform actions on.
- **Matchers and Scorers**
    - These high-level objects do not care about implementation of anything other than the interfaces of existing storages and entities.
    - Not the case for the Scorers since they are being designed to have hard-coded values
        - Could potentially include a method in the matchers to return weights, and then overload the Scorer

## Our Use of GitHub Features
- **Issues**
    - We used issues to create a list of tasks that were assigned to group members
    - They could check things off in the checkboxes and use the reply feature to get clarification from other group members
    - <img width="485" alt="Screen Shot 2021-11-15 at 9 52 28 PM" src="https://user-images.githubusercontent.com/63621073/141887205-ff6e1842-17ab-4aac-9e48-98d87e46fedd.png">
- **Branches**
    - Consistently branched off of the main branch to work on individual parts of code
    - Commit messages were always informative and explained what was being changed
    - <img width="1234" alt="Screen Shot 2021-11-15 at 9 54 10 PM" src="https://user-images.githubusercontent.com/63621073/141887365-c78841ef-9734-4435-8e93-7b367a50559b.png">

## Packaging Strategies
- Initially, we started with a strategy which was just everything grouped into related interfaces / functionality. So adhering to Clean Architecture, we packaged things by Feature.
- As a result, this meant parts of the system that worked together may be far apart (IE entity builders and interfaces are separate).
- To combat this, we have since changed to a more nested strategy to keep Components of the system grouped together. IE entities and builders, storages, loaders and writers. Thus, we are still following Clean Architecture by implementing packaging by Components.
- ![Screen Shot 2021-11-15 at 9 57 06 PM](https://user-images.githubusercontent.com/63621073/141887664-7430a5b3-4f86-425f-bf46-7e0ff49fd832.png)

## Design Patterns
- **Facade Design Pattern**
    - In order to lazy load and reference entities we created Referenced entity classes.
    - These are facades for the entity beneath and simply wrap the safe retrieval of lazy loaded entities.
- **Builder Design Pattern**
    - We used this for Entity Construction.
    - By using the Builder design pattern, we were able to construct different immutable objects step by step, and the builder is independent of other objects.

## Refactoring
Some major refactors include:
- Our switch of packaging strategies
- Introduced builders for “intermediate” entities. Lead to significantly easier time loading.
- Later we also extracted common builder interfaces to better help with loading.
- Overhaul of Storage interfaces to utilise the Collections interface.


## Progress Report

Throughout the development of JChef we encountered many obstacles, of which we’ve worked hard to overcome. However, as mentioned earlier, there are many questions our group needs to address in Phase 2. This includes addressing:
- Managing the file structure to correct the build errors. This will help us:
    - Connect the backend to the Android GUI to make the application holistically functional
    - Create a more robust testing system to ensure the application works as intended
    - Allow us to address all IntelliJ warnings and style concerns

In spite of the aforementioned concerns, we believe JChef’s current design to be effective for a multitude of reasons.

Because we followed clean architecture and the SOLID principles our codebase is easy to understand and led to good stratification in terms of levels. Our compartmentalized code base is conducive to scalability and the implementation of new features. As well, general maintenance was easy.

For instance, consider our Recipe Items: This class was turned into two different subclasses in Phase 1, but it didn't affect the rest of the code base as the implementation was done using the same interface.

These principles will allow us to address the shortcomings in Phase 1, resulting in easy testing and future expansion in Phase 2.

Regarding Phase 1 Contributions:
- Ariel worked on creating entities, some storages and matchers, as well as the use cases. Also was responsible for testing all of those things.
- Ayush worked on the Android GUI as well as the design document and progress report
- Derek worked on implementing the loading and serialization of entities as well as the entity referencing system.
- Ezra worked on the RecipeItem implementation and subclasses. Added recipe tag methods.Created use case tests file. Also added Fridge Use Case and tests Created Abstract Response class.
- Gerd worked on creating the Storages and their implementations, Matchers and Scorers.
- Prithee worked on adding additional test cases, and fixing IntelliJ errors. Also was responsible for the design document.

Moving forward:
- Ariel will be responsible for helping combine the GUI with the backend by helping work on commands and responses. Also, will add additional use cases as needed.
- Ayush will help develop the front end for new features (potentially including the Tinder mode) as well as help connect the backend to the front end
- Derek wants to really bring this project together! Get the UI in place and ensure all our code is clean!
- Ezra will be responsible for helping the gui and the backend be implemented. Additionally, he will be creating more use cases and commands.
- Gerd will help to create more use cases, (potentially including the Tinder mode), help further develop the GUI, and implement a fuzzy search for NameMatcher to allow for quantified searches. He will also finish testing for Matchers.
- Prithee will work on additional Use Cases and further developing the frontend Android GUI

Overall, we believe we displayed a strong understanding of software engineering and design principles. We hope to learn from our mistakes in Phase 1 to develop an even stronger display in Phase 2.

(Link to PPT presentation: https://docs.google.com/presentation/d/1Lqw3KSFmbs8vLyHWrczqkFY5zM9V_boDUj9zD5GLEgw/edit?usp=sharing)