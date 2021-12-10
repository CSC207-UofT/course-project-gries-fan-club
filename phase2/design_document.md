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

For a full list of specifications look here. https://github.com/CSC207-UofT/course-project-gries-fan-club/blob/main/phase2/specification.md  



## How to Use
This application is a comprehensive, interactive cookbook. The user will open the app and will be presented with a UI offering a number of potential options.

**Fridge**

The user will be able to add ingredients that they have in real life to their virtual fridge by clicking the “add to fridge” button and inputting a string of the ingredient.

**Grocery list**

If there are items missing from their fridge that are needed for a recipe, the  user can add the ingredients to a “Grocery List” by pressing the button “add to grocery list”. This serves as a shopping list that is portable and efficient. Once the user gets the item they can automatically add the item to the Fridge and remove it from the Grocery list. The user can remove them from the grocery list all at once by clicking “Add All To Fridge”,  or one by at a time using the “Add to Fridge” button.

**Recipes**

Once the user has added their available ingredients the user will be able to search the recipe list using a number of filters, the app will provide recipes based on the ingredients presented in their fridge.
Each recipe has a list of tags like “Gluten Free” that can be used to filter the recipes. The app will return the “best” recipes for the user to make. The user can click on a recipe to view the instructions, and it’s ingredients.



## Class Diagram
Phase 0 Class Diagram:
![0001](https://user-images.githubusercontent.com/63621073/141885746-07dbe78e-d42d-4aa4-a46d-8095cc854288.jpg)
Phase 1 Class Diagram:
![Screen Shot 2021-11-15 at 9 36 09 PM](https://user-images.githubusercontent.com/63621073/141885633-096ffc8f-f4b5-4d0d-a29a-e010b821a23f.png)
phase 2 class Diagram 
![img.png](img.png)

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
  - (ue to compatibility issues and the lateness of this addition, this architecture was not included in our final main branch)


- **New Development Workflow**

  - We utilised a new development workflow to better sniff out clean architecture violations.
  - When a problem was found, we first create an issue describing the problem and proposing a solution before writing any code.
  - After the solution is discussed and agreed upon, then someone would pick it up and implement our solution.
  - This helped to ensure we had strong and simple solutions that didn't further muck up our architecture.

## SOLID Design Principles
- **Single Responsibility Principle**
  - When designing our classes originally we were adamant to remember the SRP and as such have all classes kept to a contained responsibility.
  - In a class like `JSONFileIO` we had to debate whether there were multiple responsibilities at play. The class was a loader and writer for JSON files.
  - Some thought it should only load or only write and that these were separate responsibilities.
  - Others thought that since the action of reading and writing JSON are so closely related they only change for the same reasons. This is what we have decided on for now.
- **Open/Closed Principle**
  - A specific show our adherence to this principle is in our new decorator pattern for displaying recipe items. We needed to have an easy way to create different displays (such as changing units) but did not want to constantly create subclasses of recipe items to change the displays.
  - So, we replaced the display with a delegated display object which meant we could leave the initial set up for displaying intact and instead just describe the method of display rather than replacing the existing setup.
- **Liskov Substitution Principle**
  - During phase 2, we identified a violations of LSP within JChef which we have fixed. We did not identify any other violations.
  - The error was within the Response class. Subclasses of this were overriding methods incorrectly which meant they would not act correctly as a response. We fixed this by going through each subclass and removing these faulty implementations. See #77 and #79.
- **Interface Segregation Principle**
  - As part of our work on the SRP, we have in effect kept interfaces small as well. If we were to add too many moving parts to interfaces we noticed that our classes began to take on more work.
  - This alerted us to issues of ISP before they could even be.
  - As well, by splitting interfaces often, we could have clients using those interfaces use more abstract interfaces as often as possible.
- **Dependency Inversion Principle**
  - 
  ![Entity Diagram](EntityDiagram.png)
  - Here is a snippet from parts of our high level matchers.
  - In this case, we can see that the Tag dependency has been inverted so that the matcher does not know about the underlying implementation of the Tag class.
  - Inversions like this exist all throughout our dependency tree.


## Clean Architecture
Let's talk about a walkthrough through a typical run of our program to illustrate some of the moving clean architecture parts.

- Our system is loaded
  - Services like a database or UI are created by the user and given a controller in charge of setting up JChef's internal services.
- The user issues a command
  - A command object is created and filled with appropriate data and given to a controller to execute this command.
  - This controller looks at what command is given and creates a use case to execute it.
  - The controller must also gather the appropriate internal services from JChef in order for the use case to run (for instance, our storages).
  - Finally, the controller delegates to the use case to run.
- Within the use case
  - Because the services of the use case are injected by a controller, our use case does not know about the implementation of details like our storages, databases, or front-end.
  - This means the use case can focus on orchestrating our high level matchers and scorers to accomplish the users command. Perhaps this means calling using a matcher to search the storages for appropriate recipes.
- Back to the controllers
  - Once our use case has completed its task, it returns its data to the controller.
  - This data is processed by the controller before being given back to the appropriate caller, in this case the front-end to display the task.

This should show how data moves through the different layers of clean architecture within our project.

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
  - We used this to reduce the redundancy in code. We changed an abstract class with multiple subclasses to a single RecipeItem with a decorator class for the types of RecipeItems
  - This allows for specific display behaviour to be demonstrated when needed. For example RecipeItem, can be displayed using grams, ml or a quantity amount.
  - Due to compatibility issues and the lateness of this addition, this architecture was not included in our final main branch

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

## Code Walk Through
This aims to serve a detailed technical explanation of our code and how the application functions.

**Back End**

The application's code starts with a JSON file loader, that be passed JSON files containing the ingredients and their information.
The loader will read the files and call the serializer. The serializer will convert all the JSON objects to their
IDs which can then be passed to the builders. The builders will build the storages and will fill them with the objects
from the JSON file. For example: The builder will build a RecipeStorage object and populate it with serialized Recipe objects.

This process will be initiated upon the application start up.

Once the Storages have been created and each of the Recipe objects, Ingredient Objects, RecipeItem Objects, 
Tag Objects have been created, the Application is functional. 
There are 4 UseCase classes which all execute different commands that the user can initiate from the GUI. 

The list of commands are outlined in our specifications. Each UseCase returns a response. The response is a generic List 
populated with the appropriate responses. This is then passed to the controller back to the GUI. For example: 
if the user wished to add an ingredient apple to their fridge the UseCase will take in the ingredient and add it to the 
RecipeStorage called Fridge.

The GUI interacts with the UseCases through a controller layer. This layer serves as the nexus between the front end and 
the back end. It calls the UseCases and supplies them with the necessary parameters to initiate the command, and then provides
the response to the GUI. 

The various use cases interact with multiple entity, matcher, scorer interfaces to complete the commands.

An example is when a recipe is matched with ingredients from IngredientStorage. The Matcher is able to match parameters like
Tags, Name, and Ingredients, and using a scorer, it is able to suggest the most relevant recipes according to the Matchers and
Scorers. The run method in the MatcherUseCase uses the return10Recipes according to the User's Fridge and the given recipe.
