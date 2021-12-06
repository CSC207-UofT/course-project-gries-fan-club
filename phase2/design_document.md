# JChef Phase 2 Write Up

## Contents

* [Introduction](#introduction)
* [Updated Specifications](#Updated-specifications)
* [How To Use](#how-to-use)
* [Class Diagram](#class-diagram)
* [Major Design Decisions](#major-design-decisions)
* [SOLID Design Principles](#SOLID-design-principles)
* [Clean Architecture](#clean-architecture)
* [Our Use of GitHub Features](#our-use-of-github-features)
* [Packaging Strategies](#packaging-strategies)
* [Design Patterns](#design-patterns)
* [Refactoring](#refactoring)
* [Testing](#testing)
* [Code walk Through](#code-walk-through)
* [Progress report](#progress-report)

## Introduction
JChef is a comprehensive full stack application that serves as a portable, interactive cookbook and shopping list. In the second phase of our development we were able to link our backend code to a user interface allowing for users to enjoy a convenient Android application that improves efficiency in the kitchen and in the store.

## Updated Specifications
We met our aims from the 1st phase of the applications' development. We were able to unify our grocery list and fridge command. We added commands that improve the users accessibility and are more efficient.
We implemented a scrolling list for all our storages to improve the accessibility. 



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
Phase 1 Class Diagram:
![Screen Shot 2021-11-15 at 9 36 09 PM](https://user-images.githubusercontent.com/63621073/141885633-096ffc8f-f4b5-4d0d-a29a-e010b821a23f.png)
phase 2 class Diagram

## Major Design Decisions
In the home stretch of development for our application we were largely content with our design from phase 1. 

We made decisions regarding the following:

- **Serialization**
    - In order to save the state of our program we have utilised the generic “rows” that represented our entities raw data and a new set of serializers to transform our entities back into rows.
    - These rows can then be saved to persistent storage by a writer.
    - Since the rows are not tied to a single type of entity, so we only need one writer to save every entity!


- **Android UI**
    
    - We had decided to get our app running on an Android GUI to allow for more complex menus and user interactions.
    - There was a lot of difficulty in getting the Android SDK, Intellij, and our code base to work together.
    - See Demo of UI here: https://user-images.githubusercontent.com/63621073/141885958-6550067a-2fd5-4a36-be36-8d844f436892.mp4 (Note that the UI will be connected to the backend in Phase 2)


- **Applying Decorator Pattern**

  - We decided that the abstraction of our RecipeItem class created redundant code and was violating the open close principal. 
  - We decided to shift to the decorator design pattern. This allows for specific display behavior for different types of RecipeItems.
  - This allows for new units of measurement to be easily added to the application.


## SOLID Design Principles
- **Single Responsibility Principle**
    - Our classes hold to a single responsibility, usually illustrated in its interface.
    - For instance, entities need to reference other entities but shouldn’t bother with details of loading other entities. Hence, our reference class!
- **Open/Closed Principle**
    - Base entities deal with IDs and concrete classes only add further data to the entities; they don’t change the underlying class.
    - Builders and Serializers subclasses define how to build/serialize an entity. They do not infringe on the base classes methods for iterating these operations.
    - Our decorator class allows for new units of measurement to be added to the application. 
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
- **New Issues**
  - Taking feedback from phase 1 we created new issues that specifically outlines tasks that would improve the project. 

## Packaging Strategies
- Initially, we started with a strategy which was just everything grouped into related interfaces / functionality. So adhering to Clean Architecture, we packaged things by Feature.
- As a result, this meant parts of the system that worked together may be far apart (IE entity builders and interfaces are separate).
- To combat this, we have since changed to a more nested strategy to keep Components of the system grouped together. IE entities and builders, storages, loaders and writers. Thus, we are still following Clean Architecture by implementing packaging by Components.
- ![Screen Shot 2021-11-15 at 9 57 06 PM](https://user-images.githubusercontent.com/63621073/141887664-7430a5b3-4f86-425f-bf46-7e0ff49fd832.png)

## Design Patterns
- **Facade Design Pattern**
    - In order to lazy load and reference entities we created a Referenced entity classes.
    - These are facades for the entity beneath and simply wrap the safe retrieval of lazy loaded entities.
- **Builder Design Pattern**
    - We used this for Entity Construction.
    - By using the Builder design pattern, we were able to construct different immutable objects step by step, and the builder is independent of other objects.
- **Decorator Design Pattern**
  - We used this to reduce the redundancy in code, we changed an abstract class with multiple subclasses to a single decorator class for the RecipeItem. 
  - This allows for specific display behaviour to be demonstrated when needed. For example RecipeItem, can be displayed using grams, ml or a quantity amount.

## Refactoring
Some major refactors include:
- Our switch of packaging strategies
- Introduced builders for “intermediate” entities. Lead to significantly easier time loading.
- Later we also extracted common builder interfaces to better help with loading.
- Overhaul of Storage interfaces to utilise the Collections interface.
- In phase 2 we Had to change our project structure and our CI to allow the UI to compile with our backend. 

## Testing
We have extensive testing, covering nearly all our classes with more than one test. We used test
driven architecture which allowed for a significant amount of testing. 

##Code Walk Through
This aims to serve a detailed technical explanation of our code and that explains how the application functions.

**Back End**

The application's code starts with a JSON file loader, that be passed a JSON files. The loader will read the files and
call the serializer. The serializer will convert all the json objects to their IDs which can then be passed to the builders.
The builders will build the storages and will fill them with the objects from the Json file. For example: The builder will 
build a RecipeStorage object and populate it with serialized Recipe objects.

This process will be initiated upon the application start up.

Once the Storages have been created and each of the Recipe objects, Ingredient Objects, RecipeItem Objects, 
Tag Objects have been created, the Application is functional. 
There are 4 UseCase classes which all execute different commands that the user can initiate from the GUI. 

The list of commands are outlined in our specifications. Each UseCase returns a response. The response is a hashmap 
that contains the data linked to a key. The GUI can then use a specific key to access the relevant data. For example: 
if the user wished to add an ingredient apple to their fridge the Use case will take in the ingredient and add it to the 
RecipeStorage called Fridge. The use case will the return a hashMap like {...Fridge="apple"...}. 

The GUI interacts with the UseCases through a controller layer. This layer serves as the nexus between the front end and 
the beck end. It calls the UseCases and supplies them with the necessary parameters to innate the command, and then provides\
the response to the GUI. 

The various use cases interact with multiple entity, matcher, scorer interfaces to complete the commands. 




## Progress Report

Throughout the development of JChef we encountered many obstacles, of which we’ve worked hard to overcome. However, as mentioned earlier, there are many questions our group addressed in Phase 2. This includes addressing:
- Managing the file structure to correct the build errors. This will help us:
    - Connect the backend to the Android GUI to make the application holistically functional
    - Create a more robust testing system to ensure the application works as intended
    - Allow us to address all IntelliJ warnings and style concerns

In spite of the aforementioned concerns, we believe JChef’s current design to be effective for a multitude of reasons.

Because we followed clean architecture and the SOLID principles, as mentioned before, our codebase is easy to understand and led to good stratification in terms of levels. Our compartmentalized code base is conducive to scalability and the implementation of new features. As well, general maintenance was easy.

For instance, consider our Recipe Items: This class was turned into two different subclasses in Phase 1, but it didn't affect the rest of the code base as the implementation was done using the same interface.

These principles will allow us to address the shortcomings in Phase 1. This was then changed in phase 2 again to decorator design pattern. 

**Regarding Phase 2 Contributions:**
- Ariel: Refactored the use cases, refactored the responseImpl class and create the controllers. 
  - significant PR :
- Ayush: Worked on the Android GUI redesigning some components and hooking it up to the back end.
    - significant PR:
- Derek: Did a lot of general work reviewing code and looking at the architecture of the program. The accessibility Documents.
  - significant PR:
- Ezra: The Design Doc and the Presentation. Helped Ariel with the use cases, created the presentation. 
    - significant PR:
- Gerd: created a decorator design pattern for the recipeItem, refactored a large amount of concluding the matchers and scored and all the associated tests we remade. He also fixed the builders.
    - significant PR:
- Prithee: Worked on the Android GUI redesigning some components and hooking it up to the back end, added the Grocery list use case.
    - significant PR
      
**Reflection Moving Forward:**
* Having an API connected to our application with lists of recipes and ingredients
* We wish we could have added photos to our recipes
* We wish we could have implemented our Tinder like function for the application when searching for recipes. 


